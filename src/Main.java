import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Как зовут твоего героя?");
        String name = scanner.nextLine();
        Hero hero = new Hero(name);
        Shop poison = new TraderPoison(hero);
        Trainer trainer = new Trainer(hero);
        boolean live = true;
        while (live) {

            System.out.println("Куда вы хотите пойти?");
            System.out.println("1. В тёмный лес");
            System.out.println("2. К торговцу");
            System.out.println("3. К тренеру");
            System.out.println("4. Использовать зелье чтобы восстановить все здоровье (В наличии " + hero.getPotion() + ")");
            System.out.println("5. Статистика");
            System.out.println("6. На выход");
            int num = scanner.nextInt();

            if (num == 1) {
                boolean contin = true;
                while (contin) {
                    try {
                        Thread thread = new Fight(hero);
                        thread.start();
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    hero.getInfoHp();
                    boolean con = true;
                    while (con) {
                        System.out.println("Хотите продолжить? \n1. Да \n2. Нет");
                        int answer = scanner.nextInt();
                        if (answer == 2) {
                            contin = false;
                            con = false;
                        } else if (answer == 1) {
                            con = false;
                        } else {
                            System.out.println("Введите верный номер");
                        }
                    }

                }
            } else if (num == 2) {
                System.out.println("Приветствую, что хотите приобрести?");
                boolean liveShop = true;
                while (liveShop) {
                    System.out.println("1. Купить зелье лечения (50 gold)");
                    System.out.println("2. Выход");
                    int answer = scanner.nextInt();
                    if (answer == 1) {
                        poison.sold();
                    } else if (answer == 2) {
                        liveShop = false;
                    } else {
                        System.out.println("Введите верный номер");
                    }
                }
            } else if (num == 3) {
                boolean liveShop = true;
                while (liveShop) {
                    System.out.println("1. Повысить уровень (" + trainer.needExperience + " experience)");
                    System.out.println("2. Выход");
                    int answer = scanner.nextInt();
                    if (answer == 1) {
                        System.out.println("Что повысить? \n1. Ловкость\n2. Сила\n3. Здоровье");
                        int answerLvl = scanner.nextInt();
                        trainer.lvlUp(answerLvl);
                    } else if (answer == 2) {
                        liveShop = false;
                    } else {
                        System.out.println("Введите верный номер");
                    }
                }
            } else if (num == 4) {
                if (hero.getPotion() > 0) {
                    System.out.println("Здоровье успешно восстановлено");
                    hero.setHp(hero.getMaxHp());
                    hero.plusPotion(-1);
                } else {
                    System.out.println("У вас нет зелий лечений");
                }
            } else if (num == 5) {
                hero.getInfo();
            } else if (num == 6) {
                live = false;
            } else {
                System.out.println("Введите верный номер");
            }
        }
        } catch (RuntimeException e){
            System.out.println("Что-то пошло нет так, пишите команды правильно)");
        }
    }
}

