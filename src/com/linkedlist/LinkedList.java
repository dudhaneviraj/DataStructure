package com.linkedlist;

import java.util.Scanner;

class Node
{
	int content;
	Node next;
	Node previous;

	Node(int content)
	{
		this.content=content;
	}
}
public class LinkedList {

	Node start;
	
	
	public void insert(int content,int position)
	{
		if(start==null)
		{	
			start=new Node(content);
			return;
		}
		if(position==0)
		{
			Node temp=new Node(content);
			temp.next=start;
			start=temp;
			return;
		}
		Node temp=start;
		
		while(position!=1 && temp.next!=null)
		{
			temp=temp.next;
			position--;
		}
		Node newNode=new Node(content);
		newNode.next=temp.next;
		temp.next=newNode;
	}
	
	
	public void delete(int content)
	{
		if(start==null)
			return;
		if(start.content==content)
		{
			start=start.next;
			return;
		}
		Node temp=start;
		while(temp.next!=null)
		{
			if(temp.next.content==content)
			{
				temp.next=temp.next.next;
				return;
			}
			temp=temp.next;
		}
	}


	
	public void swapNodes(int a ,int b)
	{
		Node prevA=null,prevB=null,tempA=null,tempB=null;
		Node temp=start;
		while(temp.next!=null)
		{
			if(temp.next.content==a)
				prevA=temp;
			if(temp.next.content==b)
				prevB=temp;
			temp=temp.next;
		}
		temp=start;
		while(temp!=null)
		{
			if(temp.content==a)
				tempA=temp;
			if(temp.content==b)
				tempB=temp;
			temp=temp.next;
		}

		if(tempA==null || tempB==null)
			return;
		if(prevA==null)
			start=tempB;
		else
			prevA.next=tempB;
		if(prevB==null)
			start=tempA;
		else
			prevB.next=tempA;	
		temp=tempA.next;
		tempA.next=tempB.next;
		tempB.next=temp;
	}
	
	
	
	public void display()
	{
		Node temp=start;
		while(temp!=null)
		{
			System.out.print(temp.content+"->");
			temp=temp.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		LinkedList list=new LinkedList();
		while(true)
		{
			System.out.println("1. Insert A Node");
			System.out.println("2. Display");
			System.out.println("3. Delete Node");
			System.out.println("4. Swap Nodes");
			System.out.println("5. Exit");
			System.out.println("Enter Your Choice:");
			switch(scan.nextInt())
			{
				case 1:
						System.out.println("Enter number:");
						int content=scan.nextInt();
						System.out.println("Enter position");
						list.insert(content, scan.nextInt());
						break;
				case 2:
						list.display();
						break;
				case 3:
						System.out.println("Enter Node To delete:");
						list.delete(scan.nextInt());
						break;
				case 4:
						System.out.println("Enter Number 1:");
						int a=scan.nextInt();
						System.out.println("Enter Number 2:");
						list.swapNodes(a, scan.nextInt());
						break;
				case 5:
						scan.close();
						System.exit(0);
			}	
		}	
	}

}
