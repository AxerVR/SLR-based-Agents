package com.slr;

public class SLR {
    private double[][] dataSet;
    private double sumX, sumY, sumXSqr, sumXY, x;
    private int n;

    public SLR(double[][] iDataSet, double iX) {
        dataSet = iDataSet;
        x = iX;
        n = iDataSet.length;

        for(int i = 0; i < iDataSet.length; i++) {
            sumX += iDataSet[i][1];
            sumY += iDataSet[i][0];
            sumXSqr += iDataSet[i][1] * iDataSet[i][1];
            sumXY += iDataSet[i][1] * iDataSet[i][0];
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

    public double predictY() {
        return beta0() + beta1() * x;
    }

}