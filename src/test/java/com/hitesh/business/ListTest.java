package com.hitesh.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

    @Test
    public void mockingListSize() {
        List mockedList = mock(List.class);
        when(mockedList.size()).thenReturn(2);

        assertEquals(2, mockedList.size());
    }

    @Test
    public void mockingListSize_returnMultiple() {
        List mockedList = mock(List.class);
        when(mockedList.size()).thenReturn(2).thenReturn(3).thenReturn(100);

        // when we call mockedList.size() 2nd time it returns 3
        // when we call mockedList.size() 3rd time it returns 100

        assertEquals(2, mockedList.size());
        assertEquals(3, mockedList.size());
        assertEquals(100, mockedList.size());
    }

    @Test
    public void mockingListGet() {
        List mockedList = mock(List.class);
        when(mockedList.get(0)).thenReturn("some string");

        assertEquals("some string", mockedList.get(0));

        // "nice mock" behavior - we havent sepcified what mockedList.get(515) returns
        // so it returns default i.e null
        assertEquals(null, mockedList.get(515));

        // any(Class), anyString(), anyInt(), etc are called "Argument Matchers"
        when(mockedList.get(any(Integer.class))).thenReturn("Argument Matchers");
        when(mockedList.get(anyInt())).thenReturn("Argument Matchers"); // same as above line

        assertEquals("Argument Matchers", mockedList.get(686101));
    }

    // ! We can test exception using the following
    @Test(expected = IllegalArgumentException.class)
    public void mockingListGet_testingException() {
        List mockedList = mock(List.class);

        when(mockedList.get(-1)).thenThrow(new IllegalArgumentException("Index out of bound"));
        mockedList.get(-1); // throws IllegalArgumentException

        // ! Below assertThrows method is an alternative to the annotation:
        // !@Test(expected = IllegalArgumentException.class)
        assertThrows(IllegalArgumentException.class, () -> mockedList.get(-1));
    }

    @Test
    public void mockingListGet_testingException2() {
        List mockedList = mock(List.class);
        when(mockedList.get(-1)).thenThrow(new IllegalArgumentException("Index out of bound"));

        // ! Below assertThrows method is an alternative to the annotation:
        // !@Test(expected = IllegalArgumentException.class)
        assertThrows(IllegalArgumentException.class, () -> mockedList.get(-1));
    }

}
