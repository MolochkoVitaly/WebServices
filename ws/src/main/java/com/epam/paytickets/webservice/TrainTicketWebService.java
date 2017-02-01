package com.epam.paytickets.webservice;

import com.epam.paytickets.entity.TrainTicket;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface TrainTicketWebService {
    @WebMethod
    Long toBookTicket(TrainTicket ticketData);

    @WebMethod
    TrainTicket getTicketByTicketNumber(Long ticketNumber);

    @WebMethod
    void payTicket(Long ticketId);

    @WebMethod
    void returnTicket(Long ticketId);
}
