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
        Entry entry = getEntry(key, false);
        if (entry == null) {
            return null;
        } else {
            return entry.getValue();
        }
    }

    @Override
    public Object put(Object key, Object value) {
        Entry entry = getEntry(key, true);
        // todo if (entry == null) then resize
        Object oldValue = entry.getValue();
        entry.setValue(value);
        return oldValue;
    }

    private Entry getEntry(Object key, boolean shouldCreateEntry) {
        int index = Math.abs(key.hashCode()) % array.length;

        for (int counter = 0; counter < array.length; counter++) {
            Entry entry = array[index];
            if (entry == null) {
                if (shouldCreateEntry) {
                    Entry newEntry = new Entry(key, null);
                    array[index] = newEntry;
                    return newEntry;
                }
                return null;
            }

            if (entry.getKey().equals(key)) {
                return entry;
            }

            index = (index + 1) % array.length;
        }

        return null;
    }

    @Override
    public Object remove(Object key) {
        // todo
        return null;
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

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
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
