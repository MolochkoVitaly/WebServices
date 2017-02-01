package com.epam.paytickets.repository.impl;

import com.epam.paytickets.entity.Human;
import com.epam.paytickets.repository.HumanDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class HumanDAOImpl implements HumanDAO {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Long addHuman(Human human) {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(human);
    }

    @Override
    public void updateHuman(Human human) {
        Session session = sessionFactory.getCurrentSession();
        Human humanOnUpdate = session.get(Human.class, human.getId());
        if (humanOnUpdate != null) {
            session.update(human);
        }
    }

    @Override
    public Human getHumanById(Long humanId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Human.class, humanId);
    }

    @Override
    public void deleteHuman(Human human) {
        Session session = sessionFactory.getCurrentSession();
        Human humanOnDelete = session.get(Human.class, human.getId());
        if (humanOnDelete != null) {
            session.delete(human);
        }
    }
}
