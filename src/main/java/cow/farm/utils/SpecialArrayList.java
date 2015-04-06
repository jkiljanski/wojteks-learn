package cow.farm.utils;
import cow.farm.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SpecialArrayList<T> extends WojteksArrayList<T> {

	static final int INITIAL_SIZE = 10;

	public SpecialArrayList() {

	}

	public SpecialArrayList(int dimension) {

	}

	public boolean addAll(Collection<? extends Object> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, Collection<? extends Object> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public HashMap <Object, Integer> getQuantityOfEachRace() {

		HashMap <Object, Integer> hashmap = new HashMap <Object, Integer>();

		for (Object val : this) {
			String s =  ((Cow) val).getRace();
			if (hashmap.containsKey(s)) {
				int a = hashmap.get(s);
				hashmap.put(s, ++a);
			} else {
				hashmap.put(s, 1);
			}
		}
		return hashmap;

	}
	
	

	private class ReversedIterator implements Iterator<Object> {
		private int currentIndex = size();

		public boolean hasNext() {
			return currentIndex != 0;
		}

		public Object next() {
			return get(--currentIndex);
		}
	}

	public Iterator<Object> getReversedIterator(){
		return 	this.new ReversedIterator();
		
		
		
	}
}
