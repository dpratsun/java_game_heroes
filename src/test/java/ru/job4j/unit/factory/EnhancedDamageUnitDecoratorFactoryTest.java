package ru.job4j.unit.factory;

import org.junit.Test;
import ru.job4j.unit.Unit;
import ru.job4j.unit.factory.impl.EnhancedDamageUnitDecoratorFactory;
import ru.job4j.unit.impl.decorator.EnhancedDamageUnitDecorator;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class EnhancedDamageUnitDecoratorFactoryTest {
    @Test
    public void whenBuildMethodInvokedThanDecoratedObjectShouldBeReturned() {
        var unit = mock(Unit.class);

        var decorated = new EnhancedDamageUnitDecoratorFactory(0).build(unit);

        assertTrue(decorated instanceof EnhancedDamageUnitDecorator);
    }
}