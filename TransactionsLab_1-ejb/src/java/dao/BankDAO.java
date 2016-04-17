package dao;

import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.BankAccount;

@Stateless
public class BankDAO implements BankDAOLocal {

    @PersistenceContext(unitName = "TransactionsLab_1-ejbPU")
    private EntityManager em;

    @Override
    public void flush() {
        em.flush();
    }

    @Override
    public BankAccount getBankAccountById(int id) {
        return em.find(BankAccount.class, id);
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        Query query = em.createQuery("SELECT a FROM BankAccount a", BankAccount.class);
        return query.getResultList();
    }
    
    @Override
    public void createBankAccount(BankAccount account) {
        em.persist(account);
    }

    @Override
    public void createBankAccountWithException(BankAccount account) {
        em.persist(account);
        throw new EJBException("Упс...");
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void createBankAccountWithNewTransaction(BankAccount account) {
        em.persist(account);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void createBankAccountWithoutTransaction(BankAccount account) {
        em.persist(account);
    }
}
