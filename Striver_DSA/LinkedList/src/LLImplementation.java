public class LLImplementation {

    // Node
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    // Linked-list data structure
    public static class LinkedList{
        Node head = null;
        Node tail = null;
        int size = 0;

        // Inserting a node  at end of the list
        void insertAtEnd(int val){

            Node temp = new Node(val);

            if(head == null){
                head = temp;
            }
            else{
                tail.next = temp;
            }
            tail = temp;
            size++;
        }

        // Inserting a node at the beginning of the list
        void insertAtBeginning(int val){
            Node temp = new Node(val);

            if(head == null){
                tail = temp;
            }
            else{
                temp.next = head;
            }
            head = temp;
            size++;
        }

        // Insert at any index
        void insertAtIdx(int idx, int val){
            Node newNode = new Node(val);
            Node temp = head;

            if(idx == size()){
                insertAtEnd(val);
                return;
            } else if (idx == 0) {
                insertAtBeginning(val);
                return;
            } else if (idx < 0) {
                System.out.println("Wrong Index");
                return;
            } else if (idx > size()) {
                System.out.println("Wrong Index");
                return;
            }

            for(int i = 1; i < idx; i++){
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }

        // Get value at index
        int getValueAt(int idx){
            if(idx == 0){
                return head.data;
            } else if (idx == size()-1) {
                return tail.data;
            } else if (idx >= size() || idx < 0) {
                System.out.println("Index out  of bound");
                return -1;
            }

            Node temp = head;

            for(int i = 1; i <= idx; i++){
                temp = temp.next;
            }

            return temp.data;
        }

        // Displaying the linked-list
        void display(){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

        // Size fo the linked-list
        int size(){
//            Node temp = head;
//            int count = 0;
//
//            while(temp != null){
//                count++;
//                temp = temp.next;
//            }
//
//            return count;
            return size;
        }
    }

    // Main function
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insertAtEnd(4); // 4
        ll.insertAtEnd(5); // 4 5
        ll.insertAtEnd(10); // 4 5 10
        ll.insertAtEnd(27); // 4 5 10 27
        ll.insertAtEnd(42); // 4 5 10 27 42
        ll.display();
        System.out.println("\nList size = " + ll.size());
        System.out.println();
        ll.insertAtBeginning(100);
        ll.insertAtBeginning(21);
        ll.display();
        System.out.println("\nList size = " + ll.size());
        System.out.println();
        ll.insertAtIdx(3, 81);
        ll.display();
        System.out.println("\nList size = " + ll.size());
        System.out.println();
        System.out.println(ll.head.data);
        System.out.println(ll.tail.data);
        System.out.println();
        System.out.println(ll.getValueAt(4));
    }
}
