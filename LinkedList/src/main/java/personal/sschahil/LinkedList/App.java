package personal.sschahil.LinkedList;

/**
 * Hello world!
 *
 */
public class App<T> {
    Node head;

    public App() {
    	head = new Node(null);
    }//end of App constructor

    public void print() {
    	Node current = head;

    	while(current.next != null) {
    		System.out.print(current.value + " -> ");
    		current = current.next;
    	}
        System.out.println(current.value);
    	System.out.println();
    }//end of method print

    public int setSize(int size) {
        Node<T> current = head;

        while(current.next != null) {
            size++;
            current = current.next;
        }
        size++;
        return size;
    }//end of setSize method

    public int getSize() {
        int size = 0;
        if(head.value != null)
            size = setSize(size);
        return size;
    }//end of getSize method

    public void add(T value, int index) {
    	Node current = head;
    	Node newNode = new Node(value);

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
            }//end of if statement for adding node to end
            int jump = 1;
            if(jump < index - 1) {
                current = current.next;
                jump++;
            }
            Node<T> temp = current.next;
            current.next = newNode;
            newNode.next = temp;
            return;
        }//end of switch statement
    }//end of method add

    public void remove(int index) {
        Node<T> current = head;

        if(index < 1 || index > getSize()) {
            System.out.println("Error: Out of Bounds");
            return;
        }
        if(current.value == null) {
            System.out.println("Error: No values to remove");
            return;
        }

        switch(index) {
        case 1:
            head = current.next;
            current.next = null;
            return;
        default:
            int jump = 1;
            if(index == getSize()) {
                while(jump < index) {
                    current = current.next;
                    jump++;
                }
                current.next = null;
                return;
            }//removing last node

            while(jump < index - 1) {
                current = current.next;
                jump++;
            }
            Node<T> temp = current.next;
            current.next = temp.next;
            temp.next = null;
            return;
        }//end of switch method
    }//end of remove method

    public void editNode(T value, int index) {
        Node<T> current = head;

        if(index < 1 || index > getSize()) {
            System.out.println("Error: Out of Bounds");
        }
        if(current.value == null) {
            System.out.println("Error: No values to edit");
        }

        switch(index) {
        case 1:
            current.value = value;
            return;
        default:
            int jump = 1;
            while(jump < index) {
                current = current.next;
                jump++;
            }
            current.value = value;
            return;
        }//end of switch statement
    }//end of editNode method

    public void destroy() {
        head.next = null;
        head.value = null;
    }//end of destroy method
}//end of class App<T>

//Creates a node 
class Node<T> {

	Node next;
	T value;

	public Node(T value) {
		this.value = value;
		next = null;
	}
}//end of class Node