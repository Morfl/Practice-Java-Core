public class Shop {
    Hero hero;
    int needExperience = 100;

    public Shop(Hero hero) {
        this.hero = hero;
    }

    public void soldPotion() {
        if (hero.getGold() >= 50) {
            System.out.println("Зелье успешно куплено");
            hero.setPotion(1);
            hero.giveGold(50);
        } else {
            System.out.println("У тебя не хватает денег");

        }
    }

    public void lvlUp(int message) {
        if (hero.lvlUp(message).equals("error")) {
            System.out.println("Введите верный номер");
        } else {
            if (hero.getExperience() >= needExperience) {
                hero.lvlUp(message);
                needExperience += (int) (needExperience * 0.3);
                hero.giveExperience(needExperience);
                System.out.println("Уровень успешно повышен!");
            } else {
                System.out.println("Слишком мало опыта, возвращайся позже");
            }
        }
    }

}
