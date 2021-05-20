import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vector<T extends Number> {
    private Object[] data;
    public Vector(T ... data) {
        this.data = new Object[data.length];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
        }
    }
    public T get(int index) {
        return (T) data[index];
    }
    public int size() {
        return data.length;
    }
    public T front() {
        return data.length == 0 ? null : (T) data[0];
    }
    public T back() {
        return data.length == 0 ? null : (T) data[data.length - 1];
    }
    public void set(int index, T element) {
        if (index > 0 && index < data.length) {
            data[index] = element;
        }
    }
    public void insert(int index, T element) {
        Object[] bigger = new Object[data.length + 1];
        for (int i = 0; i < index; i++) {
            bigger[i] = data[i];
        }
        bigger[index] = element;
        for (int i = index; i < data.length; i++) {
            bigger[i + 1] = data[i];
        }
        data = bigger;
    }
    public void push_back(T element) {
        Object[] bigger = new Object[data.length + 1];
        for (int i = 0; i < data.length; i++) {
            bigger[i] = data[i];
        }
        bigger[bigger.length - 1] = element;
        data = bigger;
    }
    public void erase(int index) {
        if (index < data.length) {
            data[index] = null;
        }
    }

    public void remove(int index) {
        erase(index);
        Object[] smaller = new Object[data.length - 1];
        int newi = 0;
        for (int i = 0; i < data.length; i++) {
            if (i != index) {
                smaller[newi++] = data[i];
            }
        }
        data = smaller;
    }
    public int find(T element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(element)) return i;
        }
        return -1;
    }
    public int accumulateAsInt() {
        int sum = 0;
        for(int i = 0; i < data.length; i++) {
            sum += ((T) data[i]).intValue();
        }
        return sum;
    }
    public boolean equals(Vector<T> candidate) {
        if (candidate == null) return false;
        if (candidate.size() != data.length) return false;
        for (int i = 0; i < data.length; i++) {
            if (!data[i].equals(candidate.get(i))) return false;
        }
        return true;
    }
    public void swap(Vector<T> other, int index) {
        if (other.size() > index && data.length > index) {
            T buffer = other.get(index);
            other.insert(index, (T) data[index]);
            data[index] = buffer;
        }
    }
    // TODO: continue ...

    @Override
    public String toString() {
        return "Vector{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}