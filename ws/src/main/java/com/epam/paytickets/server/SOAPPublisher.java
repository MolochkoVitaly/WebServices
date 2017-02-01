package com.epam.paytickets.server;


import com.epam.paytickets.webservice.impl.TrainTicketWebServiceImpl;

import javax.xml.ws.Endpoint;

public class SOAPPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/ws/tickets", new TrainTicketWebServiceImpl());
    }
}
