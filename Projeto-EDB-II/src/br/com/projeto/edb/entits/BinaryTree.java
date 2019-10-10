package br.com.projeto.edb.entits;

import java.io.*;
import java.util.*;

public class BinaryTree {
    private Node[] tree;
    private int size;
    private int capacity;


    //Constructor
    public BinaryTree() {
        this(10);
    }

    public BinaryTree(int capacity){
        this.tree = new Node[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    //Getter's


    public Node[] getTree() {
        return tree;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }


    //Methods

    public void insert(Node pessoa) {
        ensureCapacity();
        tree[getSize()] = pessoa;
        heapifyUp(getSize());
        size++;
    }

    private void ensureCapacity() {
        if (this.size == this.capacity) {
            this.tree = Arrays.copyOf(this.tree, this.capacity * 2);
            this.capacity = this.capacity * 2;
        }
    }

    public int getParentIndex(int index) {
        return (int) Math.floor((index - 1) / 2);
    }

    public Node peek() {
        if (getSize() == 0) {
            return null;
        }
        return this.tree[0];
    }

    public void remove() {
        tree[0] = tree[getSize() - 1];
        tree[getSize() - 1] = null;
        size--;
        heapifyDown(0);
    }

    private void heapifyUp(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex < 0) {
            return;
        }

        Node pai    = this.tree[parentIndex];
        Node pessoa = this.tree[index];

        if (pessoa.getCount() < pai.getCount()) {
            this.tree[index]   = pai;
            this.tree[parentIndex] = pessoa;
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        int childIndex = -1;
        if (leftChild < getSize()) {
            childIndex = leftChild;
        }

        if (childIndex == -1) {
            return;
        }

        if (rightChild < getSize()) {
            if (this.tree[rightChild].getCount() < this.tree[leftChild].getCount()) {
                childIndex = rightChild;
            }
        }

        if (this.tree[index].getCount() > this.tree[childIndex].getCount()) {
            Node tmp          = this.tree[index];
            this.tree[index]      = this.tree[childIndex];
            this.tree[childIndex] = tmp;
            heapifyDown(childIndex);
        }
    }

    public String toString(){
        StringBuffer str = new StringBuffer();
        for (Node node: tree ) {
            str.append(node + "\n");
        }

        return str.toString();
    }
}
