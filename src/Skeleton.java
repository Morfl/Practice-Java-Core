import java.util.Random;

public class Skeleton extends Characters {

    public Skeleton() {
        super("Обычный гоблин",
                new Random().nextInt(30, 60),
                new Random().nextInt(2, 4),
                new Random().nextInt(5, 10 ),
                new Random().nextInt(60, 121),
                new Random().nextInt(20, 46));
    }
}
