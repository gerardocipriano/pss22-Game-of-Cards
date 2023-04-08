package model.deckmanagement;


public class DeckCard {
    private String name;
    private int attack;
    private int defense;
    private boolean moved;

    public DeckCard(String name, int attack) {
        this.name = name;
        this.attack = attack;
        this.moved = false;
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
}
