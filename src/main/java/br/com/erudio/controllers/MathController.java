package br.com.erudio.controllers;

import br.com.erudio.exception.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {
    private SimpleMath simpleMath = new SimpleMath();

    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2)
            throws Exception {
        if(!NumberConverter.isNumeric(number1) || !NumberConverter.isNumeric(number2)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        else{
            return simpleMath.sum(NumberConverter.convertToDouble(number1), NumberConverter.convertToDouble(number2));
        }
    }

    @RequestMapping("/mathMultiplication/{number1}/{number2}")
    public Double mathMultiplication(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2)
            throws Exception {
        if(!NumberConverter.isNumeric(number1) || !NumberConverter.isNumeric(number2)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        else{
            return simpleMath.mathMultiplication(NumberConverter.convertToDouble(number1), NumberConverter.convertToDouble(number2));
        }
    }
    @RequestMapping("/mathDivision/{number1}/{number2}")
    public Double mathDivision(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2)
            throws Exception {
        if(!NumberConverter.isNumeric(number1) || !NumberConverter.isNumeric(number2)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        else{
            return simpleMath.mathDivision(NumberConverter.convertToDouble(number1), NumberConverter.convertToDouble(number2));
        }
    }

    @RequestMapping("/mathAverage/{number1}/{number2}")
    public Double mathAverage(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2)
            throws Exception {
        if(!NumberConverter.isNumeric(number1) || !NumberConverter.isNumeric(number2)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        else{
            return simpleMath.mathAverage(NumberConverter.convertToDouble(number1), NumberConverter.convertToDouble(number2));
        }
    }

    @RequestMapping("/mathSquareRoot/{number}")
    public Double mathSquareRoot(
            @PathVariable("number") String number)
            throws Exception {
        if(!NumberConverter.isNumeric(number) || NumberConverter.convertToDouble(number) == 0){
            throw new UnsupportedMathOperationException("Please set a valid numeric value!");
        }
        else{
            return simpleMath.mathSquareRoot(NumberConverter.convertToDouble(number));
        }
    }

}
