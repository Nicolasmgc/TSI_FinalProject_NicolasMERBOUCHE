package com.isep.finaltask;


import javax.persistence.*;

@Entity
public class Game {
    private @Id @GeneratedValue Long id;
    private String name;
    private int players;
    private double price;
    public Game(){}

    public Game (Long id, String name, int players, double price ){
        this.id = id;
        this.name = name;
        this.players = players;
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }
    public int getPlayers() {
        return this.players;
    }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }
}
