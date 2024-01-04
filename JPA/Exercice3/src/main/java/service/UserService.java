package service;

import dao.ToDoDao;
import dao.UserDao;
import entity.User;

public class UserService {

    private  UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User addUser(User user) {
        if (userDao.add(user)){
            System.out.println("Un utilisateur a bien été créé");
        }
        return user;
    }

    public User findUser (Long id) {
       return userDao.findUser(id);

    }

    public  boolean removeUser(Long id) {

        if (userDao.remove(id)) {
            System.out.println("L'utilisateur a bien été supprimée");

        }
        return true;
    }
}
