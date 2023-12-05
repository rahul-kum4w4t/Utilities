package in.zero.locale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for simple App.
 */
public class CurrencyTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testINR() {
        assertEquals(Currency.RUPEE_SYMBOL + "1,00,12,38,37,46,927.87", Currency.toINR(1_00_12_38_37_46_927.87269d));

        assertEquals(Currency.RUPEE_SYMBOL + "1,00,12,38,37,46,927", Currency.toINR(1_00_12_38_37_46_927L));

        assertEquals(Currency.RUPEE_SYMBOL + "1,00,12,927", Currency.toINR(1_00_12_927));

        assertEquals(Currency.RUPEE_SYMBOL + "1,00,12,38,37,46,927.87269", Currency.toINR("10012383746927.87269"));

        assertEquals(Currency.RUPEE_SYMBOL + "-1,00,12,38,37,46,927.87269", Currency.toINR("-10012383746927.87269"));

        assertEquals(Currency.RUPEE_SYMBOL + "1,00,12,38,37,46,927", Currency.toINR("10012383746927"));

        assertEquals(Currency.RUPEE_SYMBOL + "-1,00,12,38,37,46,927", Currency.toINR("-10012383746927"));

        assertEquals(Currency.RUPEE_SYMBOL + "-1,00,12,38,37,46,927.87269", Currency.toINR("-dhsj100dsd123as83746927.dhjsd87269"));

        assertThrows(IllegalArgumentException.class, () -> Currency.toINR("-dhsj100dsd1.23as83746927.dhjsd87269"));
    }
}
