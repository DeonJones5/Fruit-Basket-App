import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvFormat;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVFruitBasketService implements FruitBasketService{

    //Fruit attributes
    private static final String FRUIT_NAME = "fruit";
    private static final String FRUIT_DAYS = "daysOld";
    private static final String FRUIT_CHARACTERISTIC_1 = "characteristic1";
    private static final String FRUIT_CHARACTERISTIC_2 = "characteristic2";

    //CSV file header
    private static final String[] FILE_HEADER_MAPPING =
            {
                    FRUIT_NAME,
                    FRUIT_DAYS,
                    FRUIT_CHARACTERISTIC_1,
                    FRUIT_CHARACTERISTIC_2
            };

    private String csvPath;

    public CSVFruitBasketService(String csvPath) {
        if (csvPath == null) {
            throw new IllegalArgumentException("Provide fruit basket csv that is valid");
        }
        this.csvPath = csvPath;
    }

    List<Fruit> readFruitCatalog = new ArrayList<>(FruitBasketApplication.getFruitDetails("Catalog/basket.csv"));

    @Override
    public List<Fruit> findAllFruit() {
        List<Fruit> availableFruits = readFruitCatalog;
        return availableFruits;

    }

    @Override
    public List<Fruit> findAllFruitsByName(String name) {
        List<Fruit> availableFruits = readFruitCatalog;
        List<Fruit> requestedFruits = new ArrayList<>();

        for (Fruit fruit: availableFruits) {
            if (fruit.getName().equalsIgnoreCase(name)) {

            }
        }
        return requestedFruits;
    }

    @Override
    public Set<String> findAllFruitByType() {
        List<Fruit> availableFruits = readFruitCatalog;
        Set<String> uniqueFruitNameSet = new HashSet<>();

        for (Fruit fruit : availableFruits) {
            uniqueFruitNameSet.add(fruit.getName());
        }

        return uniqueFruitNameSet;
    }

    @Override
    public List<Fruit> findAllFruitByAge(String name, Integer daysInStore) {

        List<Fruit> availableFruits = readFruitCatalog;
        List<Fruit> requestFruits = new ArrayList<>();

        for (Fruit fruit : availableFruits) {
            if (fruit.getName().equalsIgnoreCase(name) && Integer.parseInt(fruit.getDaysOld()) > daysInStore) {
                requestFruits.add(fruit);
            }
        }
        return requestFruits;
    }

    @Override
    public Integer countAllFruit() {
        return findAllFruit().size();
    }

    @Override
    public Integer countAllFruitByName(String name) {
        return findAllFruitsByName(name).size();
    }

    @Override
    public Integer countAllFruitByType() {
        return findAllFruitByType().size();
    }

    @Override
    public Integer countAllFruitByDaysOld(String name, int daysOld) {
        return findAllFruitByAge(name, daysOld).size();
    }


}
