package service;

import dao.CustomerDao;
import entity.Account;
import entity.Customer;

public class CustomerService {

    private CustomerDao customerDao;
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer createCustomer(Customer customer) {
        if(customerDao.add(customer)){
            System.out.println("Un client a bien été créé !");
        }
        return customer;
    }
    public void close() {
        customerDao.close();
    }

    public Customer findCustomer(Long id) {
        return customerDao.find(id);
    }
}
