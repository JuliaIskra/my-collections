package juliaiskra.my.arraylist.test;

import juliaiskra.my.arraylist.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yuliya Kupryakova
 */
public class MyArrayListTest {
    @Test
    public void testAdditionInTheEnd() {
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
        arrayList.add(0, "a");
        arrayList.add(1, "b");
        arrayList.add(2, "c");

        Assert.assertEquals("a", arrayList.get(0));
        Assert.assertEquals("b", arrayList.get(1));
        Assert.assertEquals("c", arrayList.get(2));
    }

    @Test
    public void testAdditionInTheMiddle() {
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
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
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
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
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
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
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
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
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
        arrayList.get(0);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testNegativeOutOfBoundGetting() {
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
        arrayList.add(0, "a");
        arrayList.add(1, "b");
        arrayList.get(-1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testOutOfBoundGetting() {
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
        arrayList.add(0, "a");
        arrayList.add(1, "b");
        Assert.assertEquals("b", arrayList.get(1));
        arrayList.get(2);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testOutOfBoundSetting() {
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
        arrayList.set(0, "b");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testNegativeOutOfBoundSetting() {
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
        arrayList.set(-1, "b");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testOutOfBoundAddition() {
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
        arrayList.add(0, "b");
        arrayList.add(2, "b");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testNegativeOutOfBoundAddition() {
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
        arrayList.add(-1, "b");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testOutOfBoundRemoving() {
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
        arrayList.add(0, "b");
        arrayList.remove(1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testNegativeOutOfBoundRemoving() {
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
        arrayList.remove(-1);
    }

    @Test
    public void testSize() {
        MyArrayList<String> arrayList = new MyArrayList<String>(String.class);
        Assert.assertEquals(0, arrayList.size());

        arrayList.add(0, "a");
        Assert.assertEquals(1, arrayList.size());

        arrayList.remove(0);
        Assert.assertEquals(0, arrayList.size());
    }
}
