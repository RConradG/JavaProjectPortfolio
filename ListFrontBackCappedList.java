import java.util.ArrayList;
import java.util.List;

public class ListFrontBackCappedList<T> implements FrontBackCappedList<T> {
    private final int capacity;
    private final List<T> list;

    public ListFrontBackCappedList(int capacity) {
        list = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    /**
     * Adds a new entry to the beginning of the list if the list is not full.
     * If the entry is added, entries currently in the list are shifted down and
     * the list size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     * @return true if the object was added, false if the list was full
     *          and thus the object was not added
     */
    @Override
    public boolean addFront(T newEntry) {
        if (!isFull()) {
            list.add(0, newEntry); 
            return true;
        }

        return false;
    }

    /**
     * Adds a new entry to the end of the list if the list is not full.
     * Entries currently in the list are unaffected.
     * If the entry is added, the list size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     * @return true if the object was added, false if the list was full
     *          and thus the object was not added
     */
    @Override
    public boolean addBack(T newEntry) {
        if (!isFull()) {
            list.add(list.size(), newEntry); 
            return true;
        }

        return false;
    }

    /**
     * Removes an entry from the beginning of the list.
     * Entries currently in the list are shifted up.
     * If an entry is removed, the list size is decreased by 1.
     *
     * @return A reference to the removed entry or null if the list is empty.
     */
    @Override
    public T removeFront() {
        if (!isEmpty()) {
            return list.remove(0); 
        }

        return null;
    }

    /**
     * Removes an entry from the end of the list.
     * Entries currently in the list are unaffected.
     * If an entry is removed, the list size is decreased by 1.
     *
     * @return A reference to the removed entry or null if the list is empty.
     */
    @Override
    public T removeBack() {
        if (!isEmpty()) {
            return list.remove(list.size() - 1); 
        }

        return null;
    }

    /**
     * Removes all entries from this list.
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Retrieves the entry at a given position in this list.
     *
     * @param givenPosition An integer that indicates the position of the desired entry.
     * @return A reference to the indicated entry or null if the index is out of bounds.
     */
    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition < 0 || givenPosition >= list.size()) {
            return null;
        }

        return list.get(givenPosition);
    }

    /**
     * Determines the position in the list of a given entry.
     * If the entry appears more than once, the first index is returned.
     *
     * @param anEntry the object to search for in the list.
     * @return the first position the entry that was found or -1 if the object is not found.
     */
    @Override
    public int indexOf(T anEntry) {
        return list.indexOf(anEntry);
    }

    /**
     * Determines the position in the list of a given entry.
     * If the entry appears more than once, the last index is returned.
     *
     * @param anEntry the object to search for in the list.
     * @return the last position the entry that was found or -1 if the object is not found.
     */
    @Override
    public int lastIndexOf(T anEntry) {
        return list.lastIndexOf(anEntry);
    }

    /**
     * Determines whether an entry is in the list.
     *
     * @param anEntry the object to search for in the list.
     * @return true if the list contains the entry, false otherwise
     */
    @Override
    public boolean contains(T anEntry) {
        return list.contains(anEntry);
    }

    /**
     * Gets the length of this list.
     *
     * @return The integer number of entries currently in the list.
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Checks whether this list is empty.
     *
     * @return True if the list is empty, or false if the list contains one or more elements.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Checks whether this list is full.
     *
     * @return True if the list is full, or false otherwise.
     */
    @Override
    public boolean isFull() {
        return list.size() == capacity;
    }

    @Override
    public String toString() {
        String prefix = "size=" + list.size() + "; capacity=" + capacity + ";\t";
        if (isEmpty()) {
            return prefix + "[]";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[").append(list.get(0)); 
        for (int i = 1; i < list.size(); i++) {
            builder.append(", ").append(list.get(i));
        }
        builder.append("]");

        return prefix + builder;
    }
}
