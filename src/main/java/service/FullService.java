package service;

public interface FullService<T> {
    Iterable<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);
}
