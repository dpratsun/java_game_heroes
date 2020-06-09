package ru.job4j.unit.factory;

import ru.job4j.unit.Unit;

public interface UnitDecoratorFactory {
    Unit build(Unit unit);
}
