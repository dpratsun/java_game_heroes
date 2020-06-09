package ru.job4j.unit.action.impl;

import ru.job4j.unit.Unit;
import ru.job4j.unit.action.AlliesAction;
import ru.job4j.unit.action.DefenceSpellAction;
import ru.job4j.unit.factory.UnitDecoratorFactory;

public class DamageShieldSpellAction implements AlliesAction, DefenceSpellAction {
    private final UnitDecoratorFactory factory;

    public DamageShieldSpellAction(UnitDecoratorFactory factory) {
        this.factory = factory;
    }

    @Override
    public Unit execute(Unit attacker, Unit target) {
        Unit decorated = factory.build(target);
        return decorated;
    }

    @Override
    public String description(Unit enhancer, Unit target) {
        return enhancer.getName() + " add shield to " + target.getName() + ".";
    }
}
