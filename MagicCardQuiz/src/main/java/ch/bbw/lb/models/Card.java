package ch.bbw.lb.models;

import org.bson.Document;

public class Card {

    private String name;
    private String type;
    private String rarity;
    private int cost;
    private int power;
    private int toughness;

    private Card(String name, String type, String rarity, int cost, int power, int toughness) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.cost = cost;
        this.power = power;
        this.toughness = toughness;
    }

    public static Card fromDb(Document document) {
        return new Card(
                document.getString("name"),
                document.getString("type"),
                document.getString("rarity"),
                document.getInteger("cost", 0),
                document.getInteger("power", 0),
                document.getInteger("toughness", 0)
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }
}
