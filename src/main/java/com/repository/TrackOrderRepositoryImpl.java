package com.repository;

import com.domain.Adminauthority;
import com.domain.Trackorder;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TrackOrderRepositoryImpl implements TrackOrderRepository  {

    private SessionFactory sessionFactory;

    public TrackOrderRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Trackorder> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Trackorder> trackorderQuery = session.createQuery("from Trackorder", Trackorder.class);
        return trackorderQuery.getResultList();
    }

    public Trackorder create(Trackorder trackorder) {
        Session session = sessionFactory.getCurrentSession();
        session.save(trackorder);
        return trackorder;

    }

    public Trackorder get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Trackorder.class, id);
    }

    public Trackorder update(Trackorder trackorder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(trackorder);
        return trackorder;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Trackorder trackorder = get(id);
        if (trackorder != null) {
            session.delete(trackorder);
        }
    }
}
