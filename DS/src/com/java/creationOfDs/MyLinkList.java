package com.java.creationOfDs;

public class MyLinkList<E> {

	
	private int size;// used for insert at a particular position
	private Node<E> head;
	private Node<E> end;

	public MyLinkList() {
		head = null;
		end = null;
		size = 0;
	}

	public void add(E e) {

		Node<E> node = new Node<>();
		node.setElement(e);
		node.setNext(null);
		size++;
		if (head == null) {
			node.setPrevious(null);
			head = node;
			end = head;
		} else {
			node.setPrevious(end);
			end.setNext(node);
			end = node;
		}

	}

	public void traverse() {
		
		if (head == null) {
			System.out.println("Empty list");
		} else {
			Node<E> traversal = head;
			System.out.print("[");
			while (traversal.getNext() != null) {
				System.out.print(" " + traversal.getElement());
				traversal = traversal.getNext();

			}
			System.out.print(" " + end.getElement());
			System.out.print(" ]");
		}
	}

	public void remove(E element) {
		
		if (head == null) {
			System.out.println("Empty list");
		}else {
			if(head.getElement() == element) {
				 head = head.getNext();
				 head.setPrevious(null);
			}else if(end.getElement() == element){
				end = end.getPrevious();
				end.setNext(null);
			}else{
			
				Node<E> traversal = head;
				 
				while(traversal.getNext() != null && traversal != end) {
					
					if(traversal.getElement() == element) {
						
						traversal.getPrevious().setNext(traversal.getNext());
						traversal.getNext().setPrevious(traversal.getPrevious());
						break;
					}
					traversal = traversal.getNext();
				}
			}
			
		}
		--size;
	}
	public static void main(String[] args) {

		MyLinkList<Integer> myList = new MyLinkList<>();
		myList.add(5);
		myList.add(10);
		myList.add(15);
		myList.add(20);
		myList.add(25);

		myList.traverse();
		myList.remove(20);
		myList.traverse();
		myList.remove(5);
		myList.traverse();
		myList.remove(25);
		myList.traverse();
		System.out.println(myList.size);
		
	}
	
	
}
