package dao;

import java.util.List;
import javax.ejb.Local;
import models.BankAccount;

@Local
public interface BankDAOLocal {
    void flush();
    void createBankAccount(BankAccount account);
    void createBankAccountWithException(BankAccount account);
    void createBankAccountWithoutTransaction(BankAccount account);
    public void createBankAccountWithNewTransaction(BankAccount account);
    BankAccount getBankAccountById(int id);
    List<BankAccount> getAllBankAccounts();
}