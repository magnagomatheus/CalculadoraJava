package org.example.calculadora.model;

import org.example.calculadora.model.operation.IOperation;

public interface ICalc {

    public int calculation (IOperation operation, int value1, int value2);
}
