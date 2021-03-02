import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FruitBasketService {
    public List<Fruit> findAllFruit();

    public List<Fruit> findAllFruitsByName(String name);

    public Set<Fruit> findAllFruitByType();

    public List<Fruit> findAllFruitByAge(String name, int daysOld);

    public Integer countAllFruit();

    public Integer countAllFruitByName(String name);

    public Integer countAllFruitByType();

    public Integer countAllFruitByDaysOld(String name, int daysOld);
}
