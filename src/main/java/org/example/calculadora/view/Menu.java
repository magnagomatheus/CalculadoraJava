package org.example.calculadora.view;

import org.example.calculadora.dto.RequestDTO;
import org.example.calculadora.dto.ResponseDTO;

import java.lang.reflect.*;
import java.util.Scanner;

import org.example.calculadora.model.operation.IOperation;
import org.reflections.Reflections;
import java.util.Set;


public class Menu {


    public RequestDTO show(){
        this.showMenu();
        return this.captureValues();
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

    // Aplicar reflection aqui!!!
    private void showMenu(){

        // Utilizando a bilbioteca Reflections para percorrer todas as classes (operacoes neste caso) dentro de um determinado CD (caminho)
        Reflections reflections = new Reflections("org.example.calculadora.model");

        // Busca de todas as classes que implemento a interface IOperation
        // Set --> Garante que nao haja classe repetida nesta lista de classes.
        Set<Class<? extends IOperation>> classes = reflections.getSubTypesOf(IOperation.class);

        System.out.println("---->Bem vindo!<----");
        System.out.println("Escolha uma das opção:");
        // Imprime o nome das classes que implementam a interface
        int indice = 0;
        // Class --> OBJ que contém as informações (metadados) de uma determinada classe
        // <? extends IOperations> --> Any classe que seja uma subclasse de IOperation (extends)
        // So, o obj Class ira conter as informações (metadados) de todas as classes que herdam IOperation.
        for(Class<? extends IOperation> clazz : classes) {
            String op_name = clazz.getSimpleName();
            if(op_name.equals("Somar")) {
                indice = 1;
            } else if(op_name.equals("Subtrair")) {
                indice = 2;
            } else if(op_name.equals("Multiplicar")) {
                indice = 3;
            } else {
                indice = 4;
            }
            System.out.println(indice + ") " + op_name);
        }
        System.out.println("0) Sair");



        /*System.out.println("Escolha uma das opção:");
        System.out.println("1 - Somar");
        System.out.println("2 - Subtrair");
        System.out.println("3 - Multiplicar");
        System.out.println("4 - Dividir");
        System.out.println("5 - Vá embora ...");*/

    }

    public void showResult (ResponseDTO responseDTO){
        int r = responseDTO.getResult();

        if(r == -999) {
            System.out.println("Encerrando!");
        } else {
            System.out.println("O Resultado é: "+r);
        }
    }


}
