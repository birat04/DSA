class DNode{
    int data;
    DNode prev, Next;
    DNode(int data){
        this.data = data;
        this.prev = this.Next = null;
    }
}
public class DoublyLinkedList {
    DNode Head;
    public void insert(int data){
        DNode newNode = new DNode(data);
        if(Head == null){
            Head = newNode;
            return;
        }
        DNode current = Head;
        while(current.Next != null){
            current = current.Next;
        }
        current.Next = newNode;
        newNode.prev = current;
            
    }
    public void delete(int value){
        if (Head == null) return;
        DNode current = Head;

        if(current.data == value){
            Head = current.Next;
            if(Head != null) Head.prev = null;
            return;
        }
        while (current != null && current.data != value){
            current = current.Next;
        }
        if(current != null){
            if(current.prev != null) current.prev.Next = current.Next;
            if(current.Next != null) current.Next.prev = current.prev;
        }
    }
    public void displayForward(){
        DNode current = Head;
        System.out.print("Forward: ");
        while (current != null){
            System.out.print(current.data + "<->");
            current = current.Next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(5);
        list.insert(15);
        list.insert(25);
        list.insert(35);
        list.displayForward();
        list.delete(25);
        list.displayForward();
        
    }

    
}
