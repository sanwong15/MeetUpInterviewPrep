import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Implement a circular linked listed with that when you insert a new element, it keep it sorted
 */
public class circularLinkedListSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		simpleCLL list = new simpleCLL();
		list.insertAtStart(1);
		list.display();
		System.out.println(list.size);
		list.insertAtEnd(2);
		list.display();
		System.out.println(list.size);
		list.insertAtEnd(3);
		list.display();
		System.out.println(list.size);
		list.insertAtEnd(4);
		list.display();
		System.out.println(list.size);
		list.deleteAtPos(1);
		list.display();
		System.out.println(list.size);
		list.insertAtStart(1);
		list.display();
		System.out.println(list.size);
		list.deleteAtPos(2);
		list.display();
		System.out.println(list.size);
		list.insertAtPos(2, 2);
		list.display();
		System.out.println(list.size);

	}

}

class SingleNode{
	protected int data;
	protected SingleNode next;
	
	//Constructor
	public SingleNode(){
		data = 0;
		next = null;
	}

	public SingleNode(int d, SingleNode n){
		data = d;
		next = n;
	}
	
	public void setLink(SingleNode n){
		next = n;
	}
	
	public void setData(int d){
		data = d;
	}
	
	public SingleNode getLink(){
		return next;
	}
	
	public int getData(){
		return data;
	}
}

class simpleCLL{
	protected SingleNode head;
	protected SingleNode tail;
	public int size;
	
	//Constructor
	public simpleCLL(){
		head = null;
		tail = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public int getSize(){
		return size;
	}
	
	public void insertAtStart(int val){
		SingleNode nodeToInsert = new SingleNode(val, null);
		nodeToInsert.setLink(head);
		
		if (head == null){
			head = nodeToInsert;
			nodeToInsert.setLink(head);
			tail = head;
		}else{
			tail.setLink(nodeToInsert);
			head = nodeToInsert;
		}
		size++;
	}
	
	public void insertAtEnd(int val){
		SingleNode nodeToInsert = new SingleNode(val, null);
		nodeToInsert.setLink(head);
		if (head == null){
			head = nodeToInsert;
			nodeToInsert.setLink(head);
			tail = nodeToInsert;
		}else{
			tail.setLink(nodeToInsert);
			tail = nodeToInsert; 
		}
		size++;
	}
	
	public void insertAtPos(int val, int pos){
		SingleNode nodeToInsert = new SingleNode(val,null);
		//Travel through the LinkedList to find where to insert it
		SingleNode current = head;
		pos = pos - 1;
		for (int i=1; i<size-1; i++){
			if (i==pos){
				SingleNode temp = current.getLink();
				current.setLink(nodeToInsert);
				nodeToInsert.setLink(temp);
				break;
			}
			//You haven't reached to where you are told to insert
			current = current.getLink();
		}
		size++;
	}
	
	public void deleteAtPos(int pos){
		if (size==1 && pos==1){
			head = null;
			tail = null;
			size = 0;
			return;
		}
		
		if(pos==1){
			head = head.getLink();
			tail.setLink(head);
			size--;
			return;
		}
		
		if(pos==size){
			SingleNode pt1 = head;
			SingleNode pt2 = head;
			while(pt2!=tail){
				pt1 = pt2;
				pt2 = pt2.getLink();
			}
			//At the point, your pt2 should be referring to the tail and pt1 is referring the the node before tail
			tail = pt1;
			tail.setLink(head);
			size--;
			return;
		}
		
		//General case:
		SingleNode current = head;
		pos = pos - 1;
		for (int i=1; i<size-1; i++){
			if (i==pos){
				SingleNode temp = current.getLink();
				temp = temp.getLink();
				current.setLink(temp);
				break;
			}
			current = current.getLink();
		}
		size--;
	}
	
	public void display(){
		SingleNode pt = head;
		if(size==0){
			System.out.println("Empty\n");
			return;
		}
		
		if(head.getLink() == head){
			System.out.print(head.getData() + "->" + pt.getData() + "\n");
			return;
		}
		
		System.out.print(head.getData() + "->");
		pt = head.getLink();
		while(pt.getLink() != head){
			System.out.print(pt.getData() + "->");
			pt = pt.getLink();
		}
		
		System.out.print(pt.getData() + "->");
		pt = pt.getLink();
        System.out.print(pt.getData()+ "\n");
	}
}
