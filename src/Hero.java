public class Hero extends Characters {

    private int maxHp;
    private int potion;

    public Hero(String name) {
        super(name, 100, 5, 8, 2000, 50);

        this.maxHp = 100;
        this.potion = 1;

    }

    public void plusPotion(int potion) {
        this.potion += potion;
    }

    private void upMaxHp() {
        maxHp += 20;
    }

    private void upStrength() {
        setStrength(getStrength() + 1);
    }

    private void upAgility() {
        setAgility(getAgility() + 1);
    }

    public void lvlUp(int attribute) {
        if (attribute == 1) {
            upAgility();
        } else if (attribute == 2) {
            upStrength();
        } else if (attribute == 3) {
            upMaxHp();
        }
    }

    public void getInfoHp(){
        System.out.println("У вас осталось " + getHp() + " очков здоровья");
    }

    public void getInfo(){
        System.out.printf("%s \nЗдоровье %d(%d) \nЛовкость %d\nСила %d\nОпыт %d\nЗолото %d \n", getName(), getHp(), getMaxHp(), getAgility(), getStrength(), getExperience(), getGold());
    }

    public int getPotion() {
        return potion;
    }

    public int getMaxHp() {
        return maxHp;
    }
}
