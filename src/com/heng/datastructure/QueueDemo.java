package com.heng.datastructure;

public class QueueDemo {


    public static void main(String[] args) {

    }

}

class QueueImp {
    private int head;
    private int tail;
    private int size;
    private int max;
    private int[] array;

    public QueueImp(int max) {
        this.max = max;
        array = new int[max];
        head = -1;
        tail = -1;
        size = 0;
    }

    //add
    public void add(int n){
        if(isEmpty()){
            throw new RuntimeException("empty queue");
        }
        if(size == max){
            System.out.println("is full");
            return;
        }
        head++;
        array[head] = n;
        size++;
        tail++;
    }
    //delete
    public void delete(){
        if(isEmpty()){
            throw new RuntimeException("empty queue");
        }
        if(size == 1){

        }
    }
    //peek

    //size
    public int getSize(){
        return this.size;
    }
    //show
    //isEmpty
    public boolean isEmpty(){
        return size == 0;
    }
}


