package junit.monprojet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SommeArgentTest {

    @Test
    void testAdd() {
        SommeArgent m12CHF= new SommeArgent(12, "CHF"); // (1)
        SommeArgent m14CHF= new SommeArgent(14, "CHF");
        SommeArgent expected = new SommeArgent(26, "CHF");
        SommeArgent result = m12CHF.add(m14CHF); // (2)
        Assertions.assertTrue(expected.equals(result)); // (3)
    }
}