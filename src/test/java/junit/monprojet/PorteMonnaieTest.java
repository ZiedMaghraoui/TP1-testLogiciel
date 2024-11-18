package junit.monprojet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PorteMonnaieTest {
    private SommeArgent m5EUR;
    private SommeArgent m10EUR;
    private SommeArgent m7CHF;
    private SommeArgent m3USD;
    private PorteMonnaie pm10EUR;

    @BeforeEach
    void setUp() {
        m5EUR = new SommeArgent(5, "EUR");
        m10EUR = new SommeArgent(10, "EUR");
        m7CHF = new SommeArgent(7, "CHF");
        m3USD = new SommeArgent(3, "USD");
        pm10EUR = new PorteMonnaie();
        pm10EUR.ajouteSomme(m10EUR);
    }

    @Test
    void testAjouteSomme() {
        PorteMonnaie pm55 = new PorteMonnaie();
        pm55.ajouteSomme(m5EUR);
        pm55.ajouteSomme(m5EUR);
        assertEquals(pm55, pm10EUR);
    }

    @Test
    void testEquals() {
        PorteMonnaie pm7C3U = new PorteMonnaie();
        PorteMonnaie pm3U7C = new PorteMonnaie();
        PorteMonnaie pm7C10E = new PorteMonnaie();
        pm7C10E.ajouteSomme(m7CHF);
        pm7C10E.ajouteSomme(m10EUR);
        pm3U7C.ajouteSomme(m3USD);
        pm3U7C.ajouteSomme(m7CHF);
        pm7C3U.ajouteSomme(m7CHF);
        pm7C3U.ajouteSomme(m3USD);
        assertTrue(pm3U7C.equals(pm7C3U));
        assertFalse(pm7C10E.equals(pm7C3U));
        assertFalse(pm10EUR.equals(pm7C10E));
    }
}