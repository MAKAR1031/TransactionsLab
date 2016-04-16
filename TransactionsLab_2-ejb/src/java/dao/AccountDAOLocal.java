package dao;

import java.util.List;
import javax.ejb.Local;
import models.Account;
import models.AccountStatus;

@Local
public interface AccountDAOLocal {
    void flush();
    void createAccount(Account account);
    void createAccountWithRollback(Account account);
    List<Account> getAllAccounts();
    AccountStatus getStatusByName(String statusName);
}
