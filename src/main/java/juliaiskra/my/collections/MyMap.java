package juliaiskra.my.collections;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by Yuliya on 25.10.2015.
 */
public class MyMap implements Map {
    private int capacity = 10;
    private Object[] array = (Object[]) Array.newInstance(Object.class, capacity);

    @Override
    public int size() {
        // todo
        return 0;
    }

    @Override
    public Object get(Object key) {
        int index = calculateHash(key.hashCode());
        return array[index];
    }

    @Override
    public Object put(Object key, Object value) {
        int index = calculateHash(key.hashCode());
        Object oldValue = get(key);
        array[index] = value;
        return oldValue;
    }

    private int calculateHash(int hashCode) {
        return Math.abs(hashCode) % array.length;
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

    private class Entry implements Map.Entry {
        Object key;
        Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            throw new UnsupportedOperationException();
        }
    }
}
