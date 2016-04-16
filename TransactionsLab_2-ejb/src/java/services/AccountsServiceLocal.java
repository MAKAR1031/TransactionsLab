package services;

import javax.ejb.Local;
import models.Account;
import models.BankAccount;

@Local
public interface AccountsServiceLocal {
    void addAccountAndBankAccount(Account account);
    void createBankAccount(BankAccount bankAccount);
}
