import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FruitBasketApplication {
    public static void main(String[] args) {
        int inStoreDays = 3;
        List<Fruit> fruitList = getFruitDetails("Catalog/basket.csv");
        for (Fruit fruits : fruitList) {
            System.out.println(fruits);
        }
        System.out.println();

        if ( (args.length <= 0)) {
            System.out.println("Provide a valid CSV file.");
        } else {

            String csvPath = args[0];

            if (args.length > 1) {
                try {
                    inStoreDays = Integer.parseInt(args[1]);
                } catch (Exception e) {
                    System.err.println("Invalid instore days " + e.getMessage());
                }
            }
            FruitBasketService fruitBasketService = new CSVFruitBasketService(csvPath);
            FruitBasketApplication fruitBasketApplication = new FruitBasketApplication();
            fruitBasketApplication.printSummary(fruitBasketService, inStoreDays);
        }
    }

    //Creating Fruit List
    public static List<Fruit> getFruitDetails(String file) {
        List<Fruit> fruitList = new ArrayList<>();
        //This will load the file
        Path pathToFile = Paths.get(file);

        try(BufferedReader br = Files.newBufferedReader(pathToFile)) {
            String row = br.readLine();
            while (row != null) {
                String[] attributes = row.split(",");
                Fruit fruit = getOneFruit(attributes);
                fruitList.add(fruit);
                row = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fruitList;
    }

    private static Fruit getOneFruit(String[] attributes) {
        String name = attributes[0];
        //For some reason not allowing me to parse to Int so I turned days into String instead
//        int daysOld = Integer.parseInt(attributes[1]);
        String daysOld = attributes[1];
        String characteristic1 = attributes[2];
        String characteristic2 = attributes[3];

        Fruit fruit = new Fruit(name, daysOld, characteristic1, characteristic2);

        return fruit;
    }

    public void printSummary(FruitBasketService fruitBasketService, int daysOld){
        System.out.println("Fruit Basket Summary");
        System.out.println();
        System.out.println("\nTotal number of fruit:");
        printTotal(fruitBasketService);
        System.out.println("\nTotal types of fruit:");
        printTypeOfFruit(fruitBasketService);
        System.out.println("\nOldest fruit & age:");
        printFruitsByInStoreDays(fruitBasketService, daysOld);
        System.out.println("\nThe number of each type of fruit in descending order:");
        //printNumberOfFruitInTypeDesc
        System.out.println("\nThe various characteristics (count, color, shape, etc.) of each fruit by type:");
        //printVariousCharacteristics
    }

    public void printTotal(FruitBasketService fruitBasketService) {
        int total = fruitBasketService.countAllFruit();

        System.out.println(total);
    }
    private void printTypeOfFruit(FruitBasketService fruitBasketService) {
        int fruitCountByType = fruitBasketService.countAllFruitByType();
        System.out.println(fruitCountByType);
    }


    private void printFruitsByInStoreDays(FruitBasketService fruitBasketService, int inStoreDays) {
        boolean foundFruit = false;

        //Get names
        Set<String> uniqueFruitNameSet = fruitBasketService.findAllFruitByType();

        for (String fruitName : uniqueFruitNameSet) {
            int count = fruitBasketService.countAllFruitByDaysOld(fruitName, inStoreDays);

            if (count > 0) {
                System.out.println(count + " " + fruitName + ":" + inStoreDays + " days old.");

                foundFruit = true;
            }
        }
    }
}
