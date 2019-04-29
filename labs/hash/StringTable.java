package hash;

import java.util.LinkedList;
import java.util.ListIterator;

//
// STRINGTABLE.JAVA
// A hash table mapping Strings to their positions in the the pattern sequence
// You get to fill in the methods for this part.
//
public class StringTable {
    
    private LinkedList<Record>[] buckets;
    private int nBuckets;

    //
    // number of records currently stored in table --
    // must be maintained by all operations
    //
    public int size;
    
    
    //
    // Create an empty table with nBuckets buckets
    //
    @SuppressWarnings("unchecked")
	public StringTable(int nBuckets)
    {
    	this.nBuckets = nBuckets;
    	this.size=0;
    	buckets = new LinkedList[nBuckets];
//    	for(int i=0; i<this.nBuckets; ++i) {
//    		buckets[i] = null;
//    	}
    	
    	// TODO - fill in the rest of this method to initialize your table
    }
    
    
    /**
     * insert - inserts a record to the StringTable
     *
     * @param r
     * @return true if the insertion was successful, or false if a
     *         record with the same key is already present in the table.
     */
    public boolean insert(Record r) 
    {  
    	
//    	if(this.nBuckets==0) {
//    		return false;
//    	}
    	int num = toIndex(stringToHashCode(r.key));
    	
    	if(buckets[num]==null) {
    		buckets[num] = new LinkedList<Record>();
    	}
    	
    	//for(int i=0; i<this.nBuckets; ++i) {
    		for(Record re : buckets[num]) {
        		if(re.key.equals(r.key)) {
    			return false;
        		}	
    		}
    	//}

    	buckets[num].add(r);
    	size++;
//    	for(int i=0; i<this.nBuckets; ++i) {
//    		if(buckets[i].get(i)==null) {
//    			buckets[i].add(r);
//    			return true;
//    		}
//    	}
    	// TODO - implement this method
	
    	return true;
    }
    
    
    /**
     * find - finds the record with a key matching the input.
     *
     * @param key
     * @return the record matching this key, or null if it does not exist.
     */
    public Record find(String key) 
    {
    	int num = toIndex(stringToHashCode(key));
//    	if(this.nBuckets==0) {
//    		return null;
//    	}
    	if(buckets[num]==null) {
    		return null;
    	}
    	for(Record re : buckets[num]) {
    		if(re.key.equals(key)) {
    			return re;
   			}
   		}
//    		if(buckets[i].get(i).key == key) {
//    			return buckets[i].get(i);
//    		}
    	// TODO - implement this method
	
    	return null;
    }
    
    
   //
    //
    
    /**
     * remove - finds a record in the StringTable with the given key
     * and removes the record if it exists.
     *
     * @param key
     */
    public void remove(String key) 
    {
    	int num = toIndex(stringToHashCode(key));
    	if(buckets[num]==null) {
    		return;
    	}
    	ListIterator<Record> re = buckets[num].listIterator();
    	while(re.hasNext() ) {
    		if(re.next().key.equals(key)) {
    			re.remove();
    			size--;
    			return;
    		}
   		}
//    		if(buckets[i].get(i).key==key) {
//    			buckets[i]=null;
//    		}
    	
    	//find, remove
    	// TODO - implement this method
    }
    

    /**
     * toIndex - convert a string's hashcode to a table index
     *
     * As part of your hashing computation, you need to convert the
     * hashcode of a key string (computed using the provided function
     * stringToHashCode) to a bucket index in the hash table.
     *
     * You should use a multiplicative hashing strategy to convert
     * hashcodes to indices.  If you want to use the fixed-point
     * computation with bit shifts, you may assume that nBuckets is a
     * power of 2 and compute its log at construction time.
     * Otherwise, you can use the floating-point computation.
     */
    private int toIndex(int hashcode)
    {
    	double ans = 0;
    	ans = Math.abs((hashcode * ((Math.sqrt(5)-1)/2)) % 1.0);
    	
    	
    	
    	// Fill in your own hash function here
	
    	return (int)(ans * nBuckets);
    }
    
    
    /**
     * stringToHashCode
     * Converts a String key into an integer that serves as input to
     * hash functions.  This mapping is based on the idea of integer
     * multiplicative hashing, where we do multiplies for successive
     * characters of the key (adding in the position to distinguish
     * permutations of the key from each other).
     *
     * @param string to hash
     * @returns hashcode
     */
    int stringToHashCode(String key)
    {
    	int A = 1952786893;
	
    	int v = A;
    	for (int j = 0; j < key.length(); j++)
	    {
    		char c = key.charAt(j);
    		v = A * (v + (int) c + j) >> 16;
	    }
	
    	return v;
    }

    /**
     * Use this function to print out your table for debugging
     * purposes.
     */
    public String toString() 
    {
    	StringBuilder sb = new StringBuilder();
	
    	for(int i = 0; i < nBuckets; i++) 
	    {
    		sb.append(i+ "  ");
    		if (buckets[i] == null) 
		    {
    			sb.append("\n");
    			continue;
		    }
    		for (Record r : buckets[i]) 
		    {
    			sb.append(r.key + "  ");
		    }
    		sb.append("\n");
	    }
    	return sb.toString();
    }
}
