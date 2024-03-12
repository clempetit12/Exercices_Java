package service;

import dao.OrdersDao;
import entity.Order;

import java.util.Date;
import java.util.List;

public class OrdersService {

    private OrdersDao orderDao;

    public OrdersService(OrdersDao ordersDao) {
        this.orderDao = new OrdersDao();
    }

    public boolean createOrders(Order order) {
        return orderDao.create(order);
    }

    public  List<Order> getOrdersOdTheDay(Date date) {
        return orderDao.getorderByDate(date);
    }
    public List<Order> displayAllOrderss(){
        return orderDao.getAll();
    }

    public boolean updateOrder(Long id, Order order){
        return orderDao.update(id, order);
    }

}
