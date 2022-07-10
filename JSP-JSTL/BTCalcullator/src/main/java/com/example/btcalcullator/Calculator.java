package com.example.btcalcullator;

public class Calculator {
    public static String calcultor(String operator, Double num1, Double num2){
        double result = 0;
            if(operator.equals ( "Addition" )) {
                result = num1 + num2;
            }
            if(operator.equals ( "Subtraction" )) {
                result = num1 - num2;
            }
            if(operator.equals ( "Multiplication" )) {
                result = num1 * num2;
            }
            if(operator.equals ( "Division" )) {
                if ( num2 == 0 ) {
                    throw new RuntimeException ("Lỗi chia cho số 0");
                } else {
                    result = num1 / num2;
                }
            }
        return String.valueOf ( result );
    }
}
