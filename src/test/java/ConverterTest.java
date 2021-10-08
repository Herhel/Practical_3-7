import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ConverterTest {
    private static TemperatureConverter converter;

    @Parameterized.Parameter
    public double param;

    @Parameterized.Parameter(1)
    public double expected1;

    @Parameterized.Parameter(2)
    public double expected2;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList( new Object[][] {
                {0.0, 273.2, 32.0},
                {-273.2, 0.0, -459.76},
                {10.0, 283.2, 50.0},
                {-10.0, 263.2, 14.0}
        });
    }

    @BeforeClass
    public static void init() {
        converter = new TemperatureConverter();
    }

    @Test
    public void testConvertCtoK() {
        assertEquals(expected1, converter.convertCtoK(param), 0.00001);
    }

    @Test
    public void testConvertCtoF() {
        assertEquals(expected2, converter.convertCtoF(param), 0.00001);
    }

    @Test
    public void testConvertKtoC() {
        double result = converter.convertKtoC(expected1);
        assertEquals(param, result, 0.00001);
    }
}
