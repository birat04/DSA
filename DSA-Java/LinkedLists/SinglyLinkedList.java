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
    public boolean search(int value){
        Node current = Head;
        while(current != null){
            if(current.data == value)return true;
            current = current.Next;
        }
        return false;
    }
    public void display(){
        Node current = Head;
        while(current != null){
            System.out.print(current.data+ "->");
            current = current.Next;
        }
        System.out.println("null");
    }
    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.display();
        list.delete(20);
        list.display();
        System.out.println(list.search(30));
        System.out.println(list.search(40));
    }
}


    
