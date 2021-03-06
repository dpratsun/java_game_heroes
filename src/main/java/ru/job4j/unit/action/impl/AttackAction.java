package ru.job4j.unit.action.impl;

import ru.job4j.unit.Unit;
import ru.job4j.unit.action.EnemyAction;
import ru.job4j.logger.LoggerManager;
import ru.job4j.logger.impl.SingletonLoggerManager;

import static java.lang.String.format;

public class AttackAction implements EnemyAction {
    private final String MESSAGE_TMPL = "%s attacking %s.";
    private final String MESSAGE_ACTION_ENHANCED = "%s attack damage enhanced to %s";
    private final LoggerManager logger = SingletonLoggerManager.getInstance();
    private final int damage;

    public AttackAction(int damage) {
        this.damage = damage;
    }

    @Override
    public Unit execute(Unit attacker, Unit target) {
        if (attacker.getActionEnhanceAmount() > attacker.DEFAULT_ENHANCE_AMOUNT) {
            logger.log(format(MESSAGE_ACTION_ENHANCED, attacker.getName(), damage * attacker.getActionEnhanceAmount()));
        }
        logger.log(format(MESSAGE_TMPL, attacker.getName(), target.getName()));
        target.decreaseHealth(damage * attacker.getActionEnhanceAmount());
        return target;
    }
}
