package ru.job4j.unit.impl;

import ru.job4j.logger.impl.SingletonLoggerManager;
import ru.job4j.unit.Unit;
import ru.job4j.unit.action.Action;
import ru.job4j.unit.action.AttackSpellAction;
import ru.job4j.unit.action.SpellAction;
import ru.job4j.unit.action.impl.EnhanceDamageSpellAction;

import java.util.ArrayList;
import java.util.List;

public class BaseUnit implements Unit {
    private final List<SpellAction> defenceSpellActions = new ArrayList<>();
    private final List<SpellAction> attackSpellActions = new ArrayList<>();
    private final List<Action> actions;
    private final String name;
    private double health = 100.0;

    public BaseUnit(List<Action> actions, String name) {
        this.name = name;
        this.actions = actions;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void decreaseHealth(double amount) {
        health -= amount;
        String message = "Damage amount is " + amount + ". " + getName() +
                (health <= 0 ? " is dead." : " health after attack is " + health + " hp.");
        SingletonLoggerManager.getInstance().log(message);
    }

    @Override
    public void attack(Action action, Unit target) {
        if (action instanceof SpellAction) {
            SingletonLoggerManager.getInstance().log(((SpellAction) action).description(this, target));
            target.castSpell((SpellAction) action);
            return;
        }
        action.execute(this.prepareForAttack(), target.prepareForDefence());
    }

    @Override
    public Unit prepareForDefence() {
        return decorate(defenceSpellActions);
    }

    @Override
    public Unit prepareForAttack() {
        return decorate(attackSpellActions);
    }

    @Override
    public boolean isPrivileged() {
        return attackSpellActions.stream().anyMatch(a -> a instanceof EnhanceDamageSpellAction);
    }

    @Override
    public void castSpell(SpellAction spell) {
        if (spell instanceof AttackSpellAction) {
            attackSpellActions.add(spell);
            return;
        }
        defenceSpellActions.add(spell);
    }

    @Override
    public List<Action> getActions() {
        return actions;
    }

    private Unit decorate(List<SpellAction> actions) {
        Unit decorated = this;
        for (SpellAction spell: actions) {
            decorated = ((Action) spell).execute(null, decorated);
        }
        actions.clear();
        return decorated;
    }
}
