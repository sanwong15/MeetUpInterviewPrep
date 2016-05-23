/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Imlpement a Circular LinkedList and keep it sorted
 */
public class sortedCLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList testCLL = new LinkedList();
		testCLL.sortedInsert(12);
		testCLL.sortedInsert(56);
		testCLL.sortedInsert(2);
		testCLL.sortedInsert(11);
		testCLL.sortedInsert(1);
		testCLL.sortedInsert(90);
		
		testCLL.printList();
		System.out.println();
		testCLL.BetterPrint();

	}

}

class Node{
	int data;
	Node next;
	
	public Node(int d){
		data = d;
		next = null;
	}
}

class LinkedList{
	Node head;
	
	public LinkedList(){
		head = null;
	}
	
	public void sortedInsert(int data){
		Node newNode = new Node(data);
		Node current = head;
		
		//Case 1, where the LinkedList is empty
		if (current == null){
			newNode.next = newNode; //It loop around itself
			head = newNode; //Update who's head now
		}
		
		//Case 2: Have to go through the list to find the right location to add newNode
		else if(current.data >= newNode.data){
			//As your current Node is head. If even the newNode value is smaller than your head
			// You need to go the last node and update its pointer to the newNode
			
			while(current.next!=head){
				//Just a simple note: When we travel through a non-circular, we use a while loop 
				//while (current.next!=null) that wouldn't work here as it loop around to the head
				current = current.next;
			}
			
			current.next = newNode;
			newNode.next = head;
			head = newNode;
		}
		
		else{
			//Case where newNode > current
			while(current.next!=head && current.next.data < newNode.data){
				current = current.next;
			}
			
			//at this point, current.next.data > newNode.data
			//So this is the place where you insert newNode
			newNode.next = current.next;
			current.next = newNode;
		}
		
	}
	
	public void printList(){
		if(head != null){
			Node current = head;
			while(current.next!=head){
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.print(current.data);
		}
	}
	
	public void BetterPrint(){
		if(head!=null){
			Node temp = head;
			do{
				System.out.print(temp.data + " ");
				temp = temp.next;
			}while(temp!=head);
		}
	}
}