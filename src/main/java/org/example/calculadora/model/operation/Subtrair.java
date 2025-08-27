package org.example.calculadora.model.operation;

public class Subtrair implements IOperation{
    public Subtrair() {};
    @Override
    public int calc(int value1, int value2) {
        return value1 - value2;
    }
}
