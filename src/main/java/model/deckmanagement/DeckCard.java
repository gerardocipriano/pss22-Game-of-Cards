package model.deckmanagement;


public class DeckCard {
    private String name;
    private int value;
    private boolean moved;

    public DeckCard(String name, int value) {
        this.name = name;
        this.value = value;
        this.moved = false;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public String toString() {
        return this.name + " Attack: " + this.value;
    }
}
