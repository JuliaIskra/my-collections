package juliaiskra.my.collections.test;

import juliaiskra.my.collections.MyMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Yuliya on 25.10.2015.
 */
public class MyMapTest {
    @Test
    public void testPutDifferentKeys() {
        MyMap map = new MyMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        Assert.assertEquals("value1", map.get("key1"));
        Assert.assertEquals("value2", map.get("key2"));
    }

    @Test
    public void testPutEqualKeys() {
        MyMap map = new MyMap();
        map.put("key1", "value1");
        Assert.assertEquals("value1", map.get("key1"));

        map.put("key1", "value2");
        Assert.assertEquals("value2", map.get("key1"));
    }

    @Test
    public void testCollisions() {
        MyMap map = new MyMap();

        ConstantHashCodeKey key1 = new ConstantHashCodeKey();
        ConstantHashCodeKey key2 = new ConstantHashCodeKey();

        map.put(key1, "value1");
        map.put(key2, "value2");

        Assert.assertEquals("value1", map.get(key1));
        Assert.assertEquals("value2", map.get(key2));
    }

    // todo test resizing

    class ConstantHashCodeKey {
        @Override
        public int hashCode() {
            return 0;
        }
    }
}
