package dao;

import java.util.List;
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

    @Override
    public void createAccount(Account account) {
        em.persist(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        Query query = em.createQuery("SELECT a FROM Account a", Account.class);
        return query.getResultList();
    }

    @Override
    public void removeAccount(Account account) {
         em.remove(em.merge(account));
    }

    @Override
    public AccountStatus getStatusByName(String statusName) {
        Query query = em.createQuery("SELECT s FROM AccountStatus s WHERE s.name=?1", AccountStatus.class);
        query.setParameter(1, statusName);
        return (AccountStatus) query.getSingleResult();
    }
}