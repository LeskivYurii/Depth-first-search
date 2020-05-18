package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int menu;
        long ts_b, ts_e;

        Stack stack = new Stack();
        System.out.println("Enter 1 DataSet is already in program "
                +"Enter 2 for random Graf"
                +"Enter 3 read from File");
        menu = sc.nextInt();
        Node root;
        switch (menu){
            case 1 : {
                root = new Node("A");
                root.left = new Node ("B",root);
                root.right = new Node("C",root);
                root.left.left = new Node("D",root.left);
                root.left.right = new Node("E",root.left);
                root.right.left = new Node("F",root.right);
                root.right.right = new Node("G",root.right);
                root.right.left.right = new Node("K",root.right.left);
                root.right.left.right.left = new Node("L",root.right.left.right);
                stack.push(root);
                break;
            }
            case 2 : {
                Random r = new Random();
                stack.push(r.FillGraf());
                System.out.println("Enter the file's name .txt");
                sc.reset();
                String nameFile = sc.next();
                FileWriterRandomData fw = new FileWriterRandomData(r.root,nameFile);
                break;
            }
            case 3 : {
                FileNode f = new FileNode();
                try {
                    f.readFile();
                }catch (IOException E){
                    E.printStackTrace();
                }

                root = f.root;
                stack.push(root);
                break;
            }
        }
        ts_b = Calendar.getInstance().getTimeInMillis();
        System.out.println("--------------");
        while(!stack.empty()){
            Node reccuringNode = (Node) stack.pop();
            System.out.println(reccuringNode.nameNode);
            if (reccuringNode.left!=null){
                stack.push(reccuringNode.left);
            }
            if (reccuringNode.right!=null){
                stack.push(reccuringNode.right);
            }
        }
        ts_e = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time " + (ts_e - ts_b));
    }
}
