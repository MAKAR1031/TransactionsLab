package services;

import java.util.List;
import javax.ejb.Local;
import models.Account;
import models.BankAccount;

@Local
public interface AccountsServiceLocal {
    List<Account> getAllAccounts();
    List<BankAccount> getAllBankAccounts();
    void experiment1();
    void experiment2();
    void experiment3();
    void experiment4();
    void experiment5();
}
