package dao;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.Account;
import models.AccountStatus;

@Stateless
public class AccountDAO implements AccountDAOLocal {

    @PersistenceContext(unitName = "TransactionsLab_2-ejbPU")
    private EntityManager em;
    @Resource
    private SessionContext sc;

    @Override
    public void flush() {
        em.flush();
    }

    @Override
    public void createAccount(Account account) {
        em.persist(account);
    }
    
    @Override
    public void createAccountWithRollback(Account account) {
        em.persist(account);
        sc.setRollbackOnly();
    }

    @Override
    public List<Account> getAllAccounts() {
        Query query = em.createQuery("SELECT a FROM Account a", Account.class);
        return query.getResultList();
    }

    @Override
    public AccountStatus getStatusByName(String statusName) {
        Query query = em.createQuery("SELECT s FROM AccountStatus s WHERE s.name=?1", AccountStatus.class);
        query.setParameter(1, statusName);
        return (AccountStatus) query.getSingleResult();
    }
}