import java.util.Random;

public class Utils {

    public static Random RANDOM = new Random();

    public static int random() {
        return RANDOM.nextInt();
    }

    public static int randomIntInBounds(int max) {
        return RANDOM.nextInt(max);
    }

    public static int randomBetween(int min, int max) {
        int diff = max - min;
        return RANDOM.nextInt(diff + 1) + min;
    }

}
