package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author rjayb
 * A double-ended queue or deque (pronounced ìdeckî) is a generalization of 
 * a stack and a queue that supports adding and removing items from either 
 * the front or the back of the data structure. 
 * 
 * Reference: https://algs4.cs.princeton.edu/code/ (September 17, 2018)
 * @param <Item> 
 *  
 */

public class Deque<Item> implements Iterable<Item> {
	// Fields
	 private Node<Item> firstItem;    
	 private Node<Item> lastItem;     
	 private int size;               
			
	/**
	 * DONE
	 * Constructs an empty Deque object
	 *  
	 */
	public Deque(){
		size = 0;
		firstItem = null;
		lastItem =null;
	}
	
	/**
	 * Done
	 * Returns true if deque object is empty, returns false if it is not. 
	 * @return boolean 
	 * 
	 */
	public boolean isEmpty() {
		return size == 0; 
	}
	   
	 /**
	 * Done
	 * Returns the number of items on a deque. 
	 * @return int
	 * 
	 */
	public int size() {
		return size; 
	}
	  
	 /**
	 * Done
	 * Adds item to the front of a deque.
	 * @param item
	 * 
	 */
	public void addFirst(Item item)
	{
		nullExceptionCheck(item);
		
		Node<Item> oldFirst = firstItem; // create Node (initially firstItem = pointer at first.next)
		firstItem = new Node<Item>(); // item being passed is now = firstItem stored by inner class Node
		firstItem.item = item; // Node is now equal to item being added
		firstItem.next = oldFirst; // Sets pointer of first item oldFirst.
		size++; // Increments size of list
	}

	/**
	 * Done
	 * Adds item to the end of the deque.
	 * @param item
	 * 
	 */
	public Item addLast(Item item) {
		nullExceptionCheck(item);
		
		Node<Item> oldlast = lastItem; // save item in current last position in Node inner class as oldLast
		lastItem = new Node<Item>(); // assign lastItem to new item being passed
		lastItem.item = item; // pass item being added to new Nodes item.
		lastItem.next = null; // Removes pointer to oldLast item
        if (isEmpty()) firstItem = lastItem; // if list is empty the item being passed is the first and last item
        else           oldlast.next = lastItem; // point the old last item at the new last item. 
        size++; // Increments size of list
        return lastItem.item;// Remove and change return type to void after main testing
	}
	 
	/**
	 * Done
     * Removes and returns the first item on this queue.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item removeFirst() {
    	emptyListCheck(); 
        Item item = firstItem.item;
        firstItem = firstItem.next;
        size--;
        if (isEmpty()) lastItem = null;  // to avoid loitering
        return item;
    }
		
	/**
	 * TODO
	 * Removes item and returns item removed from the back of the deque. Manipulates pointer of Que object
	 * @return item removed in the last position
	 * 
	 */
	public Item removeLast() {
		emptyListCheck();
		// Need to drop last item but I am not having luck
		Item oldLastitem = lastItem.item;    // save Last item to return
		lastItem = null;              // delete last item point to null
		size--;						// decrement the size of list
        
        return oldLastitem;                   // return the saved item
	}

    /**
     * Returns an iterator that iterates over the items in this Deque.
     *
     * @return an iterator that iterates over the items in this Deque.
     */
    public Iterator<Item> iterator()  {
        return new DequeIterator<Item>(firstItem);  
    }

    @SuppressWarnings("hiding")
	private class DequeIterator<Item> implements Iterator<Item> 
    {
        private Node<Item> current;

        public DequeIterator(Node<Item> first) 
        {
            current = first;
        }

        public boolean hasNext()  
        { 
        	return current != null;                     
        }
        
        public void remove()      
        { 
        	throw new UnsupportedOperationException();  
        }

        public Item next() 
        {
            if (!hasNext()) 
            	throw new NoSuchElementException();
            
            Item item = current.item;
            current = current.next; 
            
            return item;
        }
    } 
    
    /**
     * Checks for null exceptions, throws illegalArgumentException
     * @param item
     */
    private void nullExceptionCheck(Item item)
    {
		if (item == null) throw new java.lang.IllegalArgumentException ("Cannot be null. ");
	}
    
	/**
	 * Checks if list is empty throws NoSuchElementException.
	 */
	private void emptyListCheck() 
	{
		if (isEmpty()) throw new NoSuchElementException("List is empty: ");
	}
    
     /**
	 * Done
	 * Inner class that saves pointers in reference to an item 
	 * and another node.
	 * @author rjayb
	 *
	 */
     private static class Node<Item> 
     {
        private Item item; // saves item
        private Node<Item> next; // saves node
        private Node<Item> previousItem;
     }
     
    ///////////////////////////////////////////Helper Methods//////////////////////////////////////////////////////////
    /**
     * Returns Item in front of list
     *
     * @return the item in front of the list
     * @throws NoSuchElementException if this queue is empty
     */
   
     public Item peekFirst() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return (Item) firstItem.item;
    }
    
    /**
	 * Prints a string representation of the Deque list
	 * 
	 */
    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = firstItem;
		
		while(current != null) {
			sb.append(current.item).append(" ");
			current = current.next;
		}
		
		return sb.toString();
	}
   
    /**
	 * Test Client
	 * @param args
	 */
	public static void main(String[] args) {
		
		Deque testDeque = new Deque();
		
//		// Expected true
//		System.out.println("isEmpty before adding: " + testDeque.isEmpty());
//		
//		//Adding items to front of list
//		testDeque.addFirst("Hello"); // is back
//		testDeque.addFirst("Hola");
//		testDeque.addFirst("Bonjour"); // is front
//		
//		// Expected false
//		System.out.println("isEmpty after adding: " + testDeque.isEmpty()); 
//		
//		// Expected Bonjour
//		System.out.println("Last item added to front of list: " +testDeque.peekFirst());
//
//		// Expected: Bonjour
//		System.out.println("Remove First: " + testDeque.removeFirst()); 
//		// Front of list expected (Hola)
//		System.out.println("New item at front: " + testDeque.peekFirst());
//		
//		//expected Hola
//		System.out.println("Remove First: " + testDeque.removeFirst()); 
//		// expected Hello
//		System.out.println("Remove First: " + testDeque.removeFirst());
//		//List should be empty now. 
//		System.out.println("isEmpty: " + testDeque.isEmpty()); 
//		
//		System.out.println();
		
///////////////////////////Breaks when running tests together///////////////////////////////
		// Expected true
		System.out.println("isEmpty before adding: " + testDeque.isEmpty());
		
		//Adding items to back of list
		testDeque.addLast("Hello"); // is front
		testDeque.addLast("Hola");
		testDeque.addLast("Bonjour"); // is back
		
		// Expected false
		System.out.println("isEmpty after adding: " + testDeque.isEmpty()); 
		
		// Expected Hello
		System.out.println("Item at front: " +testDeque.peekFirst());

		// Expected: Bonjour
		System.out.println("Remove last: " + testDeque.removeLast()); 
		// Front of list expected (Hola)
		System.out.println("Same item at front: " + testDeque.peekFirst());
		
		// Last item (Hola)
		testDeque.iterator();
		
		System.out.println("list: " + testDeque);
		
//////////////////////////Errors here/////////////////////////////////////////////////////////		
//		//expected Hola
//		System.out.println("Remove Last: " + testDeque.removeLast()); 
//		// expected Hello
//		System.out.println("Remove Last: " + testDeque.removeLast());
//		//List should be empty now. 
//		System.out.println("isEmpty: " + testDeque.isEmpty()); 
//		
//		System.out.println();	
		}

}
