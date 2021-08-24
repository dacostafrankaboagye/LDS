// Doubly Linked List

import java.util.List;
import java.util.NoSuchElementException;

public class DLL{
    private ListNode head;
    private ListNode tail;
    private int length;

    private static class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data){this.data = data;}

    }

    public DLL(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    void displayfd(){
        if(head == null){return;}
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    void displaybk(){
        if(head == null){return;}
        ListNode current = tail;
        while(current != null){
            System.out.print(current.data +" ---> ");
            current = current.previous;
        }
        System.out.println("null");
    }

    void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        if(isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){head = newNode;}
        else{
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    /*
    private boolean isValidIndex(int index) {
        return index >= 0 && index <= length;
    }

    public void insertAtIndex(int value, int index) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException("Index " + index + " not valid");
        }
        ListNode newNode = new ListNode(value);
        ListNode current = head;

        if (index == 0) {
            insertFirst(value);
        } else if (index == length) {
            insertLast(value);
        } else {
            for (int j = 0; j < index; j++) {
                current = current.next;
            }
            newNode.next = current;
            current.previous.next = newNode;
            newNode.previous = current.previous;
            current.previous = newNode;
            length++;
        }
    }

     */

    public boolean isValidIndex(int index){
        return index >=0 && index <=length;
    }

    void insertAtIndex(int value, int index){
        if(!isValidIndex(index)){
            throw new IndexOutOfBoundsException("The index is not valid");
        }
        if(index == 0){insertFirst(value);}
        if(index == length){insertLast(value);}
        else{
            ListNode current = head;
            ListNode newNode = new ListNode(value);
            for(int i=0; i <index; i++){ current = current.next;}
            newNode.next = current;
            current.previous.next = newNode;
            newNode.previous = current.previous;
            current.previous = newNode;
        }
    }

    public ListNode deleteFirst(){
        if(isEmpty()){throw new NoSuchElementException();}
        ListNode temp = head;
        if(head == tail){tail = null;}
        else{
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode deleteLast(){
        if(isEmpty()){throw new NoSuchElementException();}
        ListNode temp = tail;
        if(tail == head){head =null;}
        else{
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;

    }

    /*
    public ListNode deleteAtIndex(int index){
        if(!isValidIndex(index)){throw new IndexOutOfBoundsException();}
        if(index == 0){return deleteFirst();}
        if(index == length){throw new IndexOutOfBoundsException();}
        if(index == length -1 ){return deleteLast();}
        else{
            ListNode current = head;
            for(int i=0; i <index; i++){
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
            current.next = null;
            current.previous = null;
            length--;
            return current;
        }
    }

     */ // code deleteATIndex;
    public ListNode deleteAtIndex(int index) {
        if (!isValidIndex(index + 1)) {
            throw new IndexOutOfBoundsException("Index " + index + " not valid");
        }

        ListNode current = head;
        if (index == 0) {
            return deleteFirst();
        } else if (index == length - 1) {
            return deleteLast();
        } else {
            for (int j = 0; j < index; j++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
            length--;
        }
        return current;
    }



    public static void main(String[] args){
        DLL dll = new DLL();
        dll.insertFirst(7);
        dll.insertFirst(4);
        dll.insertFirst(6);
        dll.insertFirst(9);
        dll.insertFirst(1);


        dll.displayfd();

        System.out.println("Node length is : " + dll.length());

        System.out.println("Inserting 0 @ 4th position ...");
        dll.insertAtIndex(0, 4);
        dll.displayfd();

        // deleting the first node
        System.out.println("Deleting first Node");
        dll.deleteFirst();
        dll.displayfd();

        // deleting the last element
        System.out.println("Deleting the last element...");
        dll.deleteLast();
        dll.displayfd();

        // deleting the node @ index 1
        DLL dll2 = new DLL();
        int[] nodeArray = {11, 10, 8, 15, 9, 1};
        for(int i: nodeArray){
            dll2.insertLast(i);
        }
        System.out.println("\nLoading New Node..\n");
        dll2.displayfd();
        //test
        dll2.deleteAtIndex(0); dll2.displayfd();
        dll2.deleteAtIndex(2); dll2.displayfd();
        dll2.deleteAtIndex(3); dll2.displayfd();
        dll2.deleteAtIndex(2); dll2.displayfd();
        dll2.deleteAtIndex(1); dll2.displayfd();
    }
    
}
