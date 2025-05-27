package br.com.erudio.request.converters;

import br.com.erudio.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static Double convertToDouble(String strNum){
        if (strNum == null || strNum.isEmpty()){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else{
            String number = strNum.replace(",", ".");
            return Double.parseDouble(number);
        }
    }

    public static boolean isNumeric(String strNum){
        if (strNum == null || strNum.isEmpty()){
            return false;
        }
        else {
            String number = strNum.replace(",", ".");
            return number.matches("[-+]?[0-9]*\\.?[0-9]+");
        }
    }
}
