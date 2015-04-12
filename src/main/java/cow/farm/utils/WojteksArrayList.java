package cow.farm.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class WojteksArrayList<T> implements List<Object> {
	static final int INITIAL_SIZE = 10;

	private Object[] array;
	private int size;
	
	public WojteksArrayList() {
		array = new Object[INITIAL_SIZE];
		size = 0;
	}

	public WojteksArrayList(int dimension) {
		array = new Object[dimension];
		size = 0;
	}

	public boolean add(Object arg1) {
		makePlace(size + 1);
		array[size] = arg1;
		size++;
		return true;
	}

	public void add(int arg0, Object arg1) {
		if (arg0 <= size) {
			size++;
			makePlace(size);

			for (int i = size - 1; i >= arg0; i--) {
				array[i] = array[i - 1];

			}
			array[arg0] = arg1;

		} else {
			makePlace(arg0 + 1);
			size = arg0 + 1;
			array[arg0] = arg1;
		}
	}

	public boolean addAll(Collection<?> arg0) {
		Object a[] = arg0.toArray();
		makePlace(size + a.length);
		for (int i = size; i < a.length; i++) {
			array[i] = a[i - size];
		}
		size = size + a.length;
		return true;
	}

	public boolean addAll(int arg0, Collection<?> arg1) {
		Object a[] = arg1.toArray();
		if (arg0 < size) {
			makePlace(a.length + size);
			System.arraycopy(array, arg0, array, arg0 + a.length, a.length);
			System.arraycopy(a, 0, array, arg0, a.length);
			size = a.length + size;
		} else {
			makePlace(arg0 + a.length);
			System.arraycopy(a, 0, array, arg0, a.length);
			size = arg0 + size;
		}

		return true;
	}

	private void makePlace(int expectedArraySizeAfterOperation) {
		if (array.length < expectedArraySizeAfterOperation) {
			Object[] placeholder = new Object[expectedArraySizeAfterOperation
					+ INITIAL_SIZE];
			for (int i = 0; i < array.length; i++) {
				// FIXME use System.arrayCopy();
				placeholder[i] = array[i];
			}
			array = placeholder;
		}
	}

	public void clear() {
		array = new Object[INITIAL_SIZE];
		size = 0;
	}

	public boolean contains(Object arg0) {
		for (Object val : array) {
			if (val != null) {
				if (val.equals(arg0)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean containsAll(Collection<?> arg0) {
		Object[] a = arg0.toArray();
		for (Object val : a) {
			contains(val);
		}
		return false;
	}

	public Object get(int indexToGetObjectFrom) {
		checkRange(indexToGetObjectFrom);
		return array[indexToGetObjectFrom];
	}

	public int indexOf(Object arg0) {
		if (arg0 == null) {
			for (int index = 0; index < size; index++) {
				if (array[index] == null) {
					return index;
				}
			}
		} else {
			for (int index = 0; index < size; index++) {
				if (array[index]!=null && array[index].equals(arg0)) {
					return index;

				}
			}
		}
		return -1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Iterator<Object> iterator() {
		return this.new It();
	}

	public class It implements Iterator<Object> {
		private int currentIndex = 0;

		public boolean hasNext() {
			return currentIndex != size;
		}

		public Object next() {
			return array[currentIndex++];
		}

	}

	public int lastIndexOf(Object arg0) {
		for (int i = size - 1; i <= 0; i--) {
			if (array[i].equals(arg0)) {
				return i;
			}
		}
		return -1;
	}

	public ListIterator<Object> listIterator() {
		return null;
	}

	public ListIterator<Object> listIterator(int arg0) {
		return null;
	}

	public boolean remove(Object arg0) {
		int a = indexOf(arg0);
		if (a > -1) {
			remove((int)a);
			return true;
		}
		return false;
	}

	public Object remove(int arg0) {
		checkRange(arg0);
		Object a = array[arg0];
		System.arraycopy(array, arg0+1, array, arg0, size-arg0);
		size--;
		return a;
	}

	private void checkRange(int index) {

		if (size < index) {
			throw new IndexOutOfBoundsException(
					"Index jest większy niż rozmiar listy");
		} else if (index < 0) {
			throw new IndexOutOfBoundsException("index jest ujemny");
		}

	}

public boolean removeAll(Collection<?> arg0) {
		for (Object val : arg0) {
			if (contains(val)) {
				remove((Object)val);
			}
		}
		return false;
	}

	public boolean retainAll(Collection<?> arg0) {
		boolean modPointer = false;
		for (int i = 0; i < size; i++) {
			if (arg0.contains(array[i]) == false) {
				array[i] = null;
			}
		}
		return modPointer;
	}

	public Object set(int arg0, Object arg1) {
		checkRange(arg0);
		Object previousObject = array[arg0];
		array[arg0] = arg1;
		return previousObject;
	}

	public int size() {
		return size;
	}

	public List<Object> subList(int arg0, int arg1) {

		WojteksArrayList<T> sublist = new WojteksArrayList<T>(arg1 - arg0);
		for (int i = arg0; i < arg1; i++) {
			// Arrays.copyOfRange(array, 0, size)
			sublist.add(array[i]);
		}
		return sublist;
	}

	public Object[] toArray() {
		Object[] arrayExactlyRepresentingList;
		arrayExactlyRepresentingList = Arrays.copyOfRange(array, 0, size);
		return arrayExactlyRepresentingList;
	}

	@SuppressWarnings("unchecked")
	public Object[] toArray(Object[] arg0) {
		return null;
	}

	public void printMe() {
		System.out.println(toString());
		for (int i = 0; i < size; i++) {
			System.out.print("[ " + i + ": " + array[i] + " ]");
		}
		System.out.println(" koniec");

	}

	public void cleanUp() {
		for (Object val : array) {
			if (val == null) {
				remove(val);
			}
		}

	}

}