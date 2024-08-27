import java.util.Random;

public class Goblin extends Characters {

    public Goblin() {
        super("Обычный гоблин",
                new Random().nextInt(60, 120),
                new Random().nextInt(4, 10),
                new Random().nextInt(2, 5),
                new Random().nextInt(50, 101),
                new Random().nextInt(10, 35));
    }
}
