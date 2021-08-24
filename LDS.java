// singly linked list

public class LDS{
    private ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    int nodeLength(){
        ListNode current = head;
        if(current == null)
            return 0;
        int count = 0;
        while(current != null){
            count ++;
            current = current.next;
        }
        return count;
    }

    void insertFirst(int value){
        ListNode newValue = new ListNode(value);
        newValue.next = head;
        head = newValue;
    }

    void insertLast(int value){
        ListNode newValue = new ListNode(value);
        if(head == null){
            head = newValue;
            return;
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }

        current.next = newValue;

    }

    ListNode deleteFirst(){
        ListNode errorNode = new ListNode(-1);

        if(head == null)
            return errorNode;

        ListNode current = head;
        head = current.next;
        current.next = null;
        return current;

        /*

        ListNode current = head;
        head = head.next;
        current.next = null;
        return current;

         */
    }

    ListNode deleteLast(){
        ListNode errorNode = new ListNode(-1);
        if(head ==null) return errorNode;
        if(head.next == null) return head;
        ListNode current = head;
        ListNode previous = null;
        while(current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;

    }

    boolean checkFor(int value){
        if(head == null){return false;}

        ListNode current = head;
        while(current != null){
            if(current.data == value)
                return true;
            current = current.next;
        }
        return false;

    }

    ListNode reverseNode(){
        if (head == null){return head;}
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;

    }

    /*

    ListNode middleNode(){
        int nodeLen = nodeLength();

        int counter = 1;
        ListNode current = head;
        int midValue = 0;
        if(nodeLen % 2 == 0){midValue = (nodeLen / 2) + 1;}
        if(nodeLen % 2 == 1){midValue = (nodeLen + 1) / 2;}
        while(counter != midValue){
            current = current.next;
            counter++;
        }
        return current;
    }

     */  // middleNode [other code]
    ListNode middleNode(){
        ListNode current = head;
        ListNode fastPtr = current;
        ListNode slowPtr = current;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    /*

    ListNode findNthNode_end(int nth_num){
        ListNode nodeError = new ListNode(-1);
        if(nth_num > nodeLength() || nth_num < 1){return nodeError;}
        ListNode fromEnd = reverseNode();
        ListNode current = fromEnd;
        int counter = 1;
        while(counter != nth_num){
            current = current.next;
            counter++;
        }
        return current;

    }

     */  // nth node from the end [other code]
    ListNode findNthNode_end(int nth_num){
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while(count < nth_num){
            refPtr =    refPtr.next;
            count++;
        }
        while(refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }
    
    void removeDuplicateFromSorted(){
        ListNode current = head;
        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }
    }

    ListNode insertNodeInSorted(int value){
        ListNode newNode = new ListNode(value);
        ListNode current = head;
        ListNode temp = current;
        while(current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    /*
    ListNode removeKeyNode(int value){
        ListNode errorNode = new ListNode(-1);
        boolean checkNode = checkFor(value);
        if(checkNode == true){
            ListNode theNode = new ListNode(value);
            ListNode current = head;
            ListNode temp = current;
            while(current != null && current.data != theNode.data){
                temp = current;
                current = current.next;
            }
            temp.next = current.next;
            return head;
        }
        else{return errorNode;}
    }

     */ // removing key node [other code]
    void removeKeyNode(int value){
        ListNode current = head;
        ListNode temp = null;

        while(current != null && current.data != value){
            temp = current;
            current = current.next;
        }
        if(current == null) return;
        temp.next = current.next;

    }



    public static void main(String[] args){
        LDS sll = new LDS();

        sll.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);

        // linking them
        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        //printing out
        sll.display();
        System.out.println("Node length is " + sll.nodeLength());

        // insert 0 first;
        sll.insertFirst(0);
        System.out.println("Inserted 0 first: "); sll.display();

        // insert 99 last
        sll.insertLast(99);
        System.out.println("Inserted 99 last: "); sll.display();

        // delete the first Node
        System.out.println("Deleting the fist Node : " + sll.deleteFirst().data);
            // printing the structure now
        sll.display();

        // deleting last Node
        System.out.println("Deleting the last Node : " + sll.deleteLast().data );
            //printing the structure now
        sll.display();

        // check for 30;
        System.out.println("Checking for 30... : ");
        System.out.println(sll.checkFor(30));

        // reverse the Node
        sll.display();
        System.out.println("Reversing the Node");
        sll.head = sll.reverseNode();
        sll.display();

        // finding middle node
        System.out.println("The middle node is " + sll.middleNode().data);

        // finding the third number from the end;
        sll.insertFirst(50);
        sll.insertFirst(60);
        sll.display(); // displaying the node structure;
                // finding the 3rd number from the end
        System.out.println("The third number from the end is: " +  sll.findNthNode_end(3).data);

        // removing duplicates from sorted node say : 3 -> 5 -> 5 -> 10 -> 10 -> 10 -> 20
        int theNodeLength = sll.nodeLength();
        for(int i =0; i < theNodeLength; i++){
            sll.deleteFirst();
        }
        int[] srtN = {3, 5, 5, 10, 10, 10, 20};
        for(int i : srtN){
            sll.insertFirst(i);
        }
            // displaying the sorted Node
        sll.head = sll.reverseNode();
        sll.display();
            // remove the duplicate;
        System.out.println("Removing the duplicates...");
        sll.removeDuplicateFromSorted(); sll.display();

        // Inserting node in a sorted linked Node
            // insert 15
        sll.head = sll.insertNodeInSorted(15);
        System.out.println("Inserting 15 into the sorted Node...");
        sll.display();

        // Removing a key Node
            // the node structure now: 3 --> 5 --> 10 --> 15 --> 20 --> null
                // removing 5
        sll.removeKeyNode(5);
        System.out.println("Removing 5 from the Linked Node...");
        sll.display();



    }

}

