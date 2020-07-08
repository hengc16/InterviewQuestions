package com.heng.code.recursion;

public class NQueen {
    private int n;
    private int[] array;
    public NQueen(int n) {
        this.n = n;
        array = new int[n];
    }
    public void getResult(int index){
        if(index == n){
            print();
            return;
        }
        for(int i = 0; i < n; i++) {
            if(isValid(i, index)){
                array[index] = i;
                getResult(index + 1);
            }
        }
    }
    public boolean isValid(int col, int row){
        for(int row1 = 0; row1 < row; row1++){
            int col1 = array[row1];
            if(col1 == col || Math.abs(col1 - col) == Math.abs(row1 - row)){
                return false;
            }
        }
        return true;
    }
    private void print(){
        for(int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        NQueen nQueen = new NQueen(8);
        nQueen.getResult(0);

    }

}
