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
    private int size = 0;
    private int offset = 0;

    public MyArrayList(Class<E> aClass) {
        //noinspection unchecked
        array = (E[]) Array.newInstance(aClass, capacity);
    }

    @Override
    public E get(int index) {
        checkIndexBoundsForExistingElements(index);
        return array[calculateActualIndex(index)];
    }

    @Override
    public E set(int index, E element) {
        checkIndexBoundsForExistingElements(index);
        return replaceActualElement(calculateActualIndex(index), element);
    }

    @Override
    public void add(int index, E element) {
        checkIndexBoundsForNewElements(index);

        increaseSize();
        int actualIndex = calculateActualIndex(index);
        shiftActualArrayFrom(actualIndex);
        replaceActualElement(actualIndex, element);
    }

    @Override
    public E remove(int index) {
        checkIndexBoundsForExistingElements(index);

        int actualIndex = calculateActualIndex(index);
        E old = replaceActualElement(actualIndex, null);
        shiftActualArrayTo(actualIndex);
        decreaseSize();

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

    private void checkIndexBoundsForExistingElements(int index) {
        if (index >= 0 && index < size) {
            return;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkIndexBoundsForNewElements(int index) {
        if (index >= 0 && index <= size) {
            return;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseSize() {
        if (size == capacity) {
            capacity = capacity * 2;
            resizeArray();
        }
        size++;
    }

    private void decreaseSize() {
        size--;
    }

    private void resizeArray() {
        // todo add newCapacity as a parameter
        // todo change implementation
        array = Arrays.copyOf(array, capacity);
    }

    private void shiftActualArrayTo(int actualIndex) {
        // todo implement
        if (closerToLeft(actualIndex)) {
            shiftFromLeftTo(actualIndex);
        } else {
            shiftFromRightTo(actualIndex);
        }
    }

    private boolean closerToLeft(int actualIndex) {
        //todo implement
        return false;
    }

    private void shiftFromLeftTo(int actualIndex) {
        // todo implement

    }

    private void shiftFromRightTo(int actualIndex) {
        // todo implement

    }

    private void shiftActualArrayFrom(int actualIndex) {
        // todo implement
        if (closerToLeft(actualIndex)) {
            shiftToLeftFrom(actualIndex);
        } else {
            shiftToRightFrom(actualIndex);
        }
    }

    private void shiftToLeftFrom(int actualIndex) {
        //todo implement

    }

    private void shiftToRightFrom(int actualIndex) {
        //todo implement

    }

    private E replaceActualElement(int actualIndex, E element) {
        E old = array[actualIndex];
        array[actualIndex] = element;
        return old;
    }

    private int calculateActualIndex(int index) {
        int actualIndex = index + offset;
        if (actualIndex >= capacity) {
            actualIndex = actualIndex - capacity;
        }
        return actualIndex;
    }
}
