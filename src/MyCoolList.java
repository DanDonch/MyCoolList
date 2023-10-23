import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class MyCoolList<T extends Number> implements Iterable<T> {
    private T[] array;
    private int size;
    public MyCoolList() {
        array = (T[]) new Number[16];
        size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            T[] newArray = (T[]) new Number[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size] = element;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public int size() {
        return size;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, array[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removedElement = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
        return removedElement;
    }
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }
    public <T> T[] toArray(T[] array) {
        if (array.length < size)
            return (T[]) Arrays.copyOf(this.array, size, array.getClass());
        System.arraycopy(this.array, 0, array, 0, size);
        if (array.length > size)
            array[size] = null;
        return array;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public MyCoolList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        MyCoolList<T> sublist = new MyCoolList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            sublist.add(array[i]);
        }
        return sublist;
    }


    public Iterator<T> iterator() {
        return new MyCoolListIterator();
    }

    private class MyCoolListIterator implements Iterator<T> {
        private int index = 0;

        public boolean hasNext() {
            return index < size;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[index++];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MyCoolList<?> otherList = (MyCoolList<?>) obj;
        if (size != otherList.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(otherList.array[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < size; i++) {
            result = 31 * result + array[i].hashCode();
        }
        return result;
    }
}
