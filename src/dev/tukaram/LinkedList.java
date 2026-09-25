package dev.tukaram;

public class LinkedList <T>{
	Node<T> current;
	Node<T> head;
	Node<T> tail;
	
	int maxCount= 0;
	
	public void add(T data) {
		Node <T> tempNode = new  Node<>(data);
		
		if(head == null  ) {
			current = head = tail = tempNode;
		}else {
			current.next = tempNode;
			tempNode.prev = current;
			current = tempNode;
		}
		maxCount++;
	}
	
	public void delete(int index) {
		if(head == null || index > maxCount -1 )
			return;
		
		if(head == tail)
			current = head = tail = null;
		
		else if(index == 0) {
			head = head.next;
			head.prev= null;
			current = head;
		}
		else if(index ==  maxCount -1) {
			tail = tail.prev;
			tail.next = null;
			current = tail;
		}
		else {
			Node<T> tempNode = head;
			
			for(int temp =0;temp<index;temp++) {
				tempNode=tempNode.next;
			}
			tempNode.next.prev = tempNode.prev;
			tempNode.prev.next = tempNode.next;
		}
		maxCount--;

	}
	public T getFirst() {
		if(head == null)
			return null;
		
		current = head;
		return current.data;
		
	}
	
	public T getLast() {
		if(head == null)
			return null;
		
		current = tail;
		return current.data;
		
	}
	
	public T getNext() {
		if(head == null || current.next==null)
			return null;
		else {
			current = current.next;
			return current.data;
		}
	}
	
	public T getPrev() {
		if(head == null || current.prev == null) {
			return null;
		}
		else {
			current = current.prev;
			return current.data;
		}
	}

}
