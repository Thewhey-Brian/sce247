package studio3;

public class OrderedArray<T extends Comparable<T>> implements PriorityQueue<T> {

	public T[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public OrderedArray(int maxSize) {
		array = (T[]) new Comparable[maxSize];
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		if(this.size==0) {
			return true;
		}
		return false;
	}

	@Override
	public void insert(T thing) {
		if(this.size==0) {
			this.array[0]=thing;
			this.size++;
		}
		else {
			int i=0;
//			System.out.println(array[i]);
			while(thing.compareTo(this.array[i])>0) {
				++i;
			}
			for(int j=size; j>i; ++j) {
				this.array[j] = this.array[j-1];
			}
			this.array[i]=thing;
			this.size++;
		}
		
		if(this.size>this.array.length) {
			return;
		}
	}
	
	@Override
	public T extractMin() {
//		T min = this.array[0];
//		for(int i=0; i<this.array.length; ++i) {
//			if(min.compareTo(this.array[i])>0) {
//				min = this.array[i];
//			}
//		}
//		if(this.array.length==0) {
//			return null;
//		}
		if(this.size==0) {
			return null;
		}
		for(int i=0; i<this.size-1; ++i) {
			this.array[i] = this.array[i+1];
		}
		this.size--;
		return null;
	}

}
