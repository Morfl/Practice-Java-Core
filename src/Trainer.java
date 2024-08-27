public class Trainer {

    Hero hero;
    public int needExperience;

    public Trainer(Hero hero) {
        this.hero = hero;
        needExperience = 100;
    }

    public void lvlUp(int message) {
        if (message != 1 && message != 2 && message != 3) {
            System.out.println("Введите верный номер");
        } else {
            if (hero.getExperience() >= needExperience) {
                hero.lvlUp(message);
                needExperience += (int) (needExperience * 0.3);
                hero.plusExperience(-needExperience);
                System.out.println("Уровень успешно повышен!");
            } else {
                System.out.println("Слишком мало опыта, возвращайся позже");
            }
        }
    }
}
