package com.repository;

import com.domain.Customerreg;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerRegRepositoryImpl  implements CustomerRegRepository {

    private SessionFactory sessionFactory;

    public CustomerRegRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Customerreg> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customerreg> customerregQuery = session.createQuery("from Customerreg", Customerreg.class);
        return customerregQuery.getResultList();
    }

    public Customerreg create(Customerreg customerreg) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customerreg);
        return customerreg;

    }

    public Customerreg get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customerreg.class, id);
    }

    public Customerreg update(Customerreg customerreg) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerreg);
        return customerreg;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Customerreg customerreg = get(id);
        if (customerreg != null) {
            session.delete(customerreg);
        }
    }
}
