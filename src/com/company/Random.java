package com.company;

import java.util.Scanner;

public class Random {
    Scanner sc = new Scanner(System.in);
    int quantity;
    Node root;

    public Random() {
        System.out.println("Enter quantity of nodes");
        this.quantity = sc.nextInt();
    }

    public Node FillGraf() {
        java.util.Random r = new java.util.Random();
        String nameOfNode = "B";
        root = new Node("A");
        Node currentNode = root;

        int leftOrRight;
        int i = 0;
        while (i < quantity) {
            leftOrRight = r.nextInt(2) + 1;
            if (leftOrRight == 1) {
                if (currentNode.left == null) {
                    currentNode.left = new Node((String) nameOfNode, currentNode);
                    System.out.print(" Left - "+currentNode.left.nameNode+" \n"  );
                    System.out.println(" And his father - " + currentNode.left.parent.nameNode );
                    currentNode = root;
                    char temp = nameOfNode.charAt(0);
                    temp++;
                    nameOfNode = String.valueOf(temp);
                    i++;
                } else currentNode = currentNode.left;
            }
            if (leftOrRight == 2) {
                if (currentNode.right == null) {
                    currentNode.right = new Node(nameOfNode, currentNode);
                    System.out.print(" Right - "+currentNode.right.nameNode+" \n"  );
                    System.out.println(" And his father - " + currentNode.right.parent.nameNode );
                    currentNode = root;
                    char temp = nameOfNode.charAt(0);
                    temp++;
                    nameOfNode = String.valueOf(temp);
                    i++;
                } else currentNode = currentNode.right;
            }
        }
        return root;
    }
    }



