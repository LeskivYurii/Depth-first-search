package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;

public class FileWriterRandomData {
    private Node root;

    public FileWriterRandomData(Node root,String name) {
        this.root = root;
        fillWriter(name);
    }

    private  void fillWriter(String nameFile){
        Stack stack = new Stack();
        try {
            FileOutputStream fr = new FileOutputStream(nameFile);
            stack.push(root);
        while(!stack.empty()){
            Node reccuringNode = (Node) stack.pop();
            if(reccuringNode.parent!=null){
                String str1 = "parent:"+reccuringNode.parent.nameNode+"\n";
                for ( int i = 0 ; i < str1.length();i++) fr.write(str1.charAt(i));
            }else{
                String str1 = "parent:null\n";
                for ( int i = 0 ; i < str1.length();i++) fr.write(str1.charAt(i));
            }
            String str2 = "name:"+reccuringNode.nameNode+"\n";
            for ( int i = 0 ; i < str2.length();i++) fr.write(str2.charAt(i));
            if(reccuringNode.parent!=null){
                if(reccuringNode.parent.left==reccuringNode){
                    fr.write('L');
                    fr.write('\n');
                }else if(reccuringNode.parent.right==reccuringNode){
                    fr.write('R');
                    fr.write('\n');
                }
            }
            if (reccuringNode.left!=null){
                stack.push(reccuringNode.left);
            }
            if (reccuringNode.right!=null){
                stack.push(reccuringNode.right);
            }
        }
        }catch (IOException E) {
            System.out.println("System hasn't found the file");
        }

    }
}
