package entity;

import org.example.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    void testQualityProductWhenSellinDays0() {
        Product product = new Product();
        product.setQuality(10);
        product.setCategory("Normal");
        product.setSellingDays(0);
        int initialQuality = product.getQuality();
        int evolvedQuality = product.qualityEvolution();
        Assertions.assertEquals(initialQuality/2, evolvedQuality);
    }

    @Test
    void testQualityProductIsNeverNegativ() {
        Product product = new Product();
        Assertions.assertThrowsExactly(RuntimeException.class, () -> {

            product.setQuality(-10);

        });
    }

    @Test
    void testQualityProductIsNeverOver50() {
        Product product = new Product();
        Assertions.assertThrowsExactly(RuntimeException.class, () -> {

            product.setQuality(51);

        });
    }

    //	La qualité du « brie vieilli » augmente à mesure qu'il vieillit.

    @Test
    void testQualityProductBrieVieilliIncreaseAsSellinDaysDecrease() {
        Product product = new Product();
        product.setName("Brie Vieilli");
        product.setQuality(20);
        product.setSellingDays(20);
        int initialQuality = product.getQuality();
        int sellinDaysDecrease = product.setSellingDays(10);
        int currentQuality = product.increaseQuality();
        Assertions.assertTrue(currentQuality > initialQuality, "La qualité devrait augmenter");
        initialQuality = currentQuality;

    }

    //Les produits laitiers se dégradent en qualité deux fois plus vite que les produits normaux


    @Test
    void testQualityMilkProductsQualityDecreaseTwiceFastestThanNormalProduct() {
        Product product = new Product();
        product.setCategory("Milk");
        product.setQuality(20);
        product.setSellingDays(20);
        Product product1 = new Product();
        product1.setCategory("Normal");
        product1.setQuality(20);
        product1.setSellingDays(20);
        int initialQualityMilk = product.getQuality();
        int initialQualityNormal = product1.getQuality();
        int sellinDayMilk = product.setSellingDays(10);
        int sellinDayNormal = product1.setSellingDays(10);
        int currentQualityMilk = product.qualityEvolution();
        int currentQualityNormal = product1.qualityEvolution();
        Assertions.assertTrue(currentQualityNormal > currentQualityMilk);

    }
}
