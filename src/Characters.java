import java.util.Random;

public class Characters implements CanFight{

    private String name;
    private int hp;
    private int agility;
    private int strength;
    private int experience;
    private int gold;

    public Characters(String name, int hp, int agility, int strength, int experience, int gold) {
        this.name = name;
        this.hp = hp;
        this.agility = agility;
        this.strength = strength;
        this.experience = experience;
        this.gold = gold;
    }

    public void plusGold(int gold) {
        setGold(getGold() + gold);
    }

    public void plusExperience(int experience) {
        setExperience(getExperience() + experience);
    }

    public void plusHp(int hp) {
        setHp(getHp() + hp);
    }


    public int attack() {

        //Сила удара
        int randomValue1 = new Random().nextInt(-5, 6);
        int attackValue = getStrength() * 4 + randomValue1;

        //Шанс крита
        int randomValue2 = new Random().nextInt(10);
        if (7 < randomValue2) {
            attackValue = attackValue * 2;
        }

        //Шанс на уклонение
        double chance = 0;
        for (int i = 0; i < getAgility(); i++) {
            chance += (100 - chance) / 5;
        }
        int randomValue3 = new Random().nextInt(101);
        if (chance <= randomValue3) {
            return 0;
        } else {
            return attackValue;
        }
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAgility() {
        return agility;
    }

    public int getStrength() {
        return strength;
    }

    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
