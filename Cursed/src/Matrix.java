import java.util.Arrays;

public class Matrix<T extends Number> {
    private Object[][] data;
    public Matrix(int r, int c) {
        data = new Object[r][c];
    }
    public T get(int r, int c) {
        if (data.length > r && data[0].length > c) {
            return (T) data[r][c];
        }
        return null;
    }
    public void set(T element, int r, int c) {
        if (data.length > r && data[0].length > c) {
            data[r][c] = element;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (Object[] row : data) {
            sb.append("    [ ");
            for (Object o : row) {
                sb.append(o.toString()).append(" ");
            }
            sb.append("]\n");
        }
        sb.append("]");
        return sb.toString();
    }
    //    public static void main(String[] args) {
//
//        int n = 3;
//        int[][] a = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                a[i][j] = n*i + j;
//            }
//        }
//
//        System.out.println("First matrix");
//        System.out.println("------");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.printf("%4d", a[i][j]);
//            }
//            System.out.println();
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                int temp = a[i][j];
//                a[i][j] = a[j][i];
//                a[j][i] = temp;
//            }
//        }
//
//        System.out.println();
//        System.out.println("New matrix");
//        System.out.println("------");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.printf("%3d", a[i][j]);
//            }
//            System.out.println();
//        }
//
//    }
}

