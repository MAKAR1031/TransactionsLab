package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.BankAccount;

@Stateless
public class BankDAO implements BankDAOLocal {

    @PersistenceContext(unitName = "TransactionsLab_1-ejbPU")
    private EntityManager em;

    @Override
    public BankAccount getBankAccountById(int id) {
        return em.find(BankAccount.class, id);
    }

    @Override
    public void createBankAccount(BankAccount account) {
        em.persist(account);
    }

    @Override
    public void removeBankAccount(BankAccount account) {
        em.remove(em.merge(account));
    }
}
