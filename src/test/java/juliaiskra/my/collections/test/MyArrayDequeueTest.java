package juliaiskra.my.collections.test;

import juliaiskra.my.collections.MyArrayDequeue;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Julia Nemtseva
 */
public class MyArrayDequeueTest {
    @Test
    public void testAdditionInTheEnd() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        arrayList.add(0, "a");
        arrayList.add(1, "b");
        arrayList.add(2, "c");

        Assert.assertEquals("a", arrayList.get(0));
        Assert.assertEquals("b", arrayList.get(1));
        Assert.assertEquals("c", arrayList.get(2));
    }

    @Test
    public void testAdditionInTheMiddle() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        arrayList.add(0, "a");
        arrayList.add(1, "b");
        arrayList.add(2, "c");
        arrayList.add(1, "e");

        Assert.assertEquals("a", arrayList.get(0));
        Assert.assertEquals("e", arrayList.get(1));
        Assert.assertEquals("b", arrayList.get(2));
        Assert.assertEquals("c", arrayList.get(3));
    }

    @Test
    public void testSetting() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        arrayList.add(0, "a");
        arrayList.add(1, "b");
        arrayList.add(2, "c");
        arrayList.set(1, "e");

        Assert.assertEquals("a", arrayList.get(0));
        Assert.assertEquals("e", arrayList.get(1));
        Assert.assertEquals("c", arrayList.get(2));
    }

    @Test
    public void testRemovingFromTheEnd() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        arrayList.add(0, "a");
        arrayList.add(1, "b");
        arrayList.add(2, "c");

        Assert.assertEquals("c", arrayList.get(2));
        Assert.assertEquals(3, arrayList.size());

        arrayList.remove(2);

        Assert.assertEquals(2, arrayList.size());
    }

    @Test
    public void testRemovingFromTheMiddle() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        arrayList.add(0, "a");
        arrayList.add(1, "b");
        arrayList.add(2, "c");

        Assert.assertEquals("a", arrayList.get(0));
        Assert.assertEquals("b", arrayList.get(1));
        Assert.assertEquals("c", arrayList.get(2));
        Assert.assertEquals(3, arrayList.size());

        arrayList.remove(1);

        Assert.assertEquals("a", arrayList.get(0));
        Assert.assertEquals("c", arrayList.get(1));
        Assert.assertEquals(2, arrayList.size());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testOutOfBoundsGettingInEmptyArrayList() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        arrayList.get(0);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testNegativeOutOfBoundGetting() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        arrayList.add(0, "a");
        arrayList.add(1, "b");
        arrayList.get(-1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testOutOfBoundGetting() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        arrayList.add(0, "a");
        arrayList.add(1, "b");
        Assert.assertEquals("b", arrayList.get(1));
        arrayList.get(2);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testOutOfBoundSetting() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        arrayList.set(0, "b");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testNegativeOutOfBoundSetting() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        arrayList.set(-1, "b");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testOutOfBoundAddition() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        arrayList.add(0, "b");
        arrayList.add(2, "b");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testNegativeOutOfBoundAddition() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        arrayList.add(-1, "b");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testOutOfBoundRemoving() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        arrayList.add(0, "b");
        arrayList.remove(1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testNegativeOutOfBoundRemoving() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        arrayList.remove(-1);
    }

    @Test
    public void testSize() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        Assert.assertEquals(0, arrayList.size());

        arrayList.add(0, "a");
        Assert.assertEquals(1, arrayList.size());

        arrayList.remove(0);
        Assert.assertEquals(0, arrayList.size());
    }

    @Test
    public void testResize() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        Assert.assertEquals(0, arrayList.size());

        arrayList.add(0, "0");
        Assert.assertEquals(1, arrayList.size());

        for (int i = 1; i < 8; i++) {
            arrayList.add(i, String.valueOf(i));
        }

        Assert.assertEquals(8, arrayList.size());

        arrayList.add(8, "8");
        Assert.assertEquals(9, arrayList.size());
    }

    @Test
    public void testResizeBackwards() {
        MyArrayDequeue<String> arrayList = new MyArrayDequeue<>(String.class);
        Assert.assertEquals(0, arrayList.size());

        arrayList.add(0, "0");
        Assert.assertEquals(1, arrayList.size());

        for (int i = 1; i < 8; i++) {
            arrayList.add(0, String.valueOf(i));
        }

        Assert.assertEquals(8, arrayList.size());

        arrayList.add(0, "8");
        Assert.assertEquals(9, arrayList.size());
    }
}
