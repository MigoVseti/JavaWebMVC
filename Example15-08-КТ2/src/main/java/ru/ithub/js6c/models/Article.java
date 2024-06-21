package ru.ithub.js6c.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @Column(name = "article_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Min(value = 0, message = "Amount should be greater than 0")
    @Column(name = "amount")
    private int amount;

    @NotEmpty
    @Column(name = "cost")
    private int cost;

    @ManyToOne
    @JoinColumn(name = "items_id", referencedColumnName = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "zakaz_id")
    private Zakaz zakaz;

    public Article() {
    }

    public Article(int amount, int cost) {
        this.amount = amount;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", amount=" + amount +
                ", cost=" + cost +
                '}';
    }
}
