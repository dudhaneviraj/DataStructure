package com.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Node{
	int content;
	Node left;
	Node right;
	
	Node(int content)
	{
		this.content=content;
	}
}

class Int{
	int index;
	Int(int index){
		this.index=index;
	}
	public void setIndex(int index){
		this.index=index;
	}
	public int getIndex(){
		return index;
	}
}
public class BinaryTree {
	Node root;
	public void insert(int content)
	{
		Node input=new Node(content);
		if(root==null)
		{
			root=input;
			return;
		}
		Node temp=root;
		while(true)
		{
			if(content>temp.content)
			{
				if(temp.right==null)
				{
					temp.right=input;
					return;
				}
				temp=temp.right;
				continue;
			}
			if(temp.content>content)
			{
				if(temp.left==null)
				{
					temp.left=input;
					return;
				}
				temp=temp.left;
				continue;
			}
			return;
		}
		
	}
	
	
	
	public int getDiameter(Node root)
	{
		if(root==null)
			return 0;
		int rootDiameter=getHeight(root.left)+getHeight(root.right)+1;
		return Math.max(rootDiameter, Math.max(getDiameter(root.left), getDiameter(root.right)));
	}
	
	public int getHeight(Node root)
	{
		if(root==null)
			return 0;
		return Math.max(getHeight(root.left),getHeight(root.right))+1;
	}
	
	
	
	
	
	public int closestvalue(Node root,int v)
	{
		if(root==null)
			return Integer.MAX_VALUE;
		int diff=root.content-v;
		int tempDiff=closestvalue(root.left, v);
		if(Math.abs(diff)>Math.abs(tempDiff))
			diff=tempDiff;
		tempDiff=closestvalue(root.right, v);
		if(Math.abs(diff)>Math.abs(tempDiff))
			diff=tempDiff;
		return diff;
	}
	
	
	public int minValue(Node root)
	{
		if(root.left==null)
			return root.content;
		else
			return minValue(root.left);
	}
	
	Node buildTreeFromInPre(int[] in,int[]pre,Int preIndex,int inStart,int inEnd)
	{
		if(inStart>inEnd)
			return null;
		Node node=new Node(pre[preIndex.getIndex()]);
		preIndex.setIndex(preIndex.getIndex()+1);
		if(inStart==inEnd)
			return node;

		int inIndex=search(in, inStart, inEnd, node.content);
		node.left=buildTreeFromInPre(in, pre, preIndex, inStart, inIndex-1);
		node.right=buildTreeFromInPre(in, pre, preIndex, inIndex+1, inEnd);
		return node;
	}
	

	
	Node buildTreeFromInPre(int[] in,int[]pre,int preIndex,int inStart,int inEnd)
	{
		if(inStart>inEnd)
			return null;
		Node node=new Node(pre[preIndex++]);
		if(inStart==inEnd)
			return node;

		int inIndex=search(in, inStart, inEnd, node.content);
		node.left=buildTreeFromInPre(in, pre, preIndex, inStart, inIndex-1);
		preIndex=preIndex+(inIndex-inStart);
		node.right=buildTreeFromInPre(in, pre, preIndex, inIndex+1, inEnd);
		return node;
	}
	
	
	
	public int search(int[] in,int inStart,int inEnd,int value)
	{
		for(int i=inStart;i<=inEnd;i++)
			if(in[i]==value)
				return i;
		return -1;
	}
	
	
	
