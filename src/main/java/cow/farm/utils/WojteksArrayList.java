package cow.farm.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class WojteksArrayList implements List {
	static final int INITIAL_SIZE = 10;

	private Object[] array;
	private int size;
	private Iterator iterator = new It();

	public WojteksArrayList() {
		//extract constant
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

	public boolean addAll(Collection arg0) {
		Object a[] = arg0.toArray();
		makePlace(size + a.length);
		for (int i = size; i < a.length; i++) {
			array[i] = a[i - size];
		}
		size = size + a.length;
		return true;
	}

	public boolean addAll(int arg0, Collection arg1) {
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
			//FIXME magic number
			Object[] placeholder = new Object[expectedArraySizeAfterOperation + INITIAL_SIZE];
			for (int i = 0; i < array.length; i++) {
				//FIXME use System.arrayCopy();
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
			//FIXME use equals()
			if (val != null){
			if (val.equals(arg0) ) {
				return true;
			}
			}
		}
		return false;
	}

	//TODO finish me
	public boolean containsAll(Collection arg0) {
		Object[] a = arg0.toArray();
		for (Object val : a) {
			contains(val);
		}
		return false;
	}

	//TODO check what is thrown on invalid index
	public Object get(int indexToGetObjectFrom) {
		checkRange(indexToGetObjectFrom);
		return array[indexToGetObjectFrom];
	}

	public int indexOf(Object arg0) {
		//FIXME double iteration

		for (int index = 0; index<size; index++)
		//and what if we allow nulls inside our list? If we do, we should look for it, if not, we shouldn't allow to add it
			if (array[index] ==null && arg0==null) {
				return index;
			}
			else if (array[index].equals(arg0)){
				return index;
						
	}
		return -1;
	}
	public boolean isEmpty() {
		return size == 0;
	}

	public Iterator iterator() {
		return this.new It();
	}

	//FIXME class name should always start with capital letter
	//FIXME every name should be meaningful, call it WojteksArrayListIterator
	public class It implements Iterator {
		//I know that it hase default value, but we should set it to 0 explicit just to make it more readable
		private int currentIndex = 0;

		public boolean hasNext() {
			return currentIndex != size;
		}

		public Object next() {
			return array[currentIndex++];
		}

	}

	public int lastIndexOf(Object arg0) {
		for (int i = size -1; i<=0; i--){
			if (array[i].equals(arg0)){
				return i;
			}
		}
		return -1;
	}

	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean remove(Object arg0) {
		int a = indexOf(arg0);
		if (a>-1) {
			remove(a);
			return true;
		}
		return false;
	}

	public Object remove(int arg0) {
		checkRange(arg0);
		Object a = array[arg0];
		for (int i = size - 1; i > arg0; i--) {
			array[i - 1] = array[i];
		}
		size--;
		return a;
	}

	private void checkRange(int index) {
		
		
		if (size < index) {
			throw new IndexOutOfBoundsException(
					"Index jest większy niż rozmiar listy");
		} else if (index<0) {
			throw new IndexOutOfBoundsException("index jest ujemny");
		}
		
	}
// FIXME zostaje ostatni element
	public boolean removeAll(Collection arg0) {
		for (Object val: arg0) {
			if (contains(val)){
				remove(val);
			}
		}
		
		return false;
	}

	public boolean retainAll(Collection arg0) {
		Object [] a = arg0.toArray();
		boolean modPointer = false;
		for (int i = 0; i<size; i++) {
			//add ! before instead of false compare
			// what a hacky way to push responsibility to outher class (contains) :P
			if (arg0.contains(array[i])==false) {
				array[i] = null;
			}
		}
		return modPointer;
	}

//add more meaningful names
	public Object set(int arg0, Object arg1) {
		checkRange(arg0);
		Object previousObject = array[arg0];
		array[arg0] = arg1;
		return previousObject;
	}

	public int size() {
		return size;
	}

	//check javadoc for this method carefully, one range end is included, one excluded
	public List subList(int arg0, int arg1) {
		
		//so this will be 0 for equal arguments
		WojteksArrayList sublist = new WojteksArrayList(arg1-arg0);
		for (int i = arg0; i<arg1; i++){
			//Arrays.copyOfRange(array, 0, size)
			sublist.add(array[i]);
		}
		return sublist;
	}

	public Object[] toArray() {
		Object[] arrayExactlyRepresentingList;
		arrayExactlyRepresentingList = Arrays.copyOfRange(array, 0, size);
		return arrayExactlyRepresentingList;
	}

//that should be easy :P
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	//we use toString() to present object
	public void printMe(){
		System.out.println(toString());
		for (int i = 0; i<size; i++) {
			System.out.print("[ "+ i +": " + array[i] +  " ]");
		}
		System.out.println(" koniec");
		
	}
	//TODO metoda do usuwania nulli w liście
	//FIXME nie działa!!!
	//first you look for object just to search for it once again :P, check remove doc, maybe you can call remove(null) simply
	public void cleanUp () {
		for (Object val: array){
			if (val==null){
				remove(val);
			}
		}
		
	}

}
