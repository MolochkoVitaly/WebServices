package com.epam.paytickets.entity;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "HUMANS")
@Entity
@XmlRootElement(name = "human")
public class Human implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "human_seq")
    @SequenceGenerator(name = "human_seq", sequenceName = "HUMANS_SEQ")
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PATRONYMIC", nullable = false)
    private String patronymic;

    @Column(name = "BIRTHDAY", nullable = false)
    private Date birthday;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "human", cascade = CascadeType.ALL)
    private List<TrainTicket> tickets;

    public Human() {
    }

    @XmlAttribute
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @XmlElement
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @XmlTransient
    public List<TrainTicket> getTickets() {
        return tickets;
    }

    public void setTickets(List<TrainTicket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;

        Human human = (Human) o;

        if (id != null ? !id.equals(human.id) : human.id != null) return false;
        if (surname != null ? !surname.equals(human.surname) : human.surname != null) return false;
        if (name != null ? !name.equals(human.name) : human.name != null) return false;
        if (patronymic != null ? !patronymic.equals(human.patronymic) : human.patronymic != null) return false;
        return !(birthday != null ? !birthday.equals(human.birthday) : human.birthday != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday + '}';
    }
}
