package org.example.calculadora.model;

import org.example.calculadora.model.operation.IOperation;

public class Calc implements ICalc{

    public int calculation (IOperation operation, int value1, int value2){

        return operation.calc(value1,value2);
    }

}
