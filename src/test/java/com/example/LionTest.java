package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private FelineInterface felineMock;

    @Test
    public void shouldReturnKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", felineMock);
        assertEquals(3, lion.getKittens());

        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void shouldReturnFoodList() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Мясо", "Птица"));

        Lion lion = new Lion("Самка", felineMock);
        assertEquals(List.of("Мясо", "Птица"), lion.getFood());

        verify(felineMock, times(1)).eatMeat();
    }

    @Test
    public void shouldHaveManeForMaleLion() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void shouldNotHaveManeForFemaleLion() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionForInvalidSex() throws Exception {
        new Lion("Другой", felineMock);
    }
}