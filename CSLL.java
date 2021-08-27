
// Circular Singly Linked List


public class CSLL{
  private ListNode last;
  private int length;

  private class ListNode{
    private int data;
    private ListNode next;

    public ListNode(int data){
      this.data = data;
    }

  }

  public CSLL(){
    last = null;
    length = 0;
  }

  public int length(){
    if(last == null){return 0;}
    ListNode first = last.next;
    int counter = 0;
    while(first != last){
      counter++;
      first = first.next;
    }
    return counter+1;
  }

  public boolean isEmpty(){return length == 0;}
  

  public void createCSLL(){
    ListNode first = new ListNode(10);
    ListNode second = new ListNode(20);
    ListNode third = new ListNode(30);
    ListNode fourth  = new ListNode(40);

    // impl...
    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = first;
    
    last = fourth;

    
  }

  public void display(){
    if(last == null){return;}
    ListNode first = last.next;
    while(first != last){
      System.out.print(first.data + " --> ");
      first = first.next;
    }
    System.out.println(first.data + " ");
  }



  public static void main(String[] args){

    CSLL csll = new CSLL();
    System.out.println(csll.isEmpty());

    csll.createCSLL();
    System.out.println(csll.isEmpty());

    System.out.println("Displaying the node...");
    csll.display();

    System.out.println("Node length is : " + csll.length());

  }
}




/*

	public void insertLast(int data) {
		ListNode temp = new ListNode(data);
		if(last == null) {
			last = temp;
			last.next = last;
		} else {
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
	}

*/
