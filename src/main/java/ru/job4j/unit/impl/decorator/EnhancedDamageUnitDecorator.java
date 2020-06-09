package ru.job4j.unit.impl.decorator;

import ru.job4j.unit.Unit;
import ru.job4j.unit.action.Action;
import ru.job4j.unit.action.SpellAction;

import java.util.List;

public class EnhancedDamageUnitDecorator implements Unit {
    private final Unit decorated;
    private final double actionEnhanceAmount;

    public EnhancedDamageUnitDecorator(Unit decorated, double actionEnhanceAmount) {
        this.decorated = decorated;
        this.actionEnhanceAmount = actionEnhanceAmount;
    }

    @Override
    public String getName() {
        return decorated.getName();
    }

    @Override
    public double getHealth() {
        return decorated.getHealth();
    }

    @Override
    public double getActionEnhanceAmount() { return actionEnhanceAmount; }

    @Override
    public void decreaseHealth(double amount) {
        decorated.decreaseHealth(amount);
    }

    @Override
    public void attack(Action action, Unit target) {
        decorated.attack(action, target);
    }

    @Override
    public Unit prepareForDefence() {
        return decorated.prepareForDefence();
    }

    @Override
    public Unit prepareForAttack() {
        return decorated.prepareForAttack();
    }

    @Override
    public boolean isPrivileged() {
        return decorated.isPrivileged();
    }

    @Override
    public void castSpell(SpellAction spell) {
        decorated.castSpell(spell);
    }

    @Override
    public List<Action> getActions() {
        return decorated.getActions();
    }
}