	public Node BtreePost(int[] in, int[] post,int inStart,int inEnd,int postStart,int postEnd)
	{
		if(inEnd<inStart || postEnd<postStart)
			return null;
		Node node=new Node(post[postEnd]);
		int inIndex=search(in, inStart, inEnd, node.content);
		
		node.left=BtreePost(in, post, inStart, inIndex-1, postStart, postStart+ inIndex-(inStart+1));
		node.right=BtreePost(in, post, inIndex+1, inEnd, postStart+inIndex-inStart, postEnd-1);
		return node;
	}
	

	
	public Node buildTreeFromInPost(int[] inorder, int inStart, int inEnd,
			int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;
		Node root = new Node(postorder[postEnd]);
		int inIndex = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == root.content) {
				inIndex = i;
				break;
			}
		}
		root.left = buildTreeFromInPost(inorder, inStart, inIndex - 1, postorder,
										postStart,postStart + inIndex - (inStart + 1));
		root.right = buildTreeFromInPost(inorder, inIndex + 1, inEnd, postorder,
										postStart + inIndex- inStart, postEnd - 1);
		return root;
	}
	public void inOrder(Node root)
	{
		if(root==null)
			return;
		
		inOrder(root.left);
		System.out.print(root.content+"->");
		inOrder(root.right);
	}	


		
	public void inOrderIterative(Node root)
	{
		Stack<Node> stack=new Stack<>();
		Node temp=root;
		while(!stack.isEmpty() || temp!=null)
		{
			if(temp!=null)
			{
				stack.push(temp);
				temp=temp.left;
			}
			else
			{
				temp=stack.pop();
				System.out.print(temp.content+"->");
				temp=temp.right;
			}
		}
	}
	
	
	public void inoo(Node root)
	{
		if(root==null)
			return;
		Stack<Node> stack=new Stack<>();
		Node temp=root;
		while(!stack.isEmpty() || temp!=null)
		{
			if(temp!=null)
			{
				stack.push(temp);
				temp=temp.left;
			}
			else
			{
			 temp=stack.pop();
			 System.out.print(temp.content+"->");
			 temp=temp.right;
			}
			
			
		}
	}

	public void preOrder(Node root)
	{
		if(root==null)
			return;
		System.out.print(root.content+"->");
		preOrder(root.left);
		preOrder(root.right);
	}	
	
	public void preOrderIterative(Node root)
	{
		Stack<Node> stack=new Stack<>();
		if(root==null)
			return;
		Node temp;
		stack.push(root);
		while(!stack.isEmpty())
		{
			temp=stack.pop();	
			System.out.print(temp.content+"->");
			if(temp.right!=null)
				stack.push(temp.right);
			if(temp.left!=null)
				stack.push(temp.left);
		}	
	}
	
	public void postOrder(Node root)
	{
		if(root==null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.content+"->");

	}	
	
	public void postOrderIterative(Node root)
	{
		if(root==null)
			return;
		Stack<Node> stack=new Stack<>();
		
		do {
			while(root!=null)
			{
				if(root.right!=null)
					stack.push(root.right);
				stack.push(root);
				root=root.left;
			}
			root=stack.pop();
			
			if(root.right!=null && !stack.isEmpty() && stack.peek()==root.right)
			{
				stack.pop();
				stack.push(root);
				root=root.right;
			}
			else
			{
				System.out.print(root.content+"->");
				root=null;
			}
			
		} while (!stack.isEmpty());
	}
	
	public  void depthFirstSearch(Stack<Node> stack){
 
        if (stack.isEmpty()) return;
 
        Node node = (Node)stack.pop();
 
        System.out.println ("popping node: " + node.content);
 
        if (node.right!=null) stack.push(node.right);
 
        if (node.left!=null) stack.push(node.left);
 
        depthFirstSearch (stack);

	}
	
	public  void breadthFirstSearch (Queue<Node> queue)
	{  
        if (queue.isEmpty()) return;
 
        Node node = (Node)queue.poll();
 
        System.out.println ("polling node: " + node.content);
 
        if (node.right!=null) queue.offer(node.right);
 
        if (node.left!=null) queue.offer(node.left);
 
        breadthFirstSearch (queue);
    }
  
	public void inorder(Queue<Node> queue,Node root)
	{
		if(root==null)
			return;
		inorder(queue,root.left);
		queue.add(root);
		inorder(queue,root.right);
	}
	public int getHt(Node root)
	{
		if(root ==null)
			return 0;
		return Math.max(getHt(root.left), getHt(root.right))+1;
	}
	
	
	public int getDMT(Node root)
	{
		if(root==null)
			return 0;
		int rootHeight=getHt(root.left)+getHeight(root.right)+1;
		return Math.max(Math.max(getHeight(root.left), getHt(root.right)),rootHeight);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		BinaryTree bst=new BinaryTree();
		while(true)
		{
			System.out.println("\n1. Insert");
			System.out.println("2. Preorder");
			System.out.println("3. Height");
			System.out.println("4. Diameter");
			System.out.println("5. Closest Value");
			System.out.println("6. Build Tree From Inorder And Preorder");
			System.out.println("7. Build Tree From Inorder And PostOrder");
			System.out.println("8. Breadth First Search");
			System.out.println("9. Depth First Search");
			System.out.println("8. Exit");
			System.out.println("Enter Your Choice:");
			switch(s.nextInt())
			{
				case 1: 
						bst.insert(5);
						bst.insert(3);
						bst.insert(2);
						bst.insert(4);
						bst.insert(7);
						bst.insert(6);
						bst.insert(8);
						//System.out.println("Enter Data:");
						//bst.insert(s.nextInt());
						break;
				case 2:
						System.out.print("\nInorder:");
						bst.inOrder(bst.root);
						System.out.print("\nInorder Iterative:");
						bst.inOrderIterative(bst.root);
						System.out.print("\nPreorder:");
						bst.preOrder(bst.root);
						System.out.print("\nPreOrder Iterative:");
						bst.preOrderIterative(bst.root);
						System.out.print("\nPostorder:");
						bst.postOrder(bst.root);
						System.out.print("\nPostOrder Iterative:");
						bst.postOrderIterative(bst.root);
						break;
				case 3:	
						System.out.println(bst.getHeight(bst.root));
						break;
				case 4:
						System.out.println(bst.getDiameter(bst.root));
						break;
				case 5:
						System.out.println("EnterValue");
						int val=s.nextInt();
						System.out.println(val+bst.closestvalue(bst.root, val));
						break;
				case 6:
						int[] pre=new int[]{4,3,1,2,5,6};
						int[] in=new int[]{1,2,3,4,5,6};
						bst.root=bst.buildTreeFromInPre(in, pre, 0, in.length-1,0);
						break;
						
				case 7:int[] postOrder=new int[]{1,2,3,6,5,4};
					   int[] inOrder=new int[]{1,2,3,4,5,6};
					   bst.root=bst.buildTreeFromInPost(inOrder, 0, inOrder.length-1,postOrder, 0, postOrder.length-1);
					   break;
				case 8:
						Queue<Node> queue= new LinkedList<>();
						queue.add(bst.root);
						bst.breadthFirstSearch(queue);					
						break;
				case 9:
						Stack<Node> stack =new Stack<>();
						stack.push(bst.root);
						bst.depthFirstSearch(stack);
						break;
				case 10:					
						s.close();
						System.exit(0);
			}
		}
	}

}
