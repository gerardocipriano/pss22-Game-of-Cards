package model;
/*
 * This class represents a prototype of a card, since the class 'Card' has not yet been properly defined this is just an example
 */
public class Card {
    private String name;
    private int attack;
    private int defense;
    private boolean moved;
    private String image;

    public Card(String name, int attack) {
            this.name = name;
            this.attack = attack;
            this.moved = false;
        }

    public Card(String name, int attack, String image) {
        this.name = name;
        this.attack = attack;
        this.moved = false;
        this.image = image;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public String toString() {
        return this.name + " Attack: " + this.attack + " Defense: " + this.defense;
    }

    public String getImage(){
        return this.image;
    }

    public void setImage(String image){
        this.image = image;
    }
}
