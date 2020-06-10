package ru.job4j.unit.action;

import org.junit.Test;
import ru.job4j.unit.Unit;
import ru.job4j.unit.action.impl.EnhanceDamageSpellAction;
import ru.job4j.unit.factory.UnitDecoratorFactory;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EnhanceDamageSpellActionTest {

    @Test
    public void whenExecuteThanFactoryBuildMethodShouldBeInvoked() {
        UnitDecoratorFactory factory = mock(UnitDecoratorFactory.class);
        var action = new EnhanceDamageSpellAction(factory);
        var target = mock(Unit.class);

        action.execute(mock(Unit.class), target);

        verify(factory).build(target);
    }
}