package ru.job4j.army;

import ru.job4j.unit.Unit;

public interface Army {
    void addUnit(Unit unit);
    boolean isLoose();
    Unit getAttacker();
    Unit getTarget();
}
