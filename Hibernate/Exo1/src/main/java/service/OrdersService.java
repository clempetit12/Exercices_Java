package service;

import dao.ImageDao;
import dao.OrdersDao;
import entity.Orders;
import entity.Product;

import java.util.Date;
import java.util.List;

public class OrdersService {

    private OrdersDao orderDao;

    public OrdersService(OrdersDao ordersDao) {
        this.orderDao = new OrdersDao();
    }

    public boolean createOrders(Orders order) {
        return orderDao.create(order);
    }

    public  List<Orders> getOrdersOdTheDay(Date date) {
        return orderDao.getorderByDate(date);
    }
    public List<Orders> displayAllOrderss(){
        return orderDao.getAll();
    }

    public boolean updateOrder(Long id, Orders orders){
        return orderDao.update(id,orders);
    }

}
