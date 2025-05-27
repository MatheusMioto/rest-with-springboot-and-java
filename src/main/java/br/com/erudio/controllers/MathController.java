package br.com.erudio.controllers;

import br.com.erudio.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2)
            throws Exception {
        if(!isNumeric(number1) || !isNumeric(number2)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        else{
            return convetToDouble(number1) + convetToDouble(number2);
        }
    }

    @RequestMapping("/mathMultiplication/{number1}/{number2}")
    public Double mathMultiplication(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2)
            throws Exception {
        if(!isNumeric(number1) || !isNumeric(number2)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        else{
            return convetToDouble(number1) * convetToDouble(number2);
        }
    }
    @RequestMapping("/mathDivision/{number1}/{number2}")
    public Double mathDivision(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2)
            throws Exception {
        if(!isNumeric(number1) || !isNumeric(number2)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        else{
            return convetToDouble(number1) / convetToDouble(number2);
        }
    }

    @RequestMapping("/mathAverage/{number1}/{number2}/{number3}")
    public Double mathAverage(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2,
            @PathVariable("number3") String number3)
            throws Exception {
        if(!isNumeric(number1) || !isNumeric(number2) || !isNumeric(number3)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        else{
            return (convetToDouble(number1) + convetToDouble(number2) + convetToDouble(number3))/3;
        }
    }

    @RequestMapping("/mathSquareRoot/{number1}")
    public Double mathSquareRoot(
            @PathVariable("number1") String number1)
            throws Exception {
        if(!isNumeric(number1) || convetToDouble(number1) == 0){
            throw new UnsupportedMathOperationException("Please set a valid numeric value!");
        }
        else{
            return Math.sqrt(convetToDouble(number1));
        }
    }


    public static Double convetToDouble(String strNum){
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
