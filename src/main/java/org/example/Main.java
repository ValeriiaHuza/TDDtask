package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        Scanner in = new Scanner(System.in);

        double x = in.nextDouble();
        //variant 5
        double res = calculateFunction(x);
        System.out.println(res);
    }

    public double calculateFunction(double x) {

        double a = 2.7;
        double b = -0.3;
        double c = 4;

        double res = 0;

        if (x < 1.4){
            res = a * x * x + b * x + c;
        }
        else if (x == 1.4){
            res = a / x + Math.sqrt(x * x + 1);
        }
        else {
            res = ( a + b * x) / (Math.sqrt(x * x + 1));
        }

        return res;
    }

    public int stepsAmount(double start, double end, double step){
        return (int) Math.ceil((end - start) / step) ;
    }
}