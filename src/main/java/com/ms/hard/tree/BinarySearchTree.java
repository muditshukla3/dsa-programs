package com.ms.hard.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    Node root;
    List<Integer> inOrder = new ArrayList<>();


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
        inOrder.add(root.data);
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

    public Node insert(Node root, int value){
        if(root==null){
            root = new Node(value);
            return root;
        }

        if(value < root.data){
            root.left = insert(root.left, value);
        }else{
            root.right = insert(root.right,value);
        }

        return root;
    }

    public Node findKey(Node root, int value){

        if(root == null || root.data == value){
            return root;
        }
        if(value < root.data){
            return findKey(root.left, value);
        }else{
            return findKey(root.right, value);
        }
    }

    public boolean isValid(Node root, int min,int max){

        if(root == null){
            return true;
        }
        if(root.data <= min || root.data >= max){
            return false;
        }
        boolean left = isValid(root.left,min, root.data);
        if(left){
            return isValid(root.right, root.data, max);
        }
        return false;
    }

    public int findMinimum(Node root){
        if(root==null){
            return -1;
        }

        while(root.left!=null){
            root = root.left;
        }
        return root.data;
    }

    public int findMaxium(Node root){
        if(root==null){
            return -1;
        }

        while(root.right!=null){
            root = root.right;
        }
        return root.data;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        Node rootNode = bst.insert(bst.root, 5);
        bst.insert(rootNode, 4);
        bst.insert(rootNode, 3);
        bst.insert(rootNode, 6);
        bst.insert(rootNode, 7);
        bst.insert(rootNode, 1);

        System.out.println("In-Order Traversal");
        bst.inOrder(rootNode);

        int searchKey = 1;
        Node found = bst.findKey(rootNode, searchKey);
        if(found!=null){
            System.out.printf("\nSearch Key %s was found",searchKey);
        }else{
            System.out.printf("\nSearch Key %s was not found",searchKey);
        }

        System.out.println("\nIs valid BST ->"+bst.isValid(rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println("\n Minimum in BST is "+bst.findMinimum(rootNode));
        System.out.println("\n Maximum in BST is "+bst.findMaxium(rootNode));

        int k = 3;
        System.out.println("Finding "+k+"th largest element -> "+ bst.inOrder.get(bst.inOrder.size()-k));
    }
}
