package Interfaces;

import entity.Product;

import java.util.Date;
import java.util.List;

public interface Repository<T> {

    public boolean create (T element);
    public Product getById(Long id);

    public void delete(Long id);

    public boolean update(Long id, T element);

    public List<T> getAll();
    public List<T> getByPrice(Double price);
    public List<T> getByDate(Date date1, Date date2);

    public void close();

}
