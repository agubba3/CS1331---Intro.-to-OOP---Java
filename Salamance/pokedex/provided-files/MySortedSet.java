import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Collections;

/**
 * An implementation of the FunctionalSortedSet interface that uses an ArrayList
 * as the backing data structure.
 *
 * @author Joe Rossi
 * @version 1.0
 * @param <E> A comparable object that is contained within this sorted set.
 */
public class MySortedSet<E extends Comparable<? super E>>
    implements FunctionalSortedSet<E> {

    private ArrayList<E> list;
    private Comparator<E> c;

    /**
     * Creates a MySortedSet using the Comparable's compareTo as Comparator
     */
    public MySortedSet() {
        this(null);
    }

    /**
     * Creates a MySortedSet using a specific Comparator
     *
     * @param c a Comparator that either "has" or "is" one int valued method
     */
    public MySortedSet(Comparator<E> c) {
        this.c = c;
        list = new ArrayList<E>();
    }

    /**
     * This method returns the arraylist (backing array) which was made
     *
     * @return this method outputs an Arraylist with the generic type E
     */
    public ArrayList<E> getList() {
        return list;
    }

    //-----------FunctionalSortedSet METHODS - ONLY MODIFY filter!!------------

    /**
     * This method filters a set using a predicate or boolean expression.
     *
     * @param p a Predicate or boolean expression is passed into the method
     * @return a MySortedSet object is returned after being filtered
     */
    @Override
    public MySortedSet<E> filter(Predicate<E> p) {
        return list.stream().filter(p).collect(Collectors.toCollection(()
        -> new MySortedSet(c)));
    }
    /**
     * This method sorts a set using the comparator which was passed in
     *
     * @param comparator A comparator which is passed into the method
     * @return a MySortedSet object after being sorted using the
     * comparator
     */
    @Override
    public MySortedSet<E> sort(Comparator<E> comparator) {
        MySortedSet<E> ret = new MySortedSet<E>(comparator);
        ret.addAll(this.list);
        return ret;
    }

    //------SortedSet METHODS - ONLY MODIFY subSet and tailSet!!---------------

    /**
     * This method returns the comparator of the class
     * or the default one.
     *
     * @return A comparator of a type which is a super class of E or E
     */
    @Override
    public Comparator<? super E> comparator() {
        return c;
    }
    /**
     * This method returns the first value in the list
     *
     * @return a generic type which is the first element
     */
    @Override
    public E first() {
        return list.get(0);
    }

    /**
     * Returns a MySortedSet object with all elements [first, toElement) using a
     * functional programming expression.
     *
     * @param toElement The element the returned set should stop before.
     * @return A sorted set containing elements strictly less than toElement.
     */
    @Override
    public MySortedSet<E> headSet(E toElement) {
        return list.subList(0, list.indexOf(toElement)).stream().collect(
            Collectors.toCollection(() -> new MySortedSet<>(c)));
    }

    /**
     * Return a MySortedSet object with all elements [fromElement, toElement)
     * using a functional programming expression.
     *
     * @param fromElement The first element the returned set should contain.
     * @param toElement The element the returned set should stop before.
     * @return A sorted set containing elements fromElement to toElement.
     */
    @Override
    public MySortedSet<E> subSet(E fromElement, E toElement) {
        return list.subList(list.indexOf(fromElement),
            list.indexOf(toElement)).stream().collect(
                Collectors.toCollection(() -> new MySortedSet<>(c)));
    }

    /**
     * Return a MySortedSet object with all elements [fromElement, last]
     * using a functional programming expression.
     *
     * @param fromElement The first element the returned set should contain.
     * @return A sorted set containing elements fromElement and onwards.
     */
    @Override
    public MySortedSet<E> tailSet(E fromElement) {
        return list.subList(list.indexOf(fromElement),
            list.size() - 1).stream().collect(
                Collectors.toCollection(() -> new MySortedSet<>(c)));
    }
    /**
     * This method returns the last value in the list
     *
     * @return a generic type which is the last element
     */
    @Override
    public E last() {
        return list.get(list.size() - 1);
    }

    //-----------Set METHODS - TODO---------------------------------------------

    /**
     * This method adds an element into the backing arraylist
     * while making sure that it does not already contain it and is
     * of type Pokemon.
     * It also sorts the set after the element is added
     *
     * @param e the element which is to be possible added
     * @return A boolean which describes if the element was added or not.
     */
    @Override
    public boolean add(E e) {
        boolean ret = false;
        if (!list.contains(e) && e instanceof Pokemon) {
            ret = true;
            list.add(e);
        }
        Collections.sort(list, c);
        return ret;
    }
    /**
     * This method removes an object which is passed in from the
     * backing arraylist using the default implementation of the
     * remove method in ArrayList.
     *
     * @param e the Object to be removed
     * @return A boolean which describes if the element was removed or not.
     */
    @Override
    public boolean remove(Object e) {
        return list.remove(e);
    }
    /**
     * This method details if the object passed in is contained in the
     * backing arraylist or not.
     *
     * @param e the Object to be checked if contained
     * @return A boolean which describes if the
     * element is in the arraylist or not.
     */
    @Override
    public boolean contains(Object e) {
        return list.contains(e);
    }
    /**
     * This method details if the objects passed are all contained
     * in the arraylist or not.
     *
     * @param col the collection of any type which is to be checked
     * if contained in the backing arraylist
     * @return A boolean which describes if the entire collection
     * is in the backing arraylist.
     */
    @Override
    public boolean containsAll(Collection<?> col) {
        return list.containsAll(col);
    }
    /**
     * This method checks if the backing array is empty
     * or not.
     *
     * @return A boolean which describes if the backing arraylist is empty
     * or not.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    /**
     * This method which outputs the size of the backing
     * arraylist.
     *
     * @return An int which is the size or length
     * of the backing arraylist or set.
     */
    @Override
    public int size() {
        return list.size();
    }
    /**
     * This method adds all elements in a collection
     * into the backing arraylist
     * while making sure that it does not already contain any of the elements.
     *
     * @param col the collection which is to be added
     * to the backing arralist.
     * @return A boolean which describes if any elements in the
     * collection were added.
     */
    @Override
    public boolean addAll(Collection<? extends E> col) {
        boolean answer = true;
        for (E i : col) {
            if (list.contains(i)) {
                answer = false;
            }
            if (answer) {
                add(i);
            }
        }
        return answer;
    }
    /**
     * This method removes all elements in a collection
     * from the backing arraylist.
     *
     * @param col the collection which is to be removed
     * to the backing arralist.
     * @return A boolean which describes if any elements in the
     * collection were removed.
     */
    @Override
    public boolean removeAll(Collection<?> col) {
        return list.removeAll(col);
    }
    /**
     * This method retains only the elements in this
     * list that are contained in the specified collection.
     *
     * @param col the collection which is to be retained
     * @return A boolean which describes if any elements in the
     * collection were retained
     */
    @Override
    public boolean retainAll(Collection<?> col) {
        return list.retainAll(col);
    }

    /**
     * This method returns an iterator over the elements i
     * n this list in proper sequence.
     *
     * @return An iterator which iterates over
     * the given backing arraylist.
     */
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    /**
     * This removes all of the elements from this list.
     */
    @Override
    public void clear() {
        list.clear();
    }
    /**
     * This method returns the array of objects
     * by transforming the list to an array
     *
     * @return An object array after
     * transforming the list to an array
     */
    @Override
    public Object[] toArray() {
        return list.toArray();
    }
    /**
     * This returns an array containing all of the elements
     * in this list in proper sequence (from first to last element)
     * the runtime type of the returned array is that
     * of the specified array.
     *
     * @return An array of specified type
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }
    /**
     * This method overrides the default toString method
     * in Object to output a String representation for
     * each Pokemon in the list.
     *
     * @return a String representation of each
     * Pokemon in the list.
     */
    @Override
    public String toString() {
        //return list.toString();
        String a = "";
        for (int i = 0; i < list.size(); i++) {
            a += "\n" + list.get(i).toString();
        }
        return a;
    }
}
