package com.example;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
@Category(LionTest.class)
public class LionParamTest {
    @Mock
    private FelineInterface felineMock;

    private final String sex;
    private final boolean expectedHasMane;
    private final String expectedExceptionText;

    public LionParamTest(String sex, boolean expectedHasMane, String expectedExceptionText) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.expectedExceptionText = expectedExceptionText;
    }

    @Parameterized.Parameters(name = "Пол: {0}, ЕстьГрива: {1}")
    public static Object[][] dataGen() {
        return new Object[][]{
                {"Самец", true, null},
                {"Самка", false, null},
                {"Другое", false, "Используйте допустимые значения пола животного - самец или самка"}
        };
    }

    @Test
    public void testHaveMane() throws Exception {
        if (expectedExceptionText == null) {
            Lion lion = new Lion(this.sex, felineMock);
            assertEquals(expectedHasMane, lion.doesHaveMane());
        } else {
            Exception exception = assertThrows(Exception.class, () -> new Lion(this.sex, felineMock));
            assertEquals(expectedExceptionText, exception.getMessage());
        }
    }
}