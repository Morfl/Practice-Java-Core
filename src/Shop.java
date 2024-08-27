public abstract class Shop {

    Hero hero;

    public Shop(Hero hero) {
        this.hero = hero;
    }

    abstract void sold();

}
