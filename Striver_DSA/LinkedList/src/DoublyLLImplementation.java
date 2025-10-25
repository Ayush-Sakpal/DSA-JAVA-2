public class DoublyLLImplementation {

    public static class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    // Linked List data structure
    public static class DoublyLinkedList{
        Node head = null;
        Node tail = null;
        int size = 0;

        // Inserting node at end
        void insertAtEnd(int data){
            Node newNode = new Node(data);

            if(head == null){
                head = newNode;
            }
            else{
                tail.next = newNode;
                newNode.prev = tail;
            }
            tail = newNode;

            size++;
        }

        // Inserting Node at the beginning
        void insertAtBeginning(int data){
            /*
                1. Create a new node(newNode)
                2. newNode.next -> head
                3. head.prev -> newNode
                4. head = newNode
            */

            Node newNode = new Node(data);

            if(head == null){
                head = newNode;
                tail = newNode;
            }
            else{
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        }

        // Insert at any index
        void insertAtIdx(int data, int idx){
            if(idx == 0){
                insertAtBeginning(data);
                return;
            } else if (idx == size()) {
                insertAtEnd(data);
                return;
            } else if(idx > size() || idx < 0){
                System.out.println("Wrong index");
                return;
            }

            Node newNode = new Node(data);
            Node temp = head;

            for(int i=0; i < idx-1; i++){
                temp = temp.next;
            }

            newNode.prev = temp;
            newNode.next = temp.next;

            temp.next = newNode;
            newNode.next.prev = newNode;

            size++;
        }

        // Deleting node at the beginning
        void deleteAtBegin() {

            if(head != null) {
                Node temp = head;

                head = temp.next;
                temp.next = null;
                head.prev = null;

                size--;
            }
            else {
                System.out.println("No LinkedList present");
                return;
            }
        }

        // deleting node at the end
        void deleteAtEnd() {
            if(tail != null){
                Node temp = tail;

                tail = temp.prev;
                temp.prev = null;
                tail.next = null;

                size--;
            }
            else{
                System.out.println("LinkedList does not exist.");
                return;
            }
        }

        // Delete node at some index i
        void deleteAtIdx(int idx){
            if (idx == 0){
                deleteAtBegin();
            }
            else if(idx == size()-1){
                deleteAtEnd();
            }
            else if (idx >= size() || idx < 0) {
                System.out.println("Wrong index");
                return;
            }
            else {
                Node temp = head;
                int i = 0;

                while(i != idx) {
                    temp = temp.next;
                    i++;
                }

                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp.next = null;
                temp.prev = null;

                size--;
            }
        }

        // Displaying the list
        void display(){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

        // Return size
        int size(){
            return size;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtEnd(4); // 4
        dll.insertAtEnd(5); // 4 5
        dll.insertAtEnd(10); // 4 5 10
        dll.insertAtEnd(-1); // 4 5 -1
        dll.display();
        System.out.println("\nList Size = " + dll.size());
        System.out.println();
        dll.insertAtBeginning(100); // 100 4 5 -1
        dll.insertAtBeginning(24); // 24 100 4 5 -1
        dll.display();
        System.out.println("\nList Size = " + dll.size());
        System.out.println();
        dll.insertAtIdx(200, 3); // 24 100 4 200 5 -1
        dll.insertAtIdx(400, 5); // 24 100 4 200 5 400 -1
        dll.display();
        System.out.println("\nList Size = " + dll.size());
        System.out.println();
        dll.deleteAtBegin();
        dll.display();
        System.out.println("\nList Size = " + dll.size());
        System.out.println();
        dll.deleteAtEnd();
        dll.display();
        System.out.println("\nList Size = " + dll.size());
        System.out.println();
        dll.deleteAtIdx(2);
        dll.display();
        System.out.println("\nList Size = " + dll.size());
        System.out.println();
    }
}
