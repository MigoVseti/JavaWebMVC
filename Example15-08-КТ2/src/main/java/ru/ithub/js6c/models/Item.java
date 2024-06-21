package ru.ithub.js6c.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(name = "name")
    private String Name;

    @NotEmpty
    @Column(name = "cost")
    private int cost;

    @OneToMany(mappedBy = "item")
    private List<Article> articles;

    public Item() {
    }

    public Item(String name, int cost) {
        Name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
