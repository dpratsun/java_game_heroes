package ru.job4j.army.impl;

import ru.job4j.army.Army;
import ru.job4j.unit.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RandomArmy implements Army {
    private final List<Unit> army = new ArrayList<>();

    private final Function<Integer, Integer> random;

    public RandomArmy(Function<Integer, Integer> random) {
        this.random = random;
    }

    @Override
    public void addUnit(Unit unit) {
        army.add(unit);
    }

    @Override
    public boolean isLoose() {
        return army.stream().noneMatch(u -> u.getHealth() > 0);
    }

    @Override
    public Unit getAttacker() {
        var privilegedUnits = army.stream()
                .filter(Unit::isPrivileged)
                .collect(Collectors.toList());

        return privilegedUnits.size() > 0
                ? privilegedUnits.get(random.apply(privilegedUnits.size()))
                : army.get(random.apply(army.size()));
    }

    @Override
    public Unit getTarget() {
        return army.get(random.apply(army.size()));
    }
}
