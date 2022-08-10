package com.ms.hard.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    Node root;

    // Constructors
    BinaryTree(int key) {
        root = new Node(key);
    }

    BinaryTree() {
        root = null;
    }

    //Node-Left-Right
    public void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print("\t"+root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    //Left-Node-Right
    public void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print("\t"+root.data);
        inOrder(root.right);
    }

    //Left-Right-Node
    public void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print("\t"+root.data);
    }

    public void postOrderIterative(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(!stack.isEmpty() || current!=null){
            if(current!=null){
                stack.push(current);
                current = current.left;
            }else{
                Node temp = stack.peek().right;
                if(temp==null){
                    temp = stack.pop();
                    System.out.print("\t"+temp.data);
                    while (!stack.isEmpty()&& temp==stack.peek().right){
                        temp =stack.pop();
                        System.out.print("\t"+temp.data);
                    }
                }else {
                    current=temp;
                }
            }
        }
    }
    public void inOrderIterative(Node root){
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = root;

        while(!stack.isEmpty() || temp!=null){
            if(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }else{
                temp=stack.pop();
                System.out.print("\t"+temp.data);
                temp=temp.right;
            }
        }
    }

    public void preOrderIterative(Node root){

        if(root==null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.print("\t"+temp.data);

            if(temp.right!=null){
                stack.push(temp.right);
            }

            if(temp.left!=null){
                stack.push(temp.left);
            }

        }
    }

    public void levelOrderTraversal(Node root){

        if(root==null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print("\t"+temp.data);

            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
    }

    //find maximum value in a binary tree
    public int findMax(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);

        if(left > result){
            result = left;
        }

        if(right>result){
            result = right;
        }

        return result;

    }

    public boolean isSymmetric(Node root){

        if(root == null){
            return true;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root.right);
        stack.push(root.left);
        while(!stack.isEmpty()){
            Node n1 = stack.pop();
            Node n2 = stack.pop();

            if(n1==null && n2==null){
                continue;
            }
            if(n1==null || n2==null || n1.data!=n2.data){
                return false;
            }
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }

        return true;
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // create root
        tree.root = new Node(1);

        /* following is the tree after above statement

              1
            /   \
          null  null     */

        tree.root.left = new Node(2);
        tree.root.right = new Node(9);

        /* 2 and 3 become left and right children of 1
               1
            /     \
          2        3
        /   \     /  \
      null null null null  */

        tree.root.left.left = new Node(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
        System.out.println("Pre-Order Traversal");
        tree.preOrder(tree.root);
        System.out.println("");
        tree.preOrderIterative(tree.root);

        System.out.println("\nIn-Order Traversal");
        tree.inOrder(tree.root);
        System.out.println("");
        tree.inOrderIterative(tree.root);

        System.out.println("\nPost-Order Traversal");
        tree.postOrder(tree.root);
        System.out.println("");
        tree.postOrderIterative(tree.root);

        System.out.println("\nLevel Order Traversal");
        tree.levelOrderTraversal(tree.root);

        System.out.println("\n Maximum Value in Binary Tree");
        System.out.println(tree.findMax(tree.root));
    }
}

