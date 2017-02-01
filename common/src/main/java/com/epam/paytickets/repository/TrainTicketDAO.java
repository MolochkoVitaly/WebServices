package com.epam.paytickets.repository;


import com.epam.paytickets.entity.TrainTicket;

public interface TrainTicketDAO {
    Long toBookTicket(TrainTicket ticketData);

    TrainTicket getTicketByTicketNumber(Long ticketNumber);

    void payTicket(TrainTicket trainTicket);

    void returnTicket(TrainTicket trainTicket);
}
