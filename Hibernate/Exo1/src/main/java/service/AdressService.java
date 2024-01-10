package service;

import dao.AdressDao;
import dao.CommentDao;
import entity.Adress;
import entity.Comments;

public class AdressService {

    private AdressDao adressDao;

    public AdressService(AdressDao adressDao) {
        this.adressDao = adressDao;
    }

    public boolean createAdress(Adress adress) {
        return adressDao.create(adress);
    }



}
