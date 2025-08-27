package org.example.calculadora.controller;

import org.example.calculadora.dto.RequestDTO;
import org.example.calculadora.dto.ResponseDTO;
import org.example.calculadora.model.Calc;
import org.example.calculadora.model.ICalc;
import org.example.calculadora.model.operation.*;

public class Controller {

    public ResponseDTO calc(RequestDTO requestDTO){

        if (requestDTO == null) {
            return new ResponseDTO(-999);
        }

        int result = 0;
        ICalc calc = null;

        calc = new Calc();


        IOperation operation = null;
        // APPLYING REFLECTION AQUI MAYBE

        switch (requestDTO.getOpcao()) {
            case 1:
                operation = new Somar();
                break;
            case 2:
                operation = new Subtrair();
                break;
            case 3:
                operation = new Multiplicar();
                break;
            case 4:
                operation = new Dividir();
                break;
        }
        result = calc.calculation(operation,requestDTO.getValor1(),requestDTO.getValor2());
        return new ResponseDTO(result);

    }
}