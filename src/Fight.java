import java.util.Random;

public class Fight extends Thread {

    Hero hero;

    public Fight(Hero hero) {
        this.hero = hero;
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        int randomValue = new Random().nextInt(2);
        if (randomValue == 0) {
            Goblin goblin = new Goblin();
            System.out.println("Вас атакует " + goblin.getName());
            sleep(1000);
            boolean live = true;
            while (live) {
                int hit1 = goblin.attack();
                int hit2 = hero.attack();
                hero.plusHp(-hit1);
                goblin.plusHp(-hit2);

                if (hit1 == 0) {
                    System.out.println(goblin.getName() + " Промахнулся!");
                    sleep(1000);
                } else {
                    System.out.println(goblin.getName() + " Нанес " + hit1);
                    sleep(1000);
                }

                if (hero.getHp() <= 0) {
                    System.out.println(hero.getName() + " пал в бою! Игра окончена");
                    live = false;
                    System.exit(0);
                }

                if (hit2 == 0) {
                    System.out.println("Промах!");
                    sleep(1000);
                } else {
                    System.out.println("Нанесено " + hit2);
                    sleep(1000);
                }

                if(goblin.getHp() <= 0){
                    System.out.println(goblin.getName() + " пал в бою! Вы победили +" + goblin.getExperience() + " exp +" + goblin.getGold() + " gold");
                    live = false;
                    hero.plusGold(goblin.getGold());
                    hero.plusExperience(goblin.getExperience());
                }
            }
        } else {
            Skeleton skeleton = new Skeleton();
            System.out.println("Вас атакует " + skeleton.getName());
            sleep(1000);
            boolean live = true;
            while (live) {
                int hit1 = skeleton.attack();
                int hit2 = hero.attack();
                hero.plusHp(-hit1);
                skeleton.plusHp(-hit2);

                if (hit1 == 0) {
                    System.out.println(skeleton.getName() + " Промахнулся!");
                    sleep(1000);
                } else {
                    System.out.println(skeleton.getName() + " Нанес " + hit1);
                    sleep(1000);
                }

                if (hero.getHp() <= 0) {
                    System.out.println(hero.getName() + " пал в бою! Игра окончена");
                    live = false;
                    System.exit(0);
                }

                if (hit2 == 0) {
                    System.out.println("Промах!");
                    sleep(1000);
                } else {
                    System.out.println("Нанесено " + hit2);
                    sleep(1000);
                }

                if(skeleton.getHp() <= 0){
                    System.out.println(skeleton.getName() + " пал в бою! Вы победили +" + skeleton.getExperience() + " exp +" + skeleton.getGold() + " gold");
                    live = false;
                    hero.plusGold(skeleton.getGold());
                    hero.plusExperience(skeleton.getExperience());
                }
            }
        }
    }
}
