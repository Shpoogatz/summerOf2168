package summerOf2168;

// https://www.youtube.com/watch?v=adhNWOGqKy4&ab_channel=ProfessorRosen (39:00)
// me following along to this video where Rosen shows how the ArrayList function works and we create it on our own

public class MyArrayList<E> {
	
	private int size;
	private int capacity;
	public static final int INITIAL_CAPACITY = 10;
	private E[] data;
	
	// here we are creating an empty array list ( constructor ) 
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.size = 0;
		this.data = (E[]) new Object[INITIAL_CAPACITY]; // we can not do 'new E[10]' so we do this which is creating a new array of objects and then casting our generic to it
		this.capacity = INITIAL_CAPACITY;
	}
	
	// note that we use size() instead of getSize() just because.
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	// give me the item at int index
	public E get(int index) {
		// have to check that the index we are searching for is in the bounds of our current ArrayList
		if (index < 0 || index >= this.size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		E item = data[index];
		return item;
	}
	
	// replaces thing at index with element. set element at index to elementInput
	public E set(int index, E element) {
		
		if (index < 0 || index >= this.size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		E prevItem = data[index];
		// here we take the memory location of the thing on the right and store it in the thing on the right 
		data[index] = element;
		
		return prevItem;
	}
	
	public boolean add(E element) {
		this.add(this.size, element);
		return true;
	}
	
	
	public void add(int index, E element) {
		if (index < 0 || index > this.size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		if (size == capacity) { // if size is too small to hold the new item reallocate()
			reallocate();
		}
		
		for (int i = size - 1; i >= index; i--)
			data[i+1] = data[i];
			
		data[index] = element;
		
		size++;
	}
	
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		E oldItem = data[index];
		for (int i = index; i < size; i++) { 
			data[i] = data[i+1];
		}
		
		size--;
		return oldItem;
	}
	
	public int indexOf(E element) {
		for (int i = 0; i < size; i++) {
			E storedItem = data[i];
			if (storedItem.equals(element)) {// we know that it is two objects so we can use .equals()	}
				return i;
			}
		}
		return -1;
	}
	
	public boolean contains(E element) {
		int indexOfItem = this.indexOf(element);
		return indexOfItem != -1;
	}
	
	public String toString() {
		String output = "[";
		for (int i = 0; i < this.size - 1; i++) {
			output = output + this.data[i] + ", ";
		}
		// the previous loop stops at the second to last element, then we add the last element here manually
		return output + this.data[size - 1] + "]";
	}
	
	// we take everything from the first array and move it to the second array that we have made more space in
	// second array has double the capacity
	@SuppressWarnings("unchecked")
	private void reallocate() {
		E[] oldData = data;
		this.capacity *= 2; 
		data = (E[]) new Object[capacity];
		
		for (int i = 0; i < size; i++) {
			data[i] = oldData[i];
		}
	}
	
	
	public static void main(String[] args) {
		
		MyArrayList<String> list = new MyArrayList<String>();
		
		// before adding our reallocate() method this would fail
		for (int i = 0; i < 1000; i++) {
			list.add(0, i + ""); // turn into string just by concatenating with a string
			System.out.println(list);
		}
		
	}
}
