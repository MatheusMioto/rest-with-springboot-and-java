package br.com.erudio.math;

public class SimpleMath {

    public Double sum(Double number1, Double number2){
            return number1 + number2;
    }

    public Double mathMultiplication(Double number1, Double number2) {
            return number1 * number2;
    }

    public Double mathDivision(Double number1, Double number2) {
            return number1 / number2;
    }

    public Double mathAverage(Double number1, Double number2) {
            return (number1 + number2)/2;
    }

    public Double mathSquareRoot(Double number) {
            return Math.sqrt(number);
        }
}
