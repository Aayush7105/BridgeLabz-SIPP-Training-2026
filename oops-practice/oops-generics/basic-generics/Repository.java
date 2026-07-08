
import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private List<T> entities;

    public Repository() {
        entities = new ArrayList<>();
    }

    public void add(T entity) {
        entities.add(entity);
    }

    public List<T> getAll() {
        return new ArrayList<>(entities);
    }

    public static void main(String[] args) {
        Repository<String> repo = new Repository<>();
        repo.add("Entity 1");
        repo.add("Entity 2");
        System.out.println(repo.getAll());
    }
}
