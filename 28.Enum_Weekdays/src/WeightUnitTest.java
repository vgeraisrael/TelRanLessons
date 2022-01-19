import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightUnitTest {

    @org.junit.jupiter.api.Test
    void convertTest() {
        assertEquals(1000, WeightUnit.TN.convert(WeightUnit.KG), 0.001);
        assertEquals(0.001, WeightUnit.GR.convert(WeightUnit.KG), 0.001);
    }

    @Test
    void getGramm() {
        assertEquals(453.592, WeightUnit.LBS.getGramm());
    }

    @Test
    void convert() {
        assertEquals(1000, WeightUnit.convert(WeightUnit.KG, WeightUnit.GR ));
    }

    @Test
    void testConvert() {
        assertEquals(400, WeightUnit.convert(0.4, WeightUnit.KG, WeightUnit.GR ));
    }
}