import java.util.Random;

public class Skeleton {

    private String name = "Дряхлый скелет";
    private int hp;
    private int agility;
    private int strength;
    private int experience;
    private int gold;

    public Skeleton() {
        hp = new Random().nextInt(30, 60);
        agility = new Random().nextInt(2, 4);
        strength = new Random().nextInt(5, 10 );
        experience = new Random().nextInt(60, 121);
        gold = new Random().nextInt(20, 46);
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

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public void setHp(int hp) {
        this.hp -= hp;
    }
}
