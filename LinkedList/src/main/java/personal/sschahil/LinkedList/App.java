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

    	System.out.print(current.value);
    	while(current != null) {
    		System.out.print(" -> " + current.value);
    		current = current.next;
    	}
    	System.out.println();
    }//end of method print

    public void add(T value) {
    	Node current = head;
    	Node newNode = new Node(value);

    	if(current.value == null) {
    		current.value = newNode.value;
    		return;
    	}

    	while(current.next != null) {
    		current = current.next;
    	}

    	current.next = newNode;
    }//end of method add

    public static void main(String[] args) {
    	App<String> list = new App<String>();

    	list.add("Hello");
    	list.add("my");
    	list.add("name");
    	list.add("is");
    	list.add("Jon");
    	list.add("Chu");

    	list.print();
    }//end of method main
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