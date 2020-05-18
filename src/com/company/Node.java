package com.company;

public class Node {
    Node parent;
    Node left;
    Node right;
    String nameNode;

    public Node(String nameNode) {
        this.nameNode = nameNode;
    }

    public Node(Node parent, Node left, Node right, String nameNode) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.nameNode = nameNode;
    }

    public Node(String nameNode,Node parent) {
        this.parent = parent;
        this.nameNode = nameNode;
    }
}
