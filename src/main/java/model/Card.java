package model;

public class Card {
    private String name;
    private int power;
    private boolean moved = false;

    public Card(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getpower() {
        return power;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Power: " + power;
    }

    public boolean isMoved() {
        return this.moved;
    }

    public void setMoved(boolean b) {
        this.moved = true;
    }
}
