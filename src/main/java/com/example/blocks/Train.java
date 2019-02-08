package com.example.blocks;

import java.io.Serializable;
import java.util.Random;

public class Train implements Serializable {
    protected Carrige root;
    //private int sizeUnique = 0;

    public Train(int numberOfCarriges) {
        if (numberOfCarriges <= 0) {
            root = null;
        } else {
            Random rand = new Random();
            for (int i = 0; i < numberOfCarriges; i++) {
                this.insert(rand.nextBoolean());
            }
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Carrige getRoot(){
        return root;
    }

    // Function to insert element at beginning
    public void insertAtRoot(boolean val) {
        Carrige nptr = new Carrige(val, null, null);

        if (root == null) {
            root = nptr;
            root.setLinkNext(root);
            root.setLinkPrev(root);
        } else {
            root.setLinkNext(nptr);
            nptr.setLinkPrev(root);
            nptr.setLinkNext(root);
            root.setLinkPrev(nptr);
        }
        //sizeUnique++;
    }

    public void insert(boolean val) {
        Carrige nptr = new Carrige(val, null, null);

        if (root == null) {
            insertAtRoot(val);
            return;
        } else if (root.getLinkPrev() == null || root.getLinkNext() == null){
            insertAtRoot(val);
            return;
        }

        Carrige ptr = root;
        Carrige tmp = ptr.getLinkNext();
        ptr.setLinkNext(nptr);
        nptr.setLinkPrev(ptr);
        nptr.setLinkNext(tmp);
        tmp.setLinkPrev(nptr);
        //sizeUnique++;
    }

    public void displaySomeCarriges(int value) {
        if (root != null) {
            int temp = 0;
            System.out.println(root.getLight());
            Carrige ptr = root.getLinkNext();

            while (temp < value - 1) {
                System.out.println(ptr.getLight());
                ptr = ptr.getLinkNext();
                temp++;
            }
        }
    }
}