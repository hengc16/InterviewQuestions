package com.heng.code.recursion;

public class Power {
    public double power(int a, int b){
        if (a == 0) {
            if (b <= 0) {
                return Double.MIN_VALUE;
            }
            return 0;
        }
        if (b >= 0) {
            return powerHelper(a, b);
        } else {
            return 1 / (double) powerHelper(a, -b);
        }
    }

    private int powerHelper(int a, int b) {
        if(b == 0) {
            return 1;
        }
        int half = powerHelper( a,  b / 2);
        if(b % 2 == 0) {
            return half * half;
        }else {
            return half * half * a;
        }
    }

    public static void main(String[] args) {
        Power p1 = new Power();
        double res = p1.power(2,4);
        System.out.println(res);
    }
}
