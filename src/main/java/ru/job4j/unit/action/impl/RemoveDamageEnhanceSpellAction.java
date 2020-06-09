package ru.job4j.unit.action.impl;

import ru.job4j.unit.Unit;
import ru.job4j.unit.action.AttackSpellAction;
import ru.job4j.unit.action.EnemyAction;
import ru.job4j.unit.factory.UnitDecoratorFactory;

public class RemoveDamageEnhanceSpellAction implements EnemyAction, AttackSpellAction {
    private final UnitDecoratorFactory factory;

    public RemoveDamageEnhanceSpellAction(UnitDecoratorFactory factory) {
        this.factory = factory;
    }

    @Override
    public Unit execute(Unit attacker, Unit target) {
        Unit decorated = factory.build(target);
        return decorated;
    }

    @Override
    public String description(Unit enhancer, Unit target) {
        return enhancer.getName() + " removed " + target.getName() + " damage enhancement.";
    }
}
