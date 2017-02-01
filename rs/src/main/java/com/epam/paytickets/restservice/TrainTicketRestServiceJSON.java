package com.epam.paytickets.restservice;


import com.epam.paytickets.config.AppConfig;
import com.epam.paytickets.entity.Human;
import com.epam.paytickets.entity.TrainTicket;
import com.epam.paytickets.service.TrainTicketService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("/json/tickets")
public class TrainTicketRestServiceJSON {

    private final ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    private TrainTicketService ticketService = (TrainTicketService)ac.getBean("trainTicketServiceImpl");


    @GET
    @Path("/{ticketId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketByTicketNumber(@PathParam("ticketId") Long ticketNumber) {
        TrainTicket ticket = ticketService.getTicketByTicketNumber(ticketNumber);
        if (ticket != null) {
            GenericEntity<TrainTicket> entity = new GenericEntity<>(ticket, TrainTicket.class);
            return Response.status(Response.Status.OK).entity(entity).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/tickets/{humanId}/book")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bookTicket(@PathParam("humanId") Long humanId, TrainTicket ticket) throws URISyntaxException {
        ticket.setHuman(new Human() {
            {
                setId(humanId);
            }
        });
        Long ticketId = ticketService.toBookTicket(ticket);
        TrainTicket insertedTicket = ticketService.getTicketByTicketNumber(ticketId);
        if (insertedTicket != null) {
            return Response.status(Response.Status.OK).entity(insertedTicket).build();
        } else {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    @PUT
    @Path("/tickets")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response payTicket(TrainTicket ticket){
        TrainTicket notPaid = ticketService.getTicketByTicketNumber(ticket.getTicketNumber());
        if (notPaid != null){
            ticketService.payTicket(notPaid);
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/tickets/{ticketId}")
    public Response returnTicket(@PathParam("ticketId") Long ticketId){
        TrainTicket ticket = ticketService.getTicketByTicketNumber(ticketId);
        if (ticket != null) {
            ticketService.returnTicket(ticket);
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.ACCEPTED).entity("Successfully deleted!").build();
    }
}
