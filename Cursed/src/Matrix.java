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
    public Vector<T> getRow(int r) {
        if (r >= data.length) return null;
        Vector<T> row = new Vector<>(data[0].length);
        for (int i = 0; i < row.size(); i++) {
            row.set(i, (T) data[r][i]);
        }
        return row;
    }
    public Vector<T> getColumn(int c) {
        if (c >= data[0].length) return null;
        Vector<T> col = new Vector<>(data.length);
        for (int i = 0; i < col.size(); i++) {
            col.set(i, (T) data[i][c]);
        }
        return col;
    }
    public void set(T element, int r, int c) {
        if (data.length > r && data[0].length > c) {
            data[r][c] = element;
        }
    }
    public int[] size() {
        return new int[]{data.length, data[0].length};
    }

    public <E extends Number> Matrix<Double> multiplyScalar(E scalar) {
        int[] thisSize = size();
        Matrix<Double> result = new Matrix<>(thisSize[0], thisSize[1]);
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[0].length; c++) {
                T thisEl = (T) data[r][c];
                Double resultingEl = thisEl.doubleValue() * scalar.doubleValue();
                result.set(resultingEl,r, c);
            }
        }
        return result;
    }

    public Matrix<Double> multiply(Matrix<T> other) {
        if (other == null) return null;
        int[] otherSize = other.size();
        int[] thisSize = size();
        if (thisSize[1] != otherSize[0]) return null;

        Matrix<Double> result = new Matrix<>(thisSize[0], otherSize[1]);

        for (int r = 0; r < result.size()[0]; r++) {
            for (int c = 0; c < result.size()[1]; c++) {
                Double resultEl = calculateMultiplyElement(getRow(r), other.getColumn(c));
                result.set(resultEl, r, c);
            }
        }
        return result;
    }
    private Double calculateMultiplyElement(Vector<T> rowI, Vector<T> colJ) {
        Double result = 0.0;
        for (int i = 0; i < rowI.size(); i++) {
            result += rowI.get(i).doubleValue() * colJ.get(i).doubleValue();
        }
        return result;
    }

    public Matrix<Double> substract(Matrix<T> other) {
        return this.add(other.multiplyScalar(-1));
    }

    public <E extends Number> Matrix<Double> add(Matrix<E> other) {
        if (other == null) return null;
        int[] otherSize = other.size();
        int[] thisSize = size();
        if (otherSize[0] != thisSize[0] || otherSize[1] != thisSize[1]) return null;
        Matrix<Double> result = new Matrix<>(thisSize[0], thisSize[1]);
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[0].length; c++) {
                T thisEl = (T) data[r][c];
                T otherEl = (T) other.get(r, c);
                Double resultingEl = thisEl.doubleValue() + otherEl.doubleValue();
                result.set(resultingEl,r, c);
            }
        }
        return result;
    }

    public boolean equals(Matrix<T> other) {
        if (other == null) return false;
        int[] otherSize = other.size();
        int[] thisSize = size();
        if (otherSize[0] != thisSize[0] || otherSize[1] != thisSize[1]) return false;
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[0].length; c++) {
                if (!data[r][c].equals(other.get(r, c))) return false;
            }
        }
        return true;
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

