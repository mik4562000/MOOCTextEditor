package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<>(null);
		tail = new LLNode<>(null, head);
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		add(size, element);
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index >= size )
		{
			throw new IndexOutOfBoundsException();
		}

		LLNode node = head.next;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				return (E) node.data;
			}
			else {
				node = node.next;
			}
		}

		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}

		if (index < 0 || index > size )
		{
			throw new IndexOutOfBoundsException();
		}

		LLNode node;
		if (index == size) {
			node = tail;
		}
		else {
			node = head.next;
			for (int i = 0; i < size; i++) {
				if (i == index) {
					break;
				} else {
					node = node.next;
				}
			}
		}

		LLNode newNode = new LLNode<E>(element, node.prev, node);
		size++;

	}

	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size )
		{
			throw new IndexOutOfBoundsException();
		}

		LLNode node = head.next;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				break;
			}
			else {
				node = node.next;
			}
		}

		node.prev.next = node.next;
		node.next.prev = node.prev;
		this.size--;
		return (E)node.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}

		if (index < 0 || index >= size )
		{
			throw new IndexOutOfBoundsException();
		}

		LLNode node = head.next;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				break;
			} else {
				node = node.next;
			}
		}

		return (E)node.data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e, LLNode prevNode)
	{
		this(e);
		this.prev = prevNode;
		prevNode.next = this;
	}

	public LLNode(E e, LLNode prevNode, LLNode nextNode)
	{
		this(e, prevNode);
		this.next = nextNode;
		nextNode.prev = this;
	}

}
