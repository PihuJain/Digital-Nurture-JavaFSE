package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;

// mocking + stubbing (ex 1) and verifying interactions (ex 2), plus argument matching (ex 3)
class MyServiceTest {

    @Test
    void stubReturnsMockData() {
        // mock the api so it never actually calls anything real
        ExternalApi api = mock(ExternalApi.class);
        // stub it - when getData runs, hand back this fixed value
        when(api.getData()).thenReturn("mock data");

        MyService service = new MyService(api);
        assertEquals("mock data", service.fetchData());
    }

    @Test
    void verifyApiWasCalled() {
        ExternalApi api = mock(ExternalApi.class);
        MyService service = new MyService(api);

        service.fetchData();

        // didnt stub anything this time, just checking the service really went to the api
        verify(api).getData();
    }

    @Test
    void verifyCalledWithTheRightArgument() {
        ExternalApi api = mock(ExternalApi.class);
        MyService service = new MyService(api);

        service.backup("report.txt");

        // eq checks the exact value it got called with
        // anyString() would pass for any string if you didnt care about the exact one
        verify(api).saveData(eq("report.txt"));
    }
}
