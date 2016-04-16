package controllers;

import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import models.Account;
import models.AccountStatus;
import models.BankAccount;
import services.AccountsServiceLocal;

@Named
@RequestScoped
public class Controller {

    @EJB
    private AccountsServiceLocal accountsService;
    
    public String test() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setMoney(1000000);
        AccountStatus status = new AccountStatus();
        status.setName("Создан");
        Account account = new Account();
        account.setFio("Макаров Сергей Андреевич");
        account.setRegistrationDate(new Date());
        account.setStatus(status);
        account.setBankAccount(bankAccount);
        accountsService.addAccountAndBankAccount(account);
        return "tested";
    }
}