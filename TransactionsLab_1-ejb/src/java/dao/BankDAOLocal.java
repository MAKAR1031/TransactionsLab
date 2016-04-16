package dao;

import javax.ejb.Local;
import models.BankAccount;

@Local
public interface BankDAOLocal {
    void flush();
    void createBankAccount(BankAccount account);
    void createBankAccountWithException(BankAccount account);
    BankAccount getBankAccountById(int id);
}