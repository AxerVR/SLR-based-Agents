package com.slr;

public class SLR {
    private double sumX, sumY, sumXSqr, sumXY;
    private int n;

    public SLR(double[][] dataSet) {
        n = dataSet.length;

        for(int i = 0; i < dataSet.length; i++) {
            sumX += dataSet[i][1];
            sumY += dataSet[i][0];
            sumXSqr += dataSet[i][1] * dataSet[i][1];
            sumXY += dataSet[i][1] * dataSet[i][0];
        }
    }


    public double beta0(){
        return (sumXSqr * sumY - sumX * sumXY) /
                (n * sumXSqr - Math.pow(sumX, 2));
    }
    public double beta1(){
        return (n * sumXY - sumX * sumY) /
                (n * sumXSqr - Math.pow(sumX, 2));
	}

    public double predictY(double x) {
        return beta0() + beta1() * x;
    }

}
