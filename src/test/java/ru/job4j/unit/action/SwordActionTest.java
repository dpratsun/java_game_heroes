package ru.job4j.unit.action;

import org.junit.Test;
import ru.job4j.unit.Unit;
import ru.job4j.unit.action.impl.SwordAction;

import static org.mockito.Mockito.*;

public class SwordActionTest {
    private final int TEST_DAMAGE = 1;

    @Test
    public void whenExecuteThanTargetDecreaseHealthShouldBeInvoked() {
        var action = new SwordAction(TEST_DAMAGE);
        var attacker = mock(Unit.class);
        when(attacker.getActionEnhanceAmount()).thenReturn(Unit.DEFAULT_ENHANCE_AMOUNT);
        var target = mock(Unit.class);

        action.execute(attacker, target);

        verify(target).decreaseHealth(TEST_DAMAGE * attacker.getActionEnhanceAmount());
    }
}