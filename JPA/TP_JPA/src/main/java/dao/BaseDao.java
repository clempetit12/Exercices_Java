package dao;

public interface BaseDao<T> {

    public boolean add(T element);

    public boolean delete(Long id);
    public void close();

    public T find(Long id);
}
