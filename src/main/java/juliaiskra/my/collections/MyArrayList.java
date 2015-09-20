package juliaiskra.my.collections;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;

/**
 * @author Yuliya Kupryakova
 */
public class MyArrayList<E> extends AbstractList<E> {
    private int capacity = 8;
    private E[] array;
    private int size;

    public MyArrayList(Class<E> aClass) {
        //noinspection unchecked
        array = (E[]) Array.newInstance(aClass, capacity);
        this.size = 0;
    }

    @Override
    public E get(int index) {
        checkIndexBoundsForExistingElements(index);
        return array[index];
    }

    @Override
    public void add(int index, E element) {
        checkIndexBoundsForNewElements(index);

        if (size == capacity) {
            capacity = capacity * 2;
            resizeArray();
        }

        size++;
        for (int i = index; i < size; i++) {
            element = replaceElement(i, element);
        }
    }

    @Override
    public E set(int index, E element) {
        checkIndexBoundsForExistingElements(index);
        return replaceElement(index, element);
    }

    @Override
    public E remove(int index) {
        checkIndexBoundsForExistingElements(index);
        E old = null;
        for (int i = size - 1; i >= index; i--) {
            old = replaceElement(i, old);
        }
        size--;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Trims the capacity of this <tt>ArrayList</tt> instance to be the list's current size.  An application can use
     * this operation to minimize the storage of an <tt>ArrayList</tt> instance.
     */
    public void trimToSize() {
        capacity = size;
        resizeArray();
    }

    /**
     * Increases the capacity of this <tt>ArrayList</tt> instance, if necessary, to ensure that it can hold at least the
     * number of elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    public void ensureCapacity(int minCapacity) {
        if (capacity < minCapacity) {
            capacity = minCapacity;
            resizeArray();
        }
    }

    private void resizeArray() {
        array = Arrays.copyOf(array, capacity);
    }

    private E replaceElement(int index, E element) {
        E old = array[index];
        array[index] = element;
        return old;
    }

    private void checkIndexBoundsForExistingElements(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkIndexBoundsForNewElements(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
