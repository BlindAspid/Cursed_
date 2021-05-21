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
        Matrix<Float> mtx1 = new Matrix<>(2,3);
        mtx1.set(0.0f, 0, 0);
        mtx1.set(0.1f, 0, 1);
        mtx1.set(0.2f, 0, 2);
        mtx1.set(1.0f, 1, 0);
        mtx1.set(1.1f, 1, 1);
        mtx1.set(1.2f, 1, 2);
        System.out.println("mtx1: " + mtx1.toString());
        Matrix<Float> mtx2 = new Matrix<>(2,3);
        mtx2.set(2.0f, 0, 0);
        mtx2.set(2.1f, 0, 1);
        mtx2.set(2.2f, 0, 2);
        mtx2.set(3.0f, 1, 0);
        mtx2.set(3.1f, 1, 1);
        mtx2.set(3.2f, 1, 2);
        System.out.println("mtx2: " + mtx2.toString());
        System.out.println("mtx1 + mtx2: " + mtx1.add(mtx2).toString());
        System.out.println("mtx1 - mtx2: " + mtx1.substract(mtx2).toString());
        Matrix<Integer> mtx3 = new Matrix<>(2,3);
        mtx3.set(1, 0, 0);
        mtx3.set(2, 0, 1);
        mtx3.set(3, 0, 2);
        mtx3.set(4, 1, 0);
        mtx3.set(5, 1, 1);
        mtx3.set(6, 1, 2);
        System.out.println("mtx3: " + mtx3.toString());
        Matrix<Integer> mtx4 = new Matrix<>(3,2);
        mtx4.set(7, 0, 0);
        mtx4.set(8, 0, 1);
        mtx4.set(9, 1, 0);
        mtx4.set(10, 1, 1);
        mtx4.set(11, 2, 0);
        mtx4.set(12, 2, 1);
        System.out.println("mtx4: " + mtx4.toString());
        System.out.println("mtx3 * mtx4: " + mtx3.multiply(mtx4).toString());

    }
}

