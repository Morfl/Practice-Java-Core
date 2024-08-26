import java.util.Random;

public class Hero {

    private String name;
    private int maxHp;
    private int hp;
    private int agility;
    private int strength;
    private int experience;
    private int gold;

    private int potion;

    public int getHp() {
        return hp;
    }

    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public void giveGold(int gold) {
        this.gold -= gold;
    }

    public void giveExperience(int experience) {
        this.experience -= experience;
    }

    public Hero(String name) {
        this.name = name;
        this.maxHp = 100;
        this.hp = maxHp;
        this.agility = 5;
        this.strength = 8;
        this.experience = 200;
        this.gold = 50;
        this.potion = 1;
    }

    public void experiencePlus(int value) {
        experience += value;
    }

    private void upMaxHp() {
        maxHp += 20;
    }

    private void upStrength() {
        strength += 1;
    }

    private void upAgility() {
        agility += 1;
    }

    public String lvlUp(int attribute) {
        if (attribute == 1) {
            upAgility();
        } else if (attribute == 2) {
            upStrength();
        } else if (attribute == 3) {
            upMaxHp();
        } else {
            return "error";
        }
        return "excellent";
    }

    public int attack() {

        //Сила удара
        int randomValue1 = new Random().nextInt(-5, 6);
        int attackValue = strength * 4 + randomValue1;

        //Шанс крита
        int randomValue2 = new Random().nextInt(10);
        if (7 < randomValue2) {
            attackValue = attackValue * 2;
        }

        //Шанс на уклонение
        double chance = 0;
        for (int i = 0; i < agility; i++) {
            chance += (100 - chance) / 5;
        }
        int randomValue3 = new Random().nextInt(101);
        if (chance <= randomValue3) {
            return 0;
        } else {
            return attackValue;
        }
    }

    public void getInfoHp(){
        System.out.println("У вас осталось " + getHp() + " очков здоровья");
    }

    public void getInfo(){
        System.out.println(name  + "\nЗдоровье " + getHp() +"("+ maxHp + ") \n" + "Ловкость " + agility + "\nСила " + strength + "\nОпыт " + experience + "\nЗолото " + gold);
    }

    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp -= hp;
    }

    public void resetHp(int hp) {
        this.hp = hp;
    }

    public void setExperience(int experience) {
        this.experience += experience;
    }

    public void setGold(int gold) {
        this.gold += gold;
    }

    public int getPotion() {
        return potion;
    }

    public void setPotion(int potion) {
        this.potion += potion;
    }

    public int getMaxHp() {
        return maxHp;
    }
}
