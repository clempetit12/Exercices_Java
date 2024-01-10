package interfaces;

import entity.Product;

import java.util.Date;
import java.util.List;

public interface Repository<T> {



    public boolean create (T element);

    public boolean update(Long id, T element);
    public void delete(Long id);

    public T getById(Long id);

    public List<T> getAll();
    public List<T> getByPrice(Double price);
    public List<T> getByDate(Date date1, Date date2);
    public List<T> getByStock(int stock);
    public Double getAveragePrice();

    public void close();



}