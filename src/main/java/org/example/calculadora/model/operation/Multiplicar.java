package org.example.calculadora.model.operation;

public class Multiplicar implements IOperation{

    public Multiplicar(){};
    public int calc (int value1, int value2){
        return value1 * value2;
    }
}

