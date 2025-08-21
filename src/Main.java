import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String s = "Hello World";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                System.out.println("半角空格在索引 " + i);
            }
        }
    }
}
