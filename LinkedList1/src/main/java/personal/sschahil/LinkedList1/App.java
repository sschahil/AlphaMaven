package personal.sschahil.LinkedList1;

/**
 * LinkedList1
 *
 */
public class App<T> {
    Node<T>  head;
  
    public App() {
     	head = new Node(null);
    }

    public void print() {
	Node<T> current = head;

	while(current.next != null) {
	     System.out.print(current.value + " -> ");
	     current = current.next;
	}
	
	System.out.println(current.value);
    }//end of print method

    public int setSize(int size) {
    	Node<T> current = head;

	while(current.next != null) {
	     current = current.next;
	     size++;
	}
	size++;
	return size; 
    }//end of setSize method

    public int getSize() {
	int size = 0;
	if(head.value != null) {
             size = setSize(size);
	}
	return size;
    }//end of getSize method
	
    public void add(T value, int index) {
	Node<T> current = head;
	Node<T> newNode = new Node<T>(value);
	
	if(index < 0 || index > getSize()) {
	     System.out.println("Error: Out of Bounds");
	     return;
	}	
	if(current.value == null) {
	     current.value = newNode.value;
	     return;
	}

	switch(index) {
	case 0:
	     newNode.next = current;
	     head = newNode;
	     return;
	default:
	     if(index == getSize()) {
		while(current.next != null) {
		    current = current.next;
		}
		current.next = newNode;
		return;
	     }
	     int jump = 1;
	     while(jump < index) {
	    	current = current.next;
		jump++;
	     }
	     newNode.next = current.next;
	     current.next = newNode;
	     return;
	}//end of switch statement
    }//end of add method

    public void remove(int index) {
	Node<T> current = head;
	
	if(index < 1 || index > getSize()) {
	     System.out.println("Error: Out of bounds");
	     return;
	}//Out of bounds exception
	if(current.value == null) {
	     System.out.println("Error: No value in list");
	     return;
	}//checking for empty list

	switch(index) {
	case 1:
	     Node<T> temp = current.next;
	     head = temp;
	     current.next = null;
	     return;
	default:
	     int jump = 1;
	     if(index == getSize()) {
	     	while(jump < index - 1) {
		     current = current.next;
		     jump++;	      
		}
		current.next = null;
		return;
             }//end of 
	     while(jump < index - 1) {
		current = current.next;
		jump++;
	     }
	     temp = current.next;
	     current.next = temp.next;
	     temp.next = null;
	     return;
	}//end of switch statement
    }//end of remove method
}//end of App class

class Node<T> {
    Node<T> next;
    T value;
   
    Node(T value) {
    	this.value = value;
	next = null;
    }
}//end of Node Class
