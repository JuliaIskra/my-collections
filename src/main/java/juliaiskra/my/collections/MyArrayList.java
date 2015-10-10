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
    private final Class<E> aClass;

    public MyArrayList(Class<E> aClass) {
        this.aClass = aClass;
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
        if (closerToLeft(index)) {
            shiftToLeftFrom(actualIndex);
        } else {
            shiftToRightFrom(actualIndex);
        }
        replaceActualElement(actualIndex, element);
    }

    @Override
    public E remove(int index) {
        checkIndexBoundsForExistingElements(index);

        int actualIndex = calculateActualIndex(index);
        E old = replaceActualElement(actualIndex, null);
        if (closerToLeft(index)) {
            shiftFromLeftTo(actualIndex);
        } else {
            shiftFromRightTo(actualIndex);
        }
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
        resizeArray(size);
    }

    /**
     * Increases the capacity of this <tt>ArrayList</tt> instance, if necessary, to ensure that it can hold at least the
     * number of elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    public void ensureCapacity(int minCapacity) {
        if (capacity < minCapacity) {
            resizeArray(minCapacity);
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
            resizeArray(capacity * 2);
        }
        size++;
    }

    private void decreaseSize() {
        size--;
    }

    private void resizeArray(int newCapacity) {
        E[] newArray = (E[]) Array.newInstance(aClass, newCapacity);
        copyInNaturalOrder(array, newArray);
        array = newArray;
        capacity = newCapacity;
    }

    private boolean closerToLeft(int index) {
        return index < size / 2;
    }

    private void copyInNaturalOrder(E[] oldArray, E[] newArray) {
        int oldIndex = offset;

        for (int newIndex = 0; newIndex < size; newIndex++) {
            newArray[newIndex] = oldArray[oldIndex];

            // move oldIndex to the right, cycling over boundary
            if (oldIndex == capacity - 1) {
                oldIndex = 0;
            } else {
                oldIndex++;
            }
        }

        offset = 0;
    }

    private void shiftFromLeftTo(int actualIndex) {
        int fromIndex;
        for (int toIndex = actualIndex; toIndex != offset; toIndex = fromIndex) {
            // fromIndex is on the left of toIndex, cycling over boundary
            if (toIndex == 0) {
                fromIndex = capacity - 1;
            } else {
                fromIndex = toIndex - 1;
            }

            array[toIndex] = array[fromIndex];
        }

        array[offset] = null;

        // move offset to the right, cycling over boundary
        if (offset == capacity - 1) {
            offset = 0;
        } else {
            offset++;
        }
    }

    private void shiftFromRightTo(int actualIndex) {
        int lastOffset = getLastOffset();

        int fromIndex;
        for (int toIndex = actualIndex; toIndex != lastOffset; toIndex = fromIndex) {
            // fromIndex is on the right of toIndex, cycling over boundary
            if (toIndex == capacity - 1) {
                fromIndex = 0;
            } else {
                fromIndex = toIndex + 1;
            }

            array[toIndex] = array[fromIndex];
        }

        array[lastOffset] = null;

        // move last offset to the left, cycling over boundary
//        if (lastOffset == 0) {
//            lastOffset = capacity - 1;
//        } else {
//            lastOffset--;
//        }
        // todo save lastOffset
    }

    private void shiftToLeftFrom(int actualIndex) {
        // move offset to the left, cycling over boundary
        if (offset == 0) {
            offset = capacity - 1;
        } else {
            offset--;
        }

        int fromIndex;
        for (int toIndex = offset; toIndex != actualIndex; toIndex = fromIndex) {
            // fromIndex is on the right of toIndex, cycling over boundary
            if (toIndex == capacity - 1) {
                fromIndex = 0;
            } else {
                fromIndex = toIndex + 1;
            }

            array[toIndex] = array[fromIndex];
        }

        array[actualIndex] = null;
    }

    private void shiftToRightFrom(int actualIndex) {
        int lastOffset = getLastOffset();

        int fromIndex;
        for (int toIndex = lastOffset; toIndex != actualIndex; toIndex = fromIndex) {
            // fromIndex is on the left of toIndex, cycling over boundary
            if (toIndex == 0) {
                fromIndex = capacity - 1;
            } else {
                fromIndex = toIndex - 1;
            }

            array[toIndex] = array[fromIndex];
        }

        array[actualIndex] = null;
    }

    private int getLastOffset() {
        int lastOffset = offset + size - 1;

        if (lastOffset >= capacity) {
            lastOffset = lastOffset - capacity;
        }
        return lastOffset;
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
