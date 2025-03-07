package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;

import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline felineSpy = new Feline();

    @Test
    public void shouldEatMeat() throws Exception {

        doReturn(List.of("Хищник")).when(felineSpy).getFood("Хищник");

        List<String> result = felineSpy.eatMeat();

        assertEquals(List.of("Хищник"), result);
    }

    @Test
    public void shouldGetFamily() {
        assertEquals("Кошачьи", felineSpy.getFamily());
        verify(felineSpy, times(1)).getFamily();
    }

    @Test
    public void shouldGetKittens() {
        assertEquals(1, felineSpy.getKittens());  // Проверяем реальную логику
        verify(felineSpy, times(1)).getKittens();
    }
}