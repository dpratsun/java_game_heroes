package ru.job4j.unit.action;

import ru.job4j.unit.Unit;

public interface SpellAction {
    String description(Unit enhancer, Unit target);
}
