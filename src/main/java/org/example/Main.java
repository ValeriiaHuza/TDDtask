package org.example;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
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
            for (Double element : resX) {
                writer.write(String.valueOf(element));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //task 3
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

    //task 4
    public int stepsAmount(double start, double end, double step){
        return (int) Math.ceil((end - start) / step)+1 ;
    }

    //task 5
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

    //task 5
    public List<Double> createArrayY(double start, double end, double step){

        List<Double> res = new ArrayList<>();

        List<Double> arrayX = createArrayX(start,end,step);

       for (double x : arrayX){
           res.add(calculateFunction(x));
       }

        return res;
    }

    //task 6
    public int findMaxIndex(List<Double> array){
        double max = findMax(array);
        return array.indexOf(max);
    }

    public double findMax(List<Double> array){
        return array.stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .getAsDouble();
    }

    //task 6
    public int findMinIndex(List<Double> array){
        double min = findMin(array);
        return array.indexOf(min);
    }

    public double findMin(List<Double> array){

        return array.stream()
                .mapToDouble(Double::doubleValue)
                .min()
                .getAsDouble();
    }

    //task 6
    public double findSum(List<Double> array){
        return array.stream().mapToDouble(Double::doubleValue).sum();
    }

    //task 6
    public double findAverage(List<Double> array){
        return array.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
    }

    //task 7
    public void printArrayElement(int elementIndex, List<Double> array){
        System.out.print(array.get(elementIndex));
    }

}