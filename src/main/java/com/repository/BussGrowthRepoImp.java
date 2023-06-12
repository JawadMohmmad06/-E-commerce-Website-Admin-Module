package com.repository;

import com.domain.Adminuser;
import com.domain.Busgrowth;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BussGrowthRepoImp  implements BusGrowthRepository{

    private SessionFactory sessionFactory;

    public BussGrowthRepoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Busgrowth> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Busgrowth> busgrowthQuery = session.createQuery("from Busgrowth", Busgrowth.class);
        return busgrowthQuery.getResultList();
    }

    public Busgrowth create(Busgrowth busgrowth) {
        Session session = sessionFactory.getCurrentSession();
        session.save(busgrowth);
        return busgrowth;

    }

    public Busgrowth get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Busgrowth.class, id);
    }


    public Busgrowth update(Busgrowth busgrowth) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(busgrowth);
        return busgrowth;
    }
    public Busgrowth getbyyear(String year) {
        Session session = sessionFactory.getCurrentSession();
        Query<Busgrowth> busgrowthQuery = session.createQuery("from Busgrowth where year = :year", Busgrowth.class);
        busgrowthQuery.setParameter("year", year);
        return busgrowthQuery.getSingleResult();
    }
    public void delete(String year) {
        Session session = sessionFactory.getCurrentSession();
        Busgrowth busgrowth = getbyyear(year);
        if (busgrowth != null) {
            session.delete(busgrowth);
        }
    }
}
