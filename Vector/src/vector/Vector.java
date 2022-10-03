// Name: Agrim Sharma
// Computing ID: hws7ug@virginia.edu
// Homework Name: Homework 4: Vectors and Dynamic Arrays

package vector;

import java.util.Arrays;

public class Vector<T> implements List<T> {

	private T[] itemArray;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;

	public Vector() {
		this(INITIAL_CAPACITY);  // calls the other constructor that takes an int parameter
	}

	@SuppressWarnings("unchecked")
	public Vector(int capacity) {
		this.itemArray = (T[]) new Object[capacity];
		this.size = 0;
	}

	public int capacity() {
		return this.itemArray.length;
	}

	/**
	 * When the underlying array fills up, we need to somehow resize it to accommodate the
	 * Vectors's elements.
	 * Ignores the request if the requested new capacity is too small to fit the elements
	 * already in the Vector
	 */
	public void resize(int newCapacity) {
		T[] newArr = (T[]) new Object[itemArray.length];
		if (newCapacity > size) {
			newArr = (T[]) new Object[newCapacity];
			for (int i = 0; i < itemArray.length; i++) {
				newArr[i] = itemArray[i];
			}
			this.itemArray = newArr;
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
//		for (int i = 0; i < size; i++) {
//			itemArray[i] = null;
//		}
		this.size = 0;
	}

	@Override
	public void insertAtTail(T item) {
		
		//check if there is capacity in the array
	
		insertAt(size, item);	

	}

	@Override
	public void insertAtHead(T item) {
		insertAt(0, item);
	}

	@Override
	public void insertAt(int index, T item) {
		if (size == itemArray.length) { //capacity
			resize(this.capacity() * 2); // resize using capacity
		}
		for (int i = size; i >= index+1; i--) {
			itemArray[i] = itemArray[i - 1];
		}
	    itemArray[index] = item;
	    size++;
	}

	@Override
	public T removeAtTail() {
//		T index = itemArray[size - 1];
//		T[] newArr = (T[]) new Object[size - 1];
//		for (int i = 0; i < newArr.length; i++) {
//			newArr[i] = itemArray[i];
//		}
//		itemArray = newArr;
//		size--;
		
		if (this.size == 0) {
			return null;
		}
		
		this.size--;
		
		return this.itemArray[size];
	
	}

	@Override
	public T removeAtHead() {
		T index = itemArray[0];
		for (int i = 0; i < itemArray.length - 1; i++) {
			itemArray[i] = itemArray[i + 1];
		}
//		T[] newArr = (T[]) new Object[size - 1];
//		for (int i = 0; i < newArr.length; i++) {
//			newArr[i] = itemArray[i];
//		}
	//	newArr = itemArray;
		size--;
		return index;
	}

	@Override
	public int find(T item) {
		for (int i = 0; i < size; i++) {
			if (itemArray[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public T get(int index) {
		return itemArray[index];
	}

	/*
	 * This toString() method allow you to print a nicely formatted version of your Vector. E.g.
	 *     System.out.println( myVector );
	 * It uses utility methods in the Java Arrays library.
	 */
	@Override
	public String toString() {
//		return Arrays.toString(this.itemArray); // prints entire array from 0 to capacity-1
		return Arrays.toString(Arrays.copyOfRange(this.itemArray, 0, this.size)); // prints from 0 to size-1
	}

}
