package juliaiskra.my.collections;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by Yuliya on 25.10.2015.
 */
public class MyMap implements Map {
    private int capacity = 10;
    private Entry[] array = (Entry[]) Array.newInstance(Entry.class, capacity);

    @Override
    public int size() {
        // todo
        return 0;
    }

    @Override
    public Object get(Object key) {
        int index = findIndex(key);
        if (index < 0) {
            return null;
        }
        Entry entry = array[index];
        if (entry == null) {
            return null;
        } else {
            return entry.getValue();
        }
    }

    @Override
    public Object put(Object key, Object value) {
        int index = findIndex(key);
        Entry entry = array[index];
        if (entry == null) {
            entry = new Entry(key);
            array[index] = entry;
        }
        // todo if (index < 0) then resize
        Object oldValue = entry.getValue();
        entry.setValue(value);
        return oldValue;
    }

    private int findIndex(Object key) {
        int index = Math.abs(key.hashCode()) % array.length;

        for (int counter = 0; counter < array.length; counter++) {
            Entry entry = array[index];
            if (entry == null || entry.getKey().equals(key)) {
                return index;
            }

            index = (index + 1) % array.length;
        }

        return -1;
    }

    @Override
    public Object remove(Object key) {
        int index = findIndex(key);
        if (index < 0) {
            return null;
        }
        Entry entry = array[index];
        if (entry == null) {
            return null;
        } else {
            array[index] = null;
            return entry.getValue();
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection values() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Map.Entry> entrySet() {
        throw new UnsupportedOperationException();
    }

    private class Entry {
        Object key;
        Object value;

        public Entry(Object key) {
            this.key = key;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
