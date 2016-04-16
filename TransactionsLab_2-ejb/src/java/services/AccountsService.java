package services;

import dao.AccountDAOLocal;
import dao.BankDAOLocal;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import models.Account;
import models.AccountStatus;
import models.BankAccount;

@Stateless
public class AccountsService implements AccountsServiceLocal {

    @EJB
    private AccountDAOLocal accountDAO;
    @EJB
    private BankDAOLocal bankDAO;
    @Resource
    private SessionContext sc;

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = accountDAO.getAllAccounts();
        for (Account account : accounts) {
            account.setBankAccount(bankDAO.getBankAccountById(account.getIdBankAccount()));
        }
        return accounts;
    }


    /*
        Дать контейнеру закончить транзакцию подтверждением и убедиться, что обновления зафиксированы.
     */
    @Override
    public void experiment1() {
        Account account = createRandomAccount();
        BankAccount bankAccount = account.getBankAccount();
        bankDAO.createBankAccount(bankAccount);
        bankDAO.flush();
        account.setIdBankAccount(bankAccount.getId());
        accountDAO.createAccount(account);
    }

    @Override
    public void experiment2() {
        Account account = createRandomAccount();
        BankAccount bankAccount = account.getBankAccount();
        bankDAO.createBankAccount(bankAccount);
        bankDAO.flush();
        account.setIdBankAccount(bankAccount.getId());
        accountDAO.createAccountWithRollback(account);
    }

    @Override
    public void experiment3() {
        Account account = createRandomAccount();
        BankAccount bankAccount = account.getBankAccount();
        bankDAO.createBankAccountWithException(bankAccount);
        bankDAO.flush();
        account.setIdBankAccount(bankAccount.getId());
        accountDAO.createAccountWithRollback(account);
    }

    @Override
    public void experiment4() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void experiment5() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Account createRandomAccount() {
        Random random = new Random();
        BankAccount bankAccount = new BankAccount();
        bankAccount.setMoney(random.nextInt(990000) + 10000);

        AccountStatus status = accountDAO.getStatusByName("Создан");

        Account account = new Account();
        account.setFio("Макаров Сергей Андреевич");
        account.setRegistrationDate(new Date());
        account.setStatus(status);
        account.setBankAccount(bankAccount);
        return account;
    }

}
