package org.example;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        new Main().run();
    }

    private void run(){

//        Scanner in = new Scanner(System.in);
//
//        double x = in.nextDouble();
//        //variant 3
//        double res = calculateFunction(x);
//        System.out.println(res);

        List<Double> resX = createArrayY(0.0,2.0,0.002);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("list.txt", StandardCharsets.UTF_8))) {
            // Write each element of the array to the file
            for (Double element : resX) {
                writer.write(String.valueOf(element));
                writer.newLine(); // Add a newline character between elements if needed
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        return (int) Math.ceil((end - start) / step)+1 ;
    }

    public List<Double> createArrayX(double start, double end, double step){

        List<Double> res = new ArrayList<>();

        int stepsAmount = stepsAmount(start,end,step);

        BigDecimal startX = BigDecimal.valueOf(start);
        for (int i = 0; i < stepsAmount; i++){
            res.add(startX.doubleValue());
            startX = startX.add(BigDecimal.valueOf(0.002));
        }

        return res;
    }

    public List<Double> createArrayY(double start, double end, double step){

        List<Double> res = new ArrayList<>();

        List<Double> arrayX = createArrayX(start,end,step);

       for (double x : arrayX){
           res.add(calculateFunction(x));
       }

        return res;
    }


}