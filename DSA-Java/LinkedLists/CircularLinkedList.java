public class CircularLinkedList {
    CNode head = null;
    CNode tail = null;

    // Insert at end
    public void insert(int data) {
        CNode newNode = new CNode(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        tail.next = head;
    }

    // Display
    public void display() {
        if (head == null) return;

        CNode current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        CircularLinkedList clist = new CircularLinkedList();
        clist.insert(1);
        clist.insert(2);
        clist.insert(3);
        clist.display(); 
    }
}
