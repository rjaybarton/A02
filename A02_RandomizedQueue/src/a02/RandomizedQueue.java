package a02;

import java.util.Deque;
import java.util.Iterator;

/**
 * A randomized queue is similar to a stack or queue, except that the 
 * item removed is chosen uniformly at random from items in the data structure.
 * @author rjayb
 *
 */
public class RandomizedQueue<Item> {
	
	Deque<Item> randomQueue;
	/**
	 * Constructs an empty randomized queue.
	 * 
	 */
	public RandomizedQueue() 
	{
		Deque<Item> randomQueue = new Deque<Item>();
	}
	
	/**
	 * Checks is queue is empty (true) or not (false).
	 * @return boolean
	 * 
	 */
	public boolean isEmpty() {
	   return randomQueue.size() == 0; // 
	}
	
	/**
	 * Returns the number of items on the queue.
	 * @return int 
	 * 
	 */
	public int size() {
	   return randomQueue.size();  // return the number of items on the queue
	}
	
	/**
	 * Adds an item to queue
	 * @param item
	 */
	public void enqueue(Item item) {
	   randomQueue.addFirst(item);
	}
	
	/**
	 * Removes and returns random item from  queue
	 * @return
	 * 
	 */
	public Item dequeue() {
		return null; //TODO
	  // delete and return a random item
	}
	
	/**
	 * Returns a random item
	 * @return
	 * 
	 */
	public Item sample() {
		return null; // TODO
		// return (but do not delete) a random item
	}
	
	/**
	 * Returns a independent iterator over items in random order
	 * @return
	 * 
	 */
	public Iterator<Item> iterator() {
		return null; //TODO
		// return an independent iterator over items in random order
	}

	/**
	 * RandomizedQueue Test Client
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
