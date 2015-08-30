package juliaiskra.my.arraylist;

import java.lang.reflect.Array;
import java.util.AbstractList;

/**
 * @author Yuliya Kupryakova
 */
public class MyArrayList<E> extends AbstractList<E> {
    private final E[] array;
    private int size;

    public MyArrayList(Class<E> aClass) {
        // todo expand array
        //noinspection unchecked
        array = (E[]) Array.newInstance(aClass, 100);
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
