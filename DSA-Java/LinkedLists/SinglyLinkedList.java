class Node{
    int data;
    Node Next;

    Node (int data){
        this.data = data;
        this.Next = null;
    }
}
public class SinglyLinkedList {
    Node Head;

    public void insert(int data){
        Node newNode = new Node(data);
        if(Head == null){
            Head = newNode;
            return;
        }
        Node current = Head;
        while(current.Next != null){
            current = current.Next;
        }
        current.Next = newNode;
    }
    public void delete(int value){
        if(Head == null) return;
        if(Head.data == value){
            Head = Head.Next;
            return;
        }
        Node current = Head;
        while(current.Next != null && current.Next.data != value){
            current = current.Next;
        }
        if(current.Next == null) return;
        current.Next = current.Next.Next; 
    }
}

    
