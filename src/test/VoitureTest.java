import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoitureTest {
    @Test
    void when_getprix_should_return_correct_price(){
        // Arrange
        Voiture voiture = new Voiture("Ferrari", 5000);

        // Act
        double expectedPrice = 5000;
        double price = voiture.getPrix();

        // Verify
        assertEquals(price, expectedPrice, "Doit être " + expectedPrice);
    }

    @Test
    void testSetPrixVoiture(){
        Voiture f = new Voiture("Peugeot", 100);
        f.setPrix(5000);
        assertEquals(5000, f.getPrix());
    }

    @Test
    void testGetMarqueVoiture(){
        Voiture f = new Voiture("Peugeot", 100);
        assertEquals("Peugeot", f.getMarque());
    }

    @Test
    void testSetMarqueVoiture(){
        Voiture f = new Voiture("Peugeot", 100);
        f.setMarque("Renault");
        assertEquals("Renault", f.getMarque());
    }

    @Test
    void testToStringVoiture(){
        Voiture f = new Voiture("Peugeot", 100);
        assertEquals("Voiture: Peugeot | Prix: 100.0", f.toString());
    }

}
