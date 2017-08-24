package ATMBranchFinderSpring.repos;

import java.util.List;

public interface Repository<E> {
    E Get(int id);
    List<E> GetAll();
    void Add(E entity);
    void Remove(int id);
}
