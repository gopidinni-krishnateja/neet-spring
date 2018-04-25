package com.neetConsultancy.dao;

import com.neetConsultancy.model.Franchise;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FranchiseDAOImpl implements FranchiseDAO {
    @Autowired
    SessionFactory sessionFactory;
    public void addFranchise(Franchise franchise) {
        sessionFactory.getCurrentSession().saveOrUpdate(franchise);
    }

    public Franchise getFranchise(int franchiseId) {
        return (Franchise)sessionFactory.getCurrentSession().get(Franchise.class,franchiseId);
    }

    public Franchise updateFranchise(Franchise franchise) {
        sessionFactory.getCurrentSession().update(franchise);
        return franchise;
    }

    public void deleteFranchise(int franchiseId) {
        Franchise franchise = (Franchise) sessionFactory.getCurrentSession().load(Franchise.class,franchiseId);
                this.sessionFactory.getCurrentSession().delete(franchise);
    }

    public List<Franchise> filterFranchises(String franchiseName) {
        Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Franchise.class)
                .add(Restrictions.and(Restrictions.like("franchiseName",franchiseName)));
        return criteria.list();
    }

    public List<Franchise> getAllFranchises() {
        Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Franchise.class);
        return criteria.list();
    }

    public void approveFranchise(List<Franchise> franchises) {

    }
}
