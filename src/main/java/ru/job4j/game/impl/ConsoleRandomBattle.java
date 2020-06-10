package ru.job4j.game.impl;

import ru.job4j.army.Army;
import ru.job4j.game.Game;
import ru.job4j.unit.Unit;
import ru.job4j.unit.action.Action;
import ru.job4j.unit.action.EnemyAction;

import java.util.Random;

public class ConsoleRandomBattle implements Game {

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

            var target = getTarget(action);

            attacker.attack(action, target);

            firstMove = !firstMove;
        }
    }

    private Action getAttackerAction(Unit attacker) {
        var actions = attacker.getActions();
        return actions.get(actions.size() > 1 ? new Random().nextInt(actions.size()) : 0);
    }

    private Unit getTarget(Action action) {
        Unit target;
        if (action instanceof EnemyAction) {
            target = firstMove ? second.getTarget() : first.getTarget();
        } else {
            target = firstMove ? first.getTarget() : second.getTarget();
        }
        return target;
    }
}
