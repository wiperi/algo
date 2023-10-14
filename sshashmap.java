import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class sshashmap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> window = new HashMap<>();
        HashMap<Integer, Integer> window2 = new HashMap<>();
        window.put(2, 1);
        window.put(1, 1);
        window2.put(1, 1);
        window2.put(2, 1);

        System.out.println(window.equals(window2));
    }
}
