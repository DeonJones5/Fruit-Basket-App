import java.util.List;
import java.util.Set;

public class CSVFruitBasketService implements FruitBasketService{
    private String csvPath = null;
    public CSVFruitBasketService(String csvPath) {
        this.csvPath = csvPath;

    }

    @Override
    public List<Fruit> findAllFruit() {
        return null;
    }

    @Override
    public List<Fruit> findAllFruitsByName(String name) {
        return null;
    }

    @Override
    public Set<Fruit> findAllFruitByType() {
        return null;
    }

    @Override
    public List<Fruit> findAllFruitByAge(String name, int daysOld) {
        return null;
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
