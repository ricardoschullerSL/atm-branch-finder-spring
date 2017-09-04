package ATMBranchFinderSpring.repos;

import java.util.List;

public interface Repository<E> {
    E get(int id);
    List<E> getAll();
    void add(E entity);
    void remove(int id);
}
