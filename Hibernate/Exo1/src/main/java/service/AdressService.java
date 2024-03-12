package service;

import dao.AdressDao;
import entity.Adress;

public class AdressService {

    private AdressDao adressDao;

    public AdressService(AdressDao adressDao) {
        this.adressDao = adressDao;
    }

    public boolean createAdress(Adress adress) {
        return adressDao.create(adress);
    }



}
