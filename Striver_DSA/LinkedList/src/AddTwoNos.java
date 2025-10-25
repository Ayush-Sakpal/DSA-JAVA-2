public class AddTwoNos {

    public static LLImplementation.Node addTwoNos(LLImplementation.LinkedList ll1, LLImplementation.LinkedList ll2){
        LLImplementation.Node dummyNode = new LLImplementation.Node(-1);
        LLImplementation.Node current = dummyNode;

        LLImplementation.Node t1 = ll1.head;
        LLImplementation.Node t2 = ll2.head;
        int carry = 0;
        int sum = 0;

        while(t1 != null || t2 != null){

            if(t1 == null){
                sum = t2.data + carry;
                t2 = t2.next;
            }
            else if(t2 == null){
                sum = t1.data + carry;
                t1 = t1.next;
            }
            else {
                sum = t1.data + t2.data + carry;
                t1 = t1.next;
                t2 = t2.next;
            }

            LLImplementation.Node newNode = new LLImplementation.Node(sum%10);

            current.next = newNode;
            current = current.next;
            carry = sum/10;
        }

        if(carry != 0) {
            LLImplementation.Node newNode = new LLImplementation.Node(carry);

            current.next = newNode;
            current = current.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        LLImplementation.LinkedList ll1 = new LLImplementation.LinkedList();
        LLImplementation.LinkedList ll2 = new LLImplementation.LinkedList();

        ll1.insertAtEnd(3);
        ll1.insertAtEnd(5);
        System.out.println("Linked List 1:");
        ll1.display();
        System.out.println();

        ll2.insertAtEnd(4);
        ll2.insertAtEnd(5);
        ll2.insertAtEnd(9);
        ll2.insertAtEnd(9);
        System.out.println("Linked List 2:");
        ll2.display();

        LLImplementation.Node newHead = addTwoNos(ll1, ll2);
        System.out.println(newHead.data);

        LLImplementation.Node temp = newHead;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
}
