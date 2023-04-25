package model.match;

public class Card implements ICard {

    int life;
    int attack;
    int maanaCost;
    int effect;

    @Override
    public void loseLife(int damage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loseLife'");
    }

    @Override
    public void useEffect() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'useEffect'");
    }

    @Override
    public void getLife() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLife'");
    }

    @Override
    public void getAttack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAttack'");
    }

    @Override
    public int getMaana() {
        return maanaCost;
    }

    @Override
    public void getEffect() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEffect'");
    }

}
