package org.example.calculadora.view;

import org.example.calculadora.dto.RequestDTO;
import org.example.calculadora.dto.ResponseDTO;
import org.example.calculadora.model.Operation;

import java.lang.reflect.Method;
import java.util.Scanner;



public class Menu {


    public RequestDTO show(){
        do {
            this.showMenu();
            return this.captureValues();
        } while(this.captureValues() != null);
    }

    private RequestDTO captureValues (){

        Scanner input = new Scanner(System.in);
        int opcao = input.nextInt();
        if(opcao == 0) {
            return null;
        }
        System.out.println("Informe o primeiro valor:");
        int valor1 = input.nextInt();
        System.out.println("Informe o segundo valor:");
        int valor2 = input.nextInt();

        return new RequestDTO(opcao,valor1,valor2);
    }

    private void showMenu(){
        int cont = 1;
        //System.out.println("0 - (SAIR)");

        // Acessar todos os methodos declarados na classe Operation
        for(Method m : Operation.class.getDeclaredMethods()) {
            // If para ORDENAR, pois o reflection RETORNA em ordem ALEATORIA. (FICOU MT RUIM)
            if(m.getName().equals("Soma")) {
                cont = 1;
            } else if(m.getName().equals("Subtracao")) {
                cont = 2;
            } else if(m.getName().equals("Multiplicacao")) {
                cont = 3;
            } else if(m.getName().equals("Divisao")) {
                cont = 4;
            }
            System.out.println(cont + " - " + "(" + m.getName() + ")");
        }

    }

    public void showResult (ResponseDTO responseDTO){
        System.out.println("O Resultado é: "+responseDTO.getResult());
    }


}
