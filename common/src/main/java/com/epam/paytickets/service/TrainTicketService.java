package com.epam.paytickets.service;


import com.epam.paytickets.entity.TrainTicket;

public interface TrainTicketService {
    Long toBookTicket(TrainTicket ticketData);

    TrainTicket getTicketByTicketNumber(Long ticketNumber);

    void payTicket(TrainTicket trainTicket);

    void returnTicket(TrainTicket trainTicket);
}
