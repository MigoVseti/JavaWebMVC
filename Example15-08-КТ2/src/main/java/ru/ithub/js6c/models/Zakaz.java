package ru.ithub.js6c.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "zakaz")
public class Zakaz {

    @Id
    @Column(name = "zakaz_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateOfOrder;

    @NotEmpty
    @Column(name = "number")
    private int number;

    @OneToMany(mappedBy = "zakaz")
    private List<Article> articleList;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "user_id")
    private Person owner;

    public Zakaz() {
    }

    public Zakaz(Date dateOfOrder, int number) {
        this.dateOfOrder = dateOfOrder;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Zakaz{" +
                "id=" + id +
                ", dateOfOrder=" + dateOfOrder +
                ", number=" + number +
                ", owner=" + owner +
                '}';
    }
}
