public class TraderPoison extends Shop {


    public TraderPoison(Hero hero) {
        super(hero);
    }

    @Override
    public void sold() {
        if (hero.getGold() >= 50) {
            System.out.println("Зелье успешно куплено");
            hero.plusPotion(1);
            hero.plusGold(-50);
        } else {
            System.out.println("У тебя не хватает денег");
        }
    }
}
