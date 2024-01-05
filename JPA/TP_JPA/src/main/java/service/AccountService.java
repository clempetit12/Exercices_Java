package service;

import dao.AccountDao;
import dao.CustomerDao;
import entity.Account;
import entity.Customer;

public class AccountService {
    private AccountDao accountDao;
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account createAccount(Account account) {
        if(accountDao.add(account)){
            System.out.println("Un compte a bien été créé !");
        }
        return account;
    }

    public void close() {
        accountDao.close();
    }

    public Account findAccount(Long id) {
        return accountDao.find(id);
    }

public void createAccount (Account account, Long idCustomer, Long idAgency){
        accountDao.createAccount(account,idCustomer,idAgency);


}
}



