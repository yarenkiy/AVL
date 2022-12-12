package avl_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class AVLTree {
        Node root;
      
        
        int getBalance(Node n) {
	    if (n == null)
			return 0;

		return height(n.left) - height(n.right);
	}
        int max(int a, int b) {
            if(a>b){
                return a;
            }
            else{
                return b;
            }
            
	}
        Node insert(Node node, int key) {
            if (node == null)
		return (new Node(key));

	    if (key < node.key)
		node.left = insert(node.left, key);
	    else if (key > node.key)
		node.right = insert(node.right, key);
            else 
		return node;

	    node.height = 1 + max(height(node.left), height(node.right));

            int balance = getBalance(node);
                if (balance > 1 && key < node.left.key)
		    return rightRotate(node);
            if (balance < -1 && key > node.right.key)
		    return leftRotate(node);
            if (balance > 1 && key > node.left.key) {
	        node.left = leftRotate(node.left);
		    return rightRotate(node);
		}

	    if (balance < -1 && key < node.right.key) {
		node.right = rightRotate(node.right);
		    return leftRotate(node);
		}

		return node;
	}
        Node leftRotate(Node x) {
            Node y = x.right;
            Node T2 = y.left;
                y.left = x;
		x.right = T2;

		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		return y;
	}
        Node rightRotate(Node y) {
            Node x = y.left;
	    Node T2 = x.right;
        	x.right = y;
		y.left = T2;

		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		return x;
	}

     int height(Node n) {
		if (n == null)
			return 0;

		return n.height;
	}
    private Node searchNode(int key, Node node) {
    if (node == null) {
      return null;
    }

    if (key == node.data) {
      return node;
    } else if (key < node.data) {
      return searchNode(key, node.left);
    } else {
      return searchNode(key, node.right);
    }
  }
    public static void main(String[] args) throws IOException {
        AVLTree tree = new AVLTree();
      
        String path = "C:\\Users\\PC\\Desktop\\songs.txt";
        String line ="";
        try {
            BufferedReader b = new BufferedReader(new FileReader(path));
            while((line = b.readLine()) != null){
                String [] array = line.split(";");
                System.out.println(array[0]);
                
            }
            
        } 
        catch (FileNotFoundException ex) {
           ex.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
              
        
    }
}
  
        
    

    