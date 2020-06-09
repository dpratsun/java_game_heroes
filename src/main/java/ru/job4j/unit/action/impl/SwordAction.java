package ru.job4j.unit.action.impl;

import ru.job4j.logger.LoggerManager;
import ru.job4j.logger.impl.SingletonLoggerManager;
import ru.job4j.unit.Unit;
import ru.job4j.unit.action.EnemyAction;

import static java.lang.String.format;

public class SwordAction implements EnemyAction {
    private final String MESSAGE_TMPL = "%s attacking %s with sword.";
    private final String MESSAGE_ACTION_ENHANCED = "%s sword damage enhanced to %s";

    private final LoggerManager logger = SingletonLoggerManager.getInstance();
    private final int damage;

    public SwordAction(int damage) {
        this.damage = damage;
    }

    @Override
    public Unit execute(Unit attacker, Unit target) {
        if (attacker.getActionEnhanceAmount() > attacker.DEFAULT_ENHANCE_AMOUNT) {
            logger.log(format(MESSAGE_ACTION_ENHANCED, attacker.getName(), damage * attacker.getActionEnhanceAmount()));
        }
        logger.log(format(MESSAGE_TMPL, attacker.getName(), target.getName(), target.getName(), target.getHealth()));
        target.decreaseHealth(damage * attacker.getActionEnhanceAmount());
        return target;
    }
}
