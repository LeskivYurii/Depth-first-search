package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class FileNode {
    Node root;
    public void readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file's name .txt");
        String fileName = sc.nextLine();
        sc.close();
        String arr;
        FileReader f = new FileReader(fileName);
        Scanner fileReader = new Scanner(f);
        arr =  fileReader.next();
        int a = arr.indexOf(':');
        String parent = arr.substring(a+1,arr.length());
        arr = fileReader.next();
        a = arr.indexOf(':');
        String name = arr.substring(a+1,arr.length());
        if(parent.equalsIgnoreCase("null")) {
            root = new Node(name, null);
        }
        while(fileReader.hasNext()){
           arr =  fileReader.next();
           a = arr.indexOf(':');
           parent = arr.substring(a+1,arr.length());
           arr = fileReader.next();
           a = arr.indexOf(':');
           name = arr.substring(a+1,arr.length());
           arr = fileReader.next();
           String leftOrRight = arr;



           Node tempNode = findNode(parent);
           if (leftOrRight.equalsIgnoreCase("l")){
               tempNode.left = new Node(name, tempNode);
           }
           if (leftOrRight.equalsIgnoreCase("r")){

               tempNode.right = new Node(name, tempNode);
           }
                }
            try {
                fileReader.close();
                f.close();
            }catch (IOException E) {
                E.printStackTrace();
            }
            }



        private  Node findNode(String name) {
            Stack stack = new Stack();
            stack.push(root);
            while(!stack.empty()){
                Node reccuringNode = (Node) stack.pop();
                if(reccuringNode.nameNode.equals(name)) {
                    return reccuringNode;
                }
                if (reccuringNode.left!=null){
                    stack.push(reccuringNode.left);
                }
                if (reccuringNode.right!=null){
                    stack.push(reccuringNode.right);
                }
            }
            return null;
        }
    }

