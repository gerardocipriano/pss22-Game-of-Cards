package model;

import java.util.Objects;

public class Card {
    private String name;
    private int value;
    private boolean moved;

    public Card(String name, int value) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Card other = (Card) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }

        if (this.value != other.value) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + this.value;
        return hash;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.value;
    }
}
