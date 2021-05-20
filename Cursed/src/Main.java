import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Vector<Double> testVector = new Vector<>(1.5, 2.3, 3.5, 4.6, 5.2);
        System.out.printf("first: %f\n", testVector.front());
        System.out.printf("last: %f\n", testVector.back());
        System.out.printf("third: %f\n", testVector.get(2));
        System.out.printf("size: %d\n", testVector.size());
        testVector.push_back(7.3);
        System.out.printf("push_back 7: %s\n", testVector.toString());
        testVector.remove(3);
        System.out.printf("remove element at index 3: %s\n", testVector.toString());
        testVector.insert(3, 11.9);
        System.out.printf("insert 11 at 3: %s\n", testVector.toString());
        //Test it

        System.out.println("=====Matrix=====");
        Matrix<Float> mtx = new Matrix<>(2,3);
        mtx.set(0.0f, 0, 0);
        mtx.set(0.1f, 0, 1);
        mtx.set(0.2f, 0, 2);
        mtx.set(1.0f, 1, 0);
        mtx.set(1.1f, 1, 1);
        mtx.set(1.2f, 1, 2);
        System.out.println("Matrix: " + mtx.toString());
    }
}

