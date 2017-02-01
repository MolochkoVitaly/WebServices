package com.epam.paytickets.service.impl;


import com.epam.paytickets.entity.TicketState;
import com.epam.paytickets.entity.TrainTicket;
import com.epam.paytickets.repository.TrainTicketDAO;
import com.epam.paytickets.service.TrainTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TrainTicketServiceImpl implements TrainTicketService {
    @Autowired
    private TrainTicketDAO trainTicketDAO;

    @Override
    public Long toBookTicket(TrainTicket ticketData) {
        ticketData.setTicketState(TicketState.BOOKED);
        return trainTicketDAO.toBookTicket(ticketData);
    }

    @Override
    public TrainTicket getTicketByTicketNumber(Long ticketNumber) {
        return trainTicketDAO.getTicketByTicketNumber(ticketNumber);
    }

    @Override
    public void payTicket(TrainTicket trainTicket) {
        trainTicket.setTicketState(TicketState.PAID);
        trainTicketDAO.payTicket(trainTicket);
    }

    @Override
    public void returnTicket(TrainTicket trainTicket) {
        trainTicketDAO.returnTicket(trainTicket);
    }
}
