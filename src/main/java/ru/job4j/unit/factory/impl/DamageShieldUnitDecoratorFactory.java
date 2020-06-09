package ru.job4j.unit.factory.impl;

import ru.job4j.unit.Unit;
import ru.job4j.unit.factory.UnitDecoratorFactory;
import ru.job4j.unit.impl.decorator.DamageShiledUnitDecorator;

public class DamageShieldUnitDecoratorFactory implements UnitDecoratorFactory {
    @Override
    public Unit build(Unit unit) {
        return new DamageShiledUnitDecorator(unit);
    }
}
