package com.heng.datastructure;

public class SparseArray {
    //创建一个11*11的matrix
    // 0 表示没有棋子， 1表示黑子，2表示白子
    public static void main(String[] args) {
        int[][] chessArray1 = new int [11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        for(int[] row : chessArray1) {
            for(int ele : row ){
                System.out.printf("%d\t", ele);
            }
            System.out.println();
        }
        //将原始matrix转为sparse array
        int sum = 2;
        int [][] sparseArr = new int[sum + 1] [3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int counter = 1;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(chessArray1[i][j] != 0){
                    sparseArr[counter][0] = i;
                    sparseArr[counter][1] = j;
                    sparseArr[counter][2] = chessArray1[i][j];
                    counter++;
                }
            }
        }
        System.out.println();
        for(int i = 0; i < sparseArr.length; i++){
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        //将稀疏数组恢复成原始数组
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int total = sparseArr[0][2];
        int[][]matrix = new int [row][col];
        for(int i = 1; i < sparseArr.length; i++){
            int tempR = sparseArr[i][0];
            int tempC = sparseArr[i][1];
            int value = sparseArr[i][2];
            matrix[tempR][tempC] = value;
        }
        System.out.println();
        for(int[] tempRow : matrix){
            for(int tempValue : tempRow){
                System.out.printf("%d\t",tempValue);
            }
            System.out.println();
        }
    }
}
