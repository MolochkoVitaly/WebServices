package com.epam.paytickets.repository.impl;



import com.epam.paytickets.entity.TicketState;
import com.epam.paytickets.entity.TrainTicket;
import com.epam.paytickets.repository.TrainTicketDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class TrainTicketDAOImpl implements TrainTicketDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Long toBookTicket(TrainTicket ticketData) {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(ticketData);
    }

    @Override
    public TrainTicket getTicketByTicketNumber(Long ticketNumber) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(TrainTicket.class, ticketNumber);
    }

    @Override
    public void payTicket(TrainTicket trainTicket) {
        Session session = sessionFactory.getCurrentSession();
        session.update(trainTicket);
    }

    @Override
    public void returnTicket(TrainTicket trainTicket) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(trainTicket);
    }
}
