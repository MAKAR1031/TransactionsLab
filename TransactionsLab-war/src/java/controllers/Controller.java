package controllers;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import models.Account;
import models.BankAccount;
import services.AccountsServiceLocal;

@Named
@RequestScoped
public class Controller {

    @EJB
    private AccountsServiceLocal accountsService;

    public List<Account> getAllAccounts() {
        return accountsService.getAllAccounts();
    }
    
    public List<BankAccount> getAllBankAccounts() {
        return accountsService.getAllBankAccounts();
    }
    
    public void experiment1() {
        accountsService.experiment1();
    }
    
    public void experiment2() {
        accountsService.experiment2();
    }
    
    public void experiment3() {
        accountsService.experiment3();
    }
    
    public void experiment4() {
        accountsService.experiment4();
    }
    
    public void experiment5() {
        accountsService.experiment5();
    }
}