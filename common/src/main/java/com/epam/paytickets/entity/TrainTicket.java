package com.epam.paytickets.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TRAIN_TICKETS")
@XmlRootElement(name = "trainTicket")
public class TrainTicket implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "ticket_seq")
    @SequenceGenerator(name = "ticket_seq", sequenceName = "TICKETS_SEQ")
    @Column(name = "TICKET_NUMBER", nullable = false, unique = true)
    private Long ticketNumber;

    @Column(name = "DEPARTURE_CITY", nullable = false)
    private String departureCity;

    @Column(name = "ARRIVAL_CITY", nullable = false)
    private String arrivalCity;

    @Column(name = "DATE_TIME_DEPARTURE", nullable = false)
    private Date dateTimeDeparture;

    @Column(name = "DATE_TIME_ARRIVAL", nullable = false)
    private Date dateTimeArrival;

    @Column(name = "PRICE", nullable = false)
    private Float price;

    @Enumerated(EnumType.STRING)
    @Column(name = "TICKET_STATE", nullable = false)
    private TicketState ticketState;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "HUMAN_ID", nullable = false)
    private Human human;

    public TrainTicket() {
    }

    @XmlAttribute
    public Long getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @XmlElement
    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    @XmlElement
    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    @XmlElement
    public Date getDateTimeDeparture() {
        return dateTimeDeparture;
    }

    public void setDateTimeDeparture(Date dateTimeDeparture) {
        this.dateTimeDeparture = dateTimeDeparture;
    }

    @XmlElement
    public Date getDateTimeArrival() {
        return dateTimeArrival;
    }

    public void setDateTimeArrival(Date dateTimeArrival) {
        this.dateTimeArrival = dateTimeArrival;
    }

    @XmlElement
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @XmlElement
    public TicketState getTicketState() {
        return ticketState;
    }

    public void setTicketState(TicketState ticketState) {
        this.ticketState = ticketState;
    }

    public Human getHuman() {
        return human;
    }

    @XmlTransient
    public void setHuman(Human human) {
        this.human = human;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainTicket)) return false;

        TrainTicket that = (TrainTicket) o;

        if (ticketNumber != null ? !ticketNumber.equals(that.ticketNumber) : that.ticketNumber != null) return false;
        if (departureCity != null ? !departureCity.equals(that.departureCity) : that.departureCity != null)
            return false;
        if (arrivalCity != null ? !arrivalCity.equals(that.arrivalCity) : that.arrivalCity != null) return false;
        if (dateTimeDeparture != null ? !dateTimeDeparture.equals(that.dateTimeDeparture) : that.dateTimeDeparture != null)
            return false;
        if (dateTimeArrival != null ? !dateTimeArrival.equals(that.dateTimeArrival) : that.dateTimeArrival != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return ticketState == that.ticketState;

    }

    @Override
    public int hashCode() {
        int result = ticketNumber != null ? ticketNumber.hashCode() : 0;
        result = 31 * result + (departureCity != null ? departureCity.hashCode() : 0);
        result = 31 * result + (arrivalCity != null ? arrivalCity.hashCode() : 0);
        result = 31 * result + (dateTimeDeparture != null ? dateTimeDeparture.hashCode() : 0);
        result = 31 * result + (dateTimeArrival != null ? dateTimeArrival.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (ticketState != null ? ticketState.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TrainTicket{" +
                "ticketNumber=" + ticketNumber +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", dateTimeDeparture=" + dateTimeDeparture +
                ", dateTimeArrival=" + dateTimeArrival +
                ", price=" + price +
                ", ticketState=" + ticketState +
                '}';
    }
}
