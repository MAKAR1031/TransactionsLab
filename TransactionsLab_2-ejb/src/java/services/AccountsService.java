package services;

import dao.AccountDAOLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import models.Account;
import models.BankAccount;
import dao.BankDAOLocal;

@Stateless
public class AccountsService implements AccountsServiceLocal {

    @EJB
    private AccountDAOLocal accountDAO;
    @EJB
    private BankDAOLocal bankDAO;
    
    @Override
    public void addAccountAndBankAccount(Account account) {
        BankAccount bankAccount = account.getBankAccount();
        bankDAO.createBankAccount(bankAccount);
        
        account.setIdBankAccount(bankAccount.getId());
        accountDAO.createAccount(account);
    }

    @Override
    public void createBankAccount(BankAccount bankAccount) {
        bankDAO.createBankAccount(bankAccount);
    }
}
