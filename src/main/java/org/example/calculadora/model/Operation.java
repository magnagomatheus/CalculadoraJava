package org.example.calculadora.model;

public class Operation {

    public int Soma(int a, int b) { return a + b;}

    public int Subtracao(int a, int b) { return a - b;}

    public int Multiplicacao(int a, int b) { return a * b;}

    public int Divisao(int a, int b) {
        if(b == 0) {
            System.out.println("Nao eh possivel efetuar divisao por 0.");
            return -1;
        }
        return a / b;
    }



}
