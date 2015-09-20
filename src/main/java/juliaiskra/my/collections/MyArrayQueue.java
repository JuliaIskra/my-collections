package juliaiskra.my.collections;

/**
 * @author Yuliya Kupryakova
 */
public class MyArrayQueue {
    /*
    capacity
    offset
    size


     * In the start I have an array of specified length.
     * Virtual queue is empty (size = o).
     * Reference to the start of the queue = index 0 of the array.
     *
     * Methods
     * =======
     * push
     * ----
     * - add into the end (into the index = size)
     * - size should be increased by 1
     * - if I have place at the end of the array, I put the new element into the end of it and the reference to the
     * start of the queue doesn't change
     * - if I don't have place at the end of the array but size of the queue < size of the array, I put the new element
     * into the first empty index from the start of the array, and the reference to the start of the queue doesn't change
     * - if I don't have place in the array at all (size of the queue = size of the array), I expand it, put all
     * elements of the virtual queue in the correct order to the new array, starting form the index = 0, add the new
     * element into the end of it, and the reference to the start of the queue = index 0 of the array
     *
     * pop
     * ---
     * - remove from the end (from the index = size - 1)
     * - size should be decreased by 1
     * -
     *
     * shift
     * -----
     * - add to the start (into the index = 0)
     * - size should be increased by 1
     *
     * unshift
     * -------
     * - remove from the start (from the index = 0)
     * - size should be decreased by 1
     *
     */
}
