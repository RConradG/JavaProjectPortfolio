
public class ArrayFrontBackCappedList<T> implements FrontBackCappedList<T> {
	
	private T[] list;
	private int numberOfElements;
	
	public ArrayFrontBackCappedList(int capacity) {
		this.list = (T[]) new Object[capacity];
		numberOfElements = 0;
		// code below is used to test Part One. After testing, comment out or delete
//		  Object[] objs = {2, 4, 6, 8, 9, null, null, null, null, null};
//	        this.list = (T[]) objs;
//	        this.numberOfElements = 5;
	}
	
	public boolean isEmpty() {
		return numberOfElements == 0;
	}
	
	public boolean isFull() {
		return numberOfElements == list.length;
	}
	
	public int size() {
		return numberOfElements;
	}
	
	public T getEntry(int index) {
		if((index >= 0) && (index <= (list.length - 1)) ) {
			return list[index];
		}
		return null;
	}
	
	public void clear() {
		for (int i = 0; i < size(); i++) {
			list[i] = null;
		}
		numberOfElements = 0;
	}

	@Override
	public String toString() {
		String s = "size=" + numberOfElements + "; capacity=" + list.length 
				+ ";\t";
		
		String t = "[";
		for (int i = 0; i < numberOfElements; i++) {
			t += list[i] + ", ";
		}
		if (!isEmpty()) {
			t = t.substring(0, t.length() - 2);
		}
		t += "]";
		
		return s + t;
	}

	public boolean contains(T element) {
		if(!isEmpty()) {
			for (int i=0; i<numberOfElements; i++) {
				if(list[i].equals(element)) {
					return true; 
				}
			}
			return false; 
		}
		return false;
	}

	public boolean addFront(T newElement) { 
		if(!isFull()) {
			for(int i=numberOfElements; i>0; i--) {
				list[i] = list[i-1];
			}
			list[0] = newElement;
			numberOfElements++;
			return true;
		}
		return false;
	}

	public boolean addBack(T newElement) {
		if(!isFull()) {
			list[numberOfElements] = newElement;
			numberOfElements++;
			return true;
		}
		return false;
	}

	public T removeFront() {
		if(!isEmpty()) {
			T removedElement = list[0];
			for(int i=0; i<numberOfElements-1; i++) {
				list[i] = list[i+1];
			}
			list[numberOfElements-1] = null;
			numberOfElements--;
			return removedElement;
		}
		return null;
	}

	public T removeBack() {
		if(!isEmpty()) {
			T removedElement = list[numberOfElements-1];
			list[numberOfElements-1]=null;
			numberOfElements--;
			return removedElement; 
		}
		return null;
	}

	public int indexOf(T element) {
		for(int i=0; i<numberOfElements; i++) {
			if(list[i].equals(element)) {
				return i;
			}
		}
		return -1; 
	}

	public int lastIndexOf(T element) {
		for (int i=numberOfElements-1; i>=0; i--) {
			if(list[i].equals(element)) {
				return i; 
			}
		}
		return -1;
	}
}
