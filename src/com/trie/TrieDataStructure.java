package com.trie;

import java.util.LinkedList;
import java.util.Scanner;

class Node
{
	char content;
	LinkedList<Node> child;
	boolean isWord;
	int wordCount;
	
	public Node(char content)
	{
		this.content=content;
		child=new LinkedList<>();
	}
	
	public Node subNode(char content)
	{
		if(child==null || child.size()==0)
			return null;
		for(Node temp: child)
		{
			if(temp.content==content)
				return temp;
		}
		return null;
	}
}

public class TrieDataStructure {
	
	class Node
	{
		char content;
		LinkedList<Node> child;
		boolean isWord;
		int wordCount;
		
		public Node(char content)
		{
			this.content=content;
			child=new LinkedList<>();
		}
		
		public Node subNode(char content)
		{
			if(child==null || child.size()==0)
				return null;
			for(Node temp: child)
			{
				if(temp.content==content)
					return temp;
			}
			return null;
		}
	}

	
	
	
	
	
	
	
	
	
	
	Node root;
	public void insert(String word)
	{
		if(word==null || word.length()==0 || search(word))
			return;
		if(root==null)
			root=new Node(' ');
		Node current=root;
		
		for(char content: word.toCharArray())
		{
			if(current.subNode(content)==null)
				current.child.add(new Node(content));
			
			current=current.subNode(content);
			current.wordCount++;
		}
		current.isWord=true;
	}
	
	public void delete(String word)
	{
		if(root==null || !search(word))
			return;
		Node current=root;
		for(char content:word.toCharArray())
		{
			if(current.subNode(content).wordCount==1)
			{	
				current.child.remove(current.subNode(content));
				return;
			}
			current=current.subNode(content);
			current.wordCount--;
		}
		current.isWord=false;
	}
	
	
	
	public boolean search(String word)
	{
		if(root==null || word==null || word.length()==0)
			return false;
		Node current=root;
		for(char content: word.toCharArray())
		{
			if(current.subNode(content)==null)
				return false;
			current=current.subNode(content);
		}
		if(current.isWord)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);		
		TrieDataStructure trie=new TrieDataStructure();
		while(true)
		{
			System.out.println("1. Add\n2. Search\n3. Delete\n4. Exit\nEnter Your Choice:");
			switch(s.nextInt())
			{
				case 1:
						System.out.println("Enter Your Word:");
						trie.insert(s.next());
						break;
				case 2:
						System.out.println("Enter Your Word:");
						System.out.println(trie.search(s.next()));
						break;
				case 3:	
						System.out.println("Enter Your Word:");
						trie.delete(s.next());
						break;
				case 4:
						s.close();
						System.exit(0);
			}
		}
	}

}
