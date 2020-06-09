package ru.job4j.unit.impl.elf;

import ru.job4j.unit.Unit;
import ru.job4j.unit.action.Action;
import ru.job4j.unit.action.SpellAction;

import java.util.List;

public class ElfMagician implements Unit {
    private final static String NAME = "Elf Magician";
    private final Unit decorated;

    public ElfMagician(Unit decorated) {
        this.decorated = decorated;
    }

    @Override
    public double getHealth() {
        return decorated.getHealth();
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void decreaseHealth(double amount) {
        decorated.decreaseHealth(amount);
    }

    @Override
    public void attack(Action action, Unit target) {
        decorated.attack(action, target);
    }

    @Override
    public Unit prepareForDefence() {
        return decorated.prepareForDefence();
    }

    @Override
    public Unit prepareForAttack() {
        return decorated.prepareForAttack();
    }

    @Override
    public boolean isPrivileged() {
        return decorated.isPrivileged();
    }

    @Override
    public void castSpell(SpellAction spell) {
        decorated.castSpell(spell);
    }

    @Override
    public List<Action> getActions() {
        return decorated.getActions();
    }

    @Override
    public double getActionEnhanceAmount() {
        return decorated.getActionEnhanceAmount();
    }
}
