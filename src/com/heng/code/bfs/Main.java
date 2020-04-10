package com.heng.code.bfs;

public class Main {
    public static void main(String[] args) {
        int[] test1 =new  int[] {3,4,1,2,5};
        int k = 3;
        KsmallestInUnsortedArray ksmallestInUnsortedArray = new KsmallestInUnsortedArray();
        int [] res = new int [k];
        res = ksmallestInUnsortedArray.kSmallest(test1, k);
        System.out.println("The 3 smallest number of array 3 4 1 2 5 "  + " are: "  );
        for(int i : res) {
            System.out.print(i);
        }
    }
}
