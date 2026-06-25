package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertThrows;

// handling void methods (ex 4)
// void methods cant use when(...).thenReturn since theres nothing coming back
// so the syntax flips round to doNothing()/doThrow().when(mock).method()
class VoidMethodTest {

    @Test
    void voidMethodDoesNothingByDefault() {
        ExternalApi api = mock(ExternalApi.class);
        // mocks already do nothing on void calls, being explicit just to show the syntax
        doNothing().when(api).saveData("x");

        api.saveData("x");

        verify(api).saveData("x");
    }

    @Test
    void voidMethodCanBeStubbedToThrow() {
        ExternalApi api = mock(ExternalApi.class);
        doThrow(new RuntimeException("disk full")).when(api).saveData("big");

        assertThrows(RuntimeException.class, () -> api.saveData("big"));
    }
}
