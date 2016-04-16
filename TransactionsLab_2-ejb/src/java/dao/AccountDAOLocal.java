package dao;

import java.util.List;
import javax.ejb.Local;
import models.Account;
import models.AccountStatus;

@Local
public interface AccountDAOLocal {
    void createAccount(Account account);
    List<Account> getAllAccounts();
    void removeAccount(Account account);
    AccountStatus getStatusByName(String statusName);
}
