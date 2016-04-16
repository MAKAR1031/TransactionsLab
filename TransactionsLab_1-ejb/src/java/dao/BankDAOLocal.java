package dao;

import javax.ejb.Local;
import models.BankAccount;

@Local
public interface BankDAOLocal {
    void createBankAccount(BankAccount account);
    BankAccount getBankAccountById(int id);
    void removeBankAccount(BankAccount account);
}