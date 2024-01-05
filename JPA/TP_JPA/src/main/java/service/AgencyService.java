package service;

import dao.AggencyDao;
import dao.CustomerDao;
import entity.Account;
import entity.Agency;
import entity.Customer;

public class AgencyService {

    private AggencyDao aggencyDao;
    public AgencyService(AggencyDao aggencyDao) {
        this.aggencyDao = aggencyDao;
    }

    public Agency createAgency(Agency agency) {
        if(aggencyDao.add(agency)){
            System.out.println("Une agence a bien été créé !");
        }
        return agency;
    }
    public void close() {
        aggencyDao.close();
    }

    public Agency findAgency(Long id) {
        return aggencyDao.find(id);
    }
}
