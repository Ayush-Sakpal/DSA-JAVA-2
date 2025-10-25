import java.util.Stack;

public class ReverseDLL {
    
    // Extreme Solution
    public static void reverseDLLExtreme(DoublyLLImplementation.DoublyLinkedList dll){
        Stack<Integer> st = new Stack<>();

        DoublyLLImplementation.Node temp = dll.head;

        while(temp != null){
            st.push(temp.data);
            temp = temp.next;
        }

        temp = dll.head;

        while(temp != null){
            temp.data = st.pop();
            temp = temp.next;
        }
    }

    // Using links swapping
    public static void reverseDLLSwapping(DoublyLLImplementation.DoublyLinkedList dll){
        DoublyLLImplementation.Node current = dll.head;

        
        while(current != null){
            DoublyLLImplementation.Node temp;

            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

        current = dll.head;
        dll.head = dll.tail;
        dll.tail = current;

    }
    
    public static void main(String[] args) {
        DoublyLLImplementation.DoublyLinkedList dll = new DoublyLLImplementation.DoublyLinkedList();

        dll.insertAtEnd(4);
        dll.insertAtEnd(2);
        dll.insertAtEnd(3);
        dll.insertAtEnd(1);

        System.out.println("Original DLL");
        dll.display();
        System.out.println();

        reverseDLLExtreme(dll);

        System.out.println("Reversed DLL using Extreme solution");
        dll.display();
        System.out.println("Head = " + dll.head.data);
        System.out.println("Tail = " + dll.tail.data);
        System.out.println();

        reverseDLLSwapping(dll);

        System.out.println("Reversed DLL using swapping");
        dll.display();
        System.out.println("Head = " + dll.head.data);
        System.out.println("Tail = " + dll.tail.data);
    }
}
