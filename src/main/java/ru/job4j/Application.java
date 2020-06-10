package ru.job4j;

import ru.job4j.army.impl.RandomArmy;
import ru.job4j.game.impl.ConsoleRandomBattle;
import ru.job4j.logger.impl.ConsoleLogger;
import ru.job4j.logger.impl.SingletonLoggerManager;
import ru.job4j.unit.action.impl.*;
import ru.job4j.unit.factory.impl.DamageShieldUnitDecoratorFactory;
import ru.job4j.unit.factory.impl.EnhancedDamageUnitDecoratorFactory;
import ru.job4j.unit.factory.impl.RemoveDamageEnhanceUnitDecoratorFactory;
import ru.job4j.unit.impl.BaseUnit;
import ru.job4j.unit.impl.elf.ElfMagicianUnit;
import ru.job4j.unit.impl.human.WarriorUnit;
import ru.job4j.unit.impl.necromat.NecromatMagicianUnit;

import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        SingletonLoggerManager.getInstance().subscribe(new ConsoleLogger());

        RandomArmy humansElfs = new RandomArmy(bound -> bound > 1 ? new Random().nextInt(bound) : 0);
        humansElfs.addUnit(new ElfMagicianUnit(
                new BaseUnit(
                        List.of(
                                new EnhanceDamageSpellAction(new EnhancedDamageUnitDecoratorFactory(1.5)),
                                new DamageShieldSpellAction(new DamageShieldUnitDecoratorFactory()),
                                new AttackBySpellAction(10)
                        ),
                        "ElfMagician"
                )
        ));
        humansElfs.addUnit(new WarriorUnit(new BaseUnit(List.of(new SwordAction(15)), "Warrior")));

        RandomArmy orksNecromants = new RandomArmy(bound -> bound > 1 ? new Random().nextInt(bound) : 0);
        orksNecromants.addUnit(new NecromatMagicianUnit(
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
