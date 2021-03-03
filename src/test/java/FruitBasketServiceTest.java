import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FruitBasketServiceTest {
    private static final String TEST_CSV_PATH = "src/resources/basket.csv";

    public FruitBasketServiceTest(){

    }

    @Test
    public void testService() {
        FruitBasketService fruitBasketService = new CSVFruitBasketService(TEST_CSV_PATH);
        Assertions.assertNotNull(fruitBasketService);
    }

    @Test
    void findAllFruit() {
        FruitBasketService fruitBasketService = new CSVFruitBasketService(TEST_CSV_PATH);
        Assertions.assertNotNull(fruitBasketService);
        List<Fruit> fruits = fruitBasketService.findAllFruit();

        System.out.println("Total " + fruits.size() + " fruits found:");

        for (Fruit fruit: fruits) {
            System.out.println(fruit);
        }
    }

    @Test
    void findAllFruitByType() {
        FruitBasketService fruitBasketService = new CSVFruitBasketService(TEST_CSV_PATH);
        Assertions.assertNotNull(fruitBasketService);
        Set<String> fruits = fruitBasketService.findAllFruitByType();

        System.out.println("Total of " + fruits.size() + " types found:");

        for (String fruit: fruits) {
            System.out.println(fruit);
        }
    }

    @Test
    void countAllFruit() {
        FruitBasketService fruitBasketService = new CSVFruitBasketService(TEST_CSV_PATH);
        Assertions.assertNotNull(fruitBasketService);
        Integer fruits = fruitBasketService.countAllFruit();

        System.out.println("Total " + fruits + " fruits found");

    }

    @Test
    void countAllFruitByType() {
        FruitBasketService fruitBasketService = new CSVFruitBasketService(TEST_CSV_PATH);
        Assertions.assertNotNull(fruitBasketService);
        Integer fruits = fruitBasketService.countAllFruitByType();

        System.out.println("Total " + fruits + " types of fruits found");

    }


}