/**
 * This class implements the SimpleCollection and behaves like
 * other collections in the Java framework.
 * Various methods for the differnt functions of the collection
 * were implemented
 * @author Anirudh Gubba
 * @version 1.0
 */
import java.util.NoSuchElementException;

public class ArrayWrapper<T> implements SimpleCollection {

    private Object[] arr;
    /**
     * The constructor for the class instantiates the field array
     * and also casts each element in the array to (T)
     * The default length is 5.
     */
    public ArrayWrapper() {
        arr = new Object[5];
        for (int a = 0; a < arr.length; a++) {
            arr[a] = (T) arr[a];
        }
    }
    /**
     * Adds an element into the collection.
     * If the new element exceeds the size of the backing array,
     * instead resize the array, the size is doubled and old elements
     * are copied over.
     *
     * @param elem The element being added.
     */
    public void add(Object elem) {
        if (arr[arr.length - 1] != null) {
            Object[] arr1 = new Object[arr.length * 2];
            for (int j = 0; j < arr.length; j++) {
                arr1[j] = arr[j];
            }
            arr1[arr.length] = (T) elem; //actually add the new element
            arr = arr1;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    arr[i] = (T) elem;
                    break;
                }
            }
        }
    }
    /**
     * Adds all elements in elems to the collection.
     *
     * @param elems Array of elements to be added.
     */
    public void addAll(Object[] elems) {
        for (int i = 0; i < elems.length; i++) {
            add((T) elems[i]);
        }
    }
    /**
     * Remove elem from the collection. Removing an element
     * should shift all the elements behind it forward, ensuring
     * that the backing array is contiguous.
     *
     * @param elem Element to be removed.
     * @return true if the element was removed,
     *         false if it was not in the collection.
     */
    public boolean remove(Object elem) {
        for (int counter = 0; counter < arr.length; counter++) {
            if ((T) arr[counter] != null
                && ((T) arr[counter]).equals((T) elem)) {
                for (int c = counter; c < arr.length - 1; c++) {
                    arr[c] = arr[c + 1];
                }
                arr[arr.length - 1] = null;
                return true;
            }
        }
        return false;
    }
    /**
     * Removes each element in elems from the collection.
     *
     * @param elems Array of elements to be removed.
     * @return true if any elements were removed,
     *         false if no elements were removed.
     */
    public boolean removeAll(Object[] elems) {
        boolean check = false;
        for (int i = 0; i < elems.length; i++) {
            if (contains(elems[i])) {
                check = true;
            }
            remove(elems[i]);
        }
        return check;
    }
    /**
     * Checks to see if the collection contains a given element.
     * The array is traversed and checked for null elements as well.
     *
     * @param elem The element we are checking for.
     * @return true if the collection contains elem, false otherwise.
     */
    public boolean contains(Object elem) {
        for (int c = 0; c < arr.length; c++) {
            if (arr[c] != null && arr[c].equals((T) elem)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Gets an element from the collection, using its 0-based index.
     * If the index is within our backing array but more than our last
     * element, rather than returning null, this should throw
     * a java.util.NoSuchElementException.
     *
     * @param index The index of the element we want.
     * @return The element at the specified index.
     */
    public T get(int index) {
        if (arr[index] != null && index < arr.length) {
            return ((T) arr[index]);
        } else {
            throw new NoSuchElementException();
        }
    }
    /**
     * Returns the current number of elements in the collection.
     *
     * @return The size of the collection.
     */
    public int size() {
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                size++;
            }
        }
        return size;
    }
    /**
     * Returns the current capacity of the collection - namely, the
     * size of its backing array.
     *
     * @return The total capacity of the collection.
     */
    public int capacity() {
        return arr.length;
    }
    /**
     * Clears the collection, resetting size and starting from a fresh
     * backing array of size 5.
     */
    public void clear() {
        Object[] arr2 = new Object[5];
        arr = arr2;
    }
    /**
     * Tests if the collection is empty, i.e. it contains no elements.
     *
     * @return true if the collection has no elements, false otherwise.
     */
    public boolean isEmpty() {
        if (arr[0] == null) {
            return true;
        }
        return false;
    }
    /**
     * The toString() is overridden from object and displays
     * a the elements of the array as follows:
     * [element1, element2...,elementN]
     * The user can see the actual array instead of a reference
     * It also makes sure that the elements displayed are not null
     *
     * @return [element1, element2, element3, ..., elementN]
     */
    public String toString() {
        String out = "[";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                out += (T) arr[i] + ", ";
            }
        }
        out = out.substring(0, out.length() - 2);
        out += "]";
        return out;
    }
}