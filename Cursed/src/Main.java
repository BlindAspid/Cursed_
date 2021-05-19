import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Vector<Integer> testVector = new Vector<>(1, 2, 3, 4, 5);
        System.out.printf("first: %d\n", testVector.front());
        System.out.printf("last: %d\n", testVector.back());
        System.out.printf("third: %d\n", testVector.get(2));
        System.out.printf("size: %d\n", testVector.size());
        //Test it
    }
}

