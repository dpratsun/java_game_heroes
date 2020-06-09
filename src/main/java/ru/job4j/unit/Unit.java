package ru.job4j.unit;

import ru.job4j.unit.action.Action;
import ru.job4j.unit.action.SpellAction;

import java.util.List;

public interface Unit {
    double DEFAULT_ENHANCE_AMOUNT = 1.0;

    double getHealth();
    String getName();

    void decreaseHealth(double amount);

    void attack(Action action, Unit target);
    void castSpell(SpellAction spell);

    Unit prepareForAttack();
    Unit prepareForDefence();

    boolean isPrivileged();

    List<Action> getActions();

    default double getActionEnhanceAmount() {
        return DEFAULT_ENHANCE_AMOUNT;
    }
}
