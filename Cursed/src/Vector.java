import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vector<T extends Number> {
    private List<T> data = new ArrayList<>();
    public Vector(T ... data) {
        this.data.addAll(Arrays.asList(data));
    }
    public T get(int index) {
        return data.get(index);
    }
    public int size() {
        return data.size();
    }
    public T front() {
        return data.isEmpty() ? null : data.get(0);
    }
    public T back() {
        return data.isEmpty() ? null : data.get(data.size() - 1);
    }
    public void insert(int index, T element) {
        if (index > 0 && index < data.size()) {
            data.set(index, element);
        }
    }
    public void push_back(T element) {
        data.add(element);
    }
    public void erase(int index) {
        if (index < data.size()) {
            data.remove(data.get(index));
        }
    }
    public int find(T element) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(element)) return i;
        }
        return -1;
    }
    public int accumulateAsInt() {
        int sum = 0;
        for(int i = 0; i < data.size(); i++) {
            sum += data.get(i).intValue();
        }
        return sum;
    }
    public boolean equals(Vector<T> candidate) {
        if (candidate == null) return false;
        if (candidate.size() != data.size()) return false;
        for (int i = 0; i < data.size(); i++) {
            if (!data.get(i).equals(candidate.get(i))) return false;
        }
        return true;
    }
    public void swap(Vector<T> other, int index) {
        if (other.size() > index && data.size() > index) {
            T buffer = other.get(index);
            other.insert(index, data.get(index));
            data.set(index,  buffer);
        }
    }
    // TODO: continue ...
}