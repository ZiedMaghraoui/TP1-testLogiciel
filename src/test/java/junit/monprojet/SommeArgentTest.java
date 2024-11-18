package junit.monprojet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SommeArgentTest {
    //    Ces objets sont appelés Test fixture
    private SommeArgent m12CHF;
    private SommeArgent m14CHF;
    private SommeArgent m14USD;

    @BeforeEach
    void setUp() {
        System.out.println("passage avant exécution d'une méthode de test");
        m12CHF = new SommeArgent(12, "CHF");
        m14CHF = new SommeArgent(14, "CHF");
        m14USD = new SommeArgent(14, "USD");
    }

    @AfterEach
    void tearDown() {
        System.out.println("passage APRES exécution d'une méthode de test");
    }

    @Test
    void testAdd() throws UniteDistincteException {
//        SommeArgent m12CHF = new SommeArgent(12, "CHF"); // (1)
//        SommeArgent m14CHF = new SommeArgent(14, "CHF");
        SommeArgent expected = new SommeArgent(26, "CHF");
        SommeArgent result = m12CHF.add(m14CHF); // (2)
        Assertions.assertTrue(expected.equals(result)); // (3)
    }

    @Test
    void testAddDistinct() {
        Assertions.assertThrows(UniteDistincteException.class, () -> {
            SommeArgent result = m12CHF.add(m14USD);
        });
    }

    /*  Pour JUnit 4
    @Test(expected = UniteDistincteException.class)
    void testAddDistinctJU4() throws UniteDistincteException {
        SommeArgent result = m12CHF.add(m14USD);
    }
    */

    @Test
    void testEquals() {
//        SommeArgent m12CHF = new SommeArgent(12, "CHF");
//        SommeArgent m14CHF = new SommeArgent(14, "CHF");
//        SommeArgent m14USD = new SommeArgent(14, "USD");
        Assertions.assertTrue(!m12CHF.equals(null));
        Assertions.assertEquals(m12CHF, m12CHF);
        Assertions.assertEquals(m12CHF, new SommeArgent(12, "CHF")); // (1)
        Assertions.assertTrue(!m12CHF.equals(m14CHF));
        Assertions.assertTrue(!m14USD.equals(m14CHF));
        // cette derniere ligne teste que la methode equals compare correctement l'unite
    }
}