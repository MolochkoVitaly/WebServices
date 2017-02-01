package com.epam.paytickets.webservice.impl;


import com.epam.paytickets.entity.TrainTicket;
import com.epam.paytickets.service.TrainTicketService;
import com.epam.paytickets.webservice.TrainTicketWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "com.epam.paytickets.webservice.TrainTicketWebService")
@Service
public class TrainTicketWebServiceImpl implements TrainTicketWebService {

    @Autowired
    private TrainTicketService ticketService;

    @WebMethod
    public Long toBookTicket(TrainTicket ticketData) {
        return ticketService.toBookTicket(ticketData);
    }

    @WebMethod
    public TrainTicket getTicketByTicketNumber(Long ticketNumber) {
        return ticketService.getTicketByTicketNumber(ticketNumber);
    }

    @WebMethod
    public void payTicket(Long ticketId) {
        ticketService.payTicket(ticketId);
    }

    @WebMethod
    public void returnTicket(Long ticketId) {
        ticketService.returnTicket(ticketId);
    }

}
