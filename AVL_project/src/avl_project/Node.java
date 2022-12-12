package avl_project;


public class Node<Songs> {
    int key ;
    int height;
    Node left;
    Node right;
    int data;
    
    Node(int d){
        key = d;
        height = 1;
    }
}
