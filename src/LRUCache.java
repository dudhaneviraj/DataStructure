import java.util.HashMap;
import java.util.Scanner;

class Node{
	int data;
	public Node next;
	public Node prev;
	public Node(int data){
		this.data=data;
		this.next=null;
		this.prev=null;
	}
}

public class LRUCache {
	
	HashMap<Integer,Node> map=new HashMap<Integer,Node>();
	Node start=null;
	int maxSize;
	public LRUCache(int maxSize){
		this.maxSize=maxSize;
	}
	
	public void add(int data)
	{
		if(map.containsKey(data))
		{
			updatePosition(map.get(data));
			return;
		}
		if(map.size()>=maxSize)
		{
			deleteLeastRecentlyUsed();
		}
		Node node=new Node(data);
		map.put(data, node);
		if(start==null)
		{
			start=node;
			start.next=null;
			return;
		}
		node.next=start;
		start.prev=node;
		start=node;

	}
	
	
	public void updatePosition(Node node)
	{
		if(start==node)
			return;
		Node temp=node.prev;
		temp.next=node.next;
		if(node.next!=null)
			node.next.prev=temp;
		node.next=start;
		start.prev=node;
		node.prev=null;
		start=node;
	}
	
	public void deleteLeastRecentlyUsed()
	{
		Node temp=start;
		
		while(temp.next!=null)
			temp=temp.next;
		map.remove(temp.data);
		temp=temp.prev;
		temp.next.prev=null;
		temp.next=null;
	}
	
	public void printCache()
	{
		if(start==null)
			return;
		Node temp=start;
		System.out.println();
		while(temp!=null)
		{
			System.out.print(temp.data+"->");
			temp=temp.next;
	
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache=new LRUCache(5);
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.println("\n1. Add");
			System.out.println("2. Print Cache");
			System.out.println("3. Exit");
			System.out.println("Enter you Choice:");
			switch(scan.nextInt())
			{
				case 1:
					System.out.println("Enter Number");
					cache.add(scan.nextInt());
					break;
				case 2:
					cache.printCache();
					break;
				case 3: 
					scan.close();
					System.exit(0);
			}
		}
	}
}
