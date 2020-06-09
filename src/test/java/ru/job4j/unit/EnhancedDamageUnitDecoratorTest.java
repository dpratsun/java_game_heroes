package ru.job4j.unit;

import org.junit.Test;
import ru.job4j.unit.impl.BaseUnit;
import ru.job4j.unit.impl.decorator.EnhancedDamageUnitDecorator;

import java.util.Collections;

import static org.junit.Assert.*;

public class EnhancedDamageUnitDecoratorTest {
    private final double TEST_ENHANCE_AMOUNT = 1.5;

    @Test
    public void whenGetEnhanceAmountThanValueShouldBeDifferentFromDefault() {
        var decorated = new EnhancedDamageUnitDecorator(
                new BaseUnit(Collections.emptyList(), ""),
                TEST_ENHANCE_AMOUNT
        );

        assertTrue(decorated.getActionEnhanceAmount() > Unit.DEFAULT_ENHANCE_AMOUNT);
    }
}