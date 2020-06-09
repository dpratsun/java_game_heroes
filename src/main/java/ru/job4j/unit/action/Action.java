package ru.job4j.unit.action;

import ru.job4j.unit.Unit;

public interface Action {

    Unit execute(Unit attacker, Unit target);
}
