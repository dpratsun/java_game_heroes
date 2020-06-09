package ru.job4j.logger;

import org.junit.Test;
import ru.job4j.logger.impl.SingletonLoggerManager;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SingletonLoggerManagerTest {
    private final static String TEST_MESSAGE = "Test";

    @Test
    public void whenGetInstanceShouldReturnSameObjects() {
        var instance1 = SingletonLoggerManager.getInstance();
        var instance2 = SingletonLoggerManager.getInstance();

        assertThat(instance1, is(instance2));
    }

    @Test
    public void whenLogMethodInvokedAndPresentListenerThanListenerLogMethodShouldBeInvoked() {
        Logger listener = mock(Logger.class);
        var instance = SingletonLoggerManager.getInstance();
        instance.subscribe(listener);

        instance.log(TEST_MESSAGE);

        verify(listener).log(TEST_MESSAGE);
    }
}