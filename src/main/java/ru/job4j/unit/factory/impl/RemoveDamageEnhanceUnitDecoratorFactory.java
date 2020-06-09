package ru.job4j.unit.factory.impl;

import ru.job4j.unit.Unit;
import ru.job4j.unit.factory.UnitDecoratorFactory;
import ru.job4j.unit.impl.decorator.RemovedDamageEnhanceUnitDecorator;

public class RemoveDamageEnhanceUnitDecoratorFactory implements UnitDecoratorFactory {
    private final double times;

    public RemoveDamageEnhanceUnitDecoratorFactory(double times) {
        this.times = times;
    }

    @Override
    public Unit build(Unit unit) {
        return new RemovedDamageEnhanceUnitDecorator(unit);
    }
}
