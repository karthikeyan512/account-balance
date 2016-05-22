package com.karthik;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomList<E> implements List<E> {
	
	private int size = 0;
	private Object[] elements;
	private final static int DEFAULT_SIZE = 10;

	public CustomList() {
		elements = new Object[DEFAULT_SIZE];
	}
	@Override
	public boolean add(E e) {
		if(size == elements.length) {
			checkCapacity(size);
		}
		elements[size++] = e;
		return true;
	}
	
	private void checkCapacity(int size) {
		int newSize = size * 2;
		elements = Arrays.copyOf(elements, newSize);
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		rangeCheckForAdd(index);
		checkCapacity(size + 1);
		
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		for(int i =0; i< size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		rangeCheck(index);
		return (E) elements[index];
	}
	
	private void rangeCheck(int index) {
		if(index < 0 || index >=size) {
			throw new IndexOutOfBoundsException("Index: " + index +" Actual Size: " + size);
		}
	}
	
	private void rangeCheckForAdd(int index) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index +" Actual Size: " + size);
		}
	}
	
	@Override
	public int indexOf(Object o) {
		for(int i = 0; i < size; i++) {
			if((o == null && elements[i] == null) || (o != null && o.equals(elements[i]))) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		for(int i = 0; i < size; i++) {
			if((o == null || elements[i] == null) || (o != null && o.equals(elements[i]))) {
				int length = size - i - 1;
				if(length > 0) {
					System.arraycopy(elements, i + 1, elements, i, length);
				}
				elements[--size] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		E value = (E) elements[index];
		int length = size - index - 1;
		if(length > 0) {
			System.arraycopy(elements, index + 1, elements, index, length);
		}
		elements[--size] = null;
		return value;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
