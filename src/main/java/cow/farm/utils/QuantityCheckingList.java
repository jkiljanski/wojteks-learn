package cow.farm.utils;
import cow.farm.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class QuantityCheckingList<T> extends WojteksArrayList<T> {

	static final int INITIAL_SIZE = 10;

	public QuantityCheckingList() {

	}

	public QuantityCheckingList(int dimension) {

	}
	

	public HashMap<Object, Integer> getQuantityOfEachObject() {

		HashMap<Object, Integer> hashmap = new HashMap <>();
		
		for (Object val  : this) {
			if (hashmap.containsKey(val)) {
				int a = hashmap.get(val);
				hashmap.put(val, ++a);
			} else {
				hashmap.put(val, 1);
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
