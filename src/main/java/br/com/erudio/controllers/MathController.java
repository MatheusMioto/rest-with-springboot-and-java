package br.com.erudio.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new IllegalArgumentException();
        }
        else{
            return convetToDouble(numberOne) + convetToDouble(numberTwo);
        }
    }

    private Double convetToDouble(String numberOne){
            return 1D;
    }

    private boolean isNumeric(String strNum) {
        String number = strNum.replace(",", ".");
        if (strNum == null || strNum.isEmpty()){
            return false;
        }
        else if (number.matches("[-+]?[0-9]*\\.?[0-9]+")){
            return true;
        }else{
            return false;
        }
    }

}
