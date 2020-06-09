package ru.job4j.unit.action.impl;

import ru.job4j.unit.Unit;
import ru.job4j.unit.action.AlliesAction;
import ru.job4j.unit.action.AttackSpellAction;
import ru.job4j.unit.factory.UnitDecoratorFactory;

public class EnhanceDamageSpellAction implements AlliesAction, AttackSpellAction {
    private final UnitDecoratorFactory factory;

    public EnhanceDamageSpellAction(UnitDecoratorFactory factory) {
        this.factory = factory;
    }

    @Override
    public Unit execute(Unit attacker, Unit target) {
        Unit decorated = factory.build(target);
        return decorated;
    }

    @Override
    public String description(Unit enhancer, Unit target) {
        return enhancer.getName() + " enhanced " + target.getName() + " damage.";
    }
}
