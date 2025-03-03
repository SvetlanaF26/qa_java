package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline felineMock;
    private Cat cat;

    @Before
    public void setUp() {

        cat = new Cat(felineMock);
    }

    @Test
    public void getSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
   public void shouldReturnMeatList() throws Exception {

        try {
            when(felineMock.eatMeat()).thenReturn(List.of("Мясо"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(List.of("Мясо"), cat.getFood());

        verify(felineMock, times(1)).eatMeat();
    }
}
