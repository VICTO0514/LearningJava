class MyLinkedList<E>{
    MyLinkedList next;
    MyLinkedList head;

    public MyLinkedList() {
        this.next = null;
    }

public void add(E e){
    MyLinkedList newNode = new MyLinkedList(e);
    
    if(head == null) {
        head = newNode;
    }
    else{
        MyLinkedList temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
            temp.next = newNode;
    }
}
}

public class LinkedListMain {
    public static void main(String[] args) {
        
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        System.out.println(list);
    }
}



