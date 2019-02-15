package studio3;

import java.util.LinkedList;
import java.util.List;

public class UnorderedList<T extends Comparable<T>> implements PriorityQueue<T> {

	public LinkedList<T> list;
	
	public UnorderedList() {
		list = new LinkedList<T>();
	}
	
	@Override
	public boolean isEmpty() {
		if(this.list.size()==0) {
			return true;
		}
		return false;
	}

	@Override
	public void insert(T thing) {
		this.list.add(thing);
	}

	@Override
	public T extractMin() {
		T min = this.list.getFirst();
				for(T a: this.list) {
			if(min.compareTo(a)>0) {
				min = a;
			}
		}
		this.list.remove(min);
		return min;
	}

}
