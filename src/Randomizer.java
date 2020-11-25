import java.util.Random;

public class Randomizer {
    static String chars = "abcdefghijklmnopqrstuvwxyz1234567890";

    static String generateRandomString(int count) {
        StringBuilder res = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            char c = chars.charAt(rand.nextInt(chars.length()));
            res.append(c);
        }

        return res.toString();
    }
}
