package ru.job4j;

import ru.job4j.army.Army;
import ru.job4j.army.impl.RandomArmy;
import ru.job4j.game.Game;
import ru.job4j.logger.impl.ConsoleLogger;
import ru.job4j.logger.impl.SingletonLoggerManager;
import ru.job4j.unit.Unit;
import ru.job4j.unit.action.Action;
import ru.job4j.unit.action.EnemyAction;
import ru.job4j.unit.action.impl.*;
import ru.job4j.unit.factory.impl.EnhancedDamageUnitDecoratorFactory;
import ru.job4j.unit.factory.impl.RemoveDamageEnhanceUnitDecoratorFactory;
import ru.job4j.unit.factory.impl.DamageShieldUnitDecoratorFactory;
import ru.job4j.unit.impl.BaseUnit;
import ru.job4j.unit.impl.elf.ElfMagician;
import ru.job4j.unit.impl.human.Warrior;
import ru.job4j.unit.impl.necromat.NecromatMagician;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class ConsoleRandomBattle implements Game {
    private final static Function<Integer, Integer> randomWithBound =
            bound -> bound > 1 ? new Random().nextInt(bound) : 0;

    private final Army first;
    private final Army second;
    private boolean firstMove = true;

    public ConsoleRandomBattle(Army first, Army second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void start() {
        while (!first.isLoose() && !second.isLoose()) {
            Unit attacker = firstMove ? first.getAttacker() : second.getAttacker();

            var action = getAttackerAction(attacker);

            var target = getTarget(attacker, action);

            attacker.attack(action, target);

            firstMove = !firstMove;
        }
    }

    private Action getAttackerAction(Unit attacker) {
        var actions = attacker.getActions();
        return actions.get(randomWithBound.apply(actions.size()));
    }

    private Unit getTarget(Unit attacker, Action action) {
        Unit target = null;
        if (action instanceof EnemyAction) {
            target = firstMove ? second.getTarget() : first.getTarget();
        } else {
            while (target == null || target.equals(attacker)) {
                target = firstMove ? first.getTarget() : second.getTarget();
            }
        }
        return target;
    }

    public static void main(String[] args) {
        SingletonLoggerManager.getInstance().subscribe(new ConsoleLogger());

        RandomArmy humansElfs = new RandomArmy(randomWithBound);
        humansElfs.addUnit(new ElfMagician(
                new BaseUnit(
                        List.of(
                                new EnhanceDamageSpellAction(new EnhancedDamageUnitDecoratorFactory(1.5)),
                                new DamageShieldSpellAction(new DamageShieldUnitDecoratorFactory()),
                                new AttackBySpellAction(10)
                        ),
                        "ElfMagician"
                )
        ));
        humansElfs.addUnit(new Warrior(new BaseUnit(List.of(new SwordAction(15)), "Warrior")));

        RandomArmy orksNecromants = new RandomArmy(randomWithBound);
        orksNecromants.addUnit(new NecromatMagician(
                new BaseUnit(
                        List.of(
                                new RemoveDamageEnhanceSpellAction(new RemoveDamageEnhanceUnitDecoratorFactory(1.5)),
                                new AttackAction(5)
                        ),
                        "Necromat Magician"
                )
        ));

        new ConsoleRandomBattle(humansElfs, orksNecromants).start();
    }
}
