package org.example.calculadora.controller;

import org.example.calculadora.dto.RequestDTO;
import org.example.calculadora.dto.ResponseDTO;
import org.example.calculadora.model.Calc;
import org.example.calculadora.model.ICalc;
import org.example.calculadora.model.operation.*;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

public class Controller {

    public ResponseDTO calc(RequestDTO requestDTO){

        // Se requestDTO for null, ENCERRA O PROGRAMA, porem n sei se podia usar System.exit.
        if (requestDTO == null) {
            return new ResponseDTO(-999);
        }

        int result = 0;
        ICalc calc = null;

        calc = new Calc();


        IOperation operation = null;
        // APPLYING REFLECTION AQUI MAYBE --> Se pudesse alterar o input opcao para String faria mais sentido para aplicacao do reflection,
        // pois poderia apenas chamar a operacao com o nome digitado pelo usuario, sem verificacoes de ifs...

        // Criacao do object reflection que tera acesso a pasta com todas as classes (operacoes neste caso).
        Reflections reflection = new Reflections("org.example.calculadora.model");

        // Using set to garantiee that will not have duplicate of a class.
        // Criacao de uma lista classes com todas as classes que herdam de IOperation.
        Set<Class<? extends IOperation>> classes = reflection.getSubTypesOf(IOperation.class);

        // Conversao para lista para ordenação das operações.
        ArrayList<Class<? extends IOperation>> operacoes = new ArrayList<>(classes);

        // Ordenacao das operacoes pelos nomes, utilizando Comparator da biblioteca java.util
        operacoes.sort(Comparator.comparing(Class::getSimpleName));

        // Obtencao da classe (operacao) escolhida pelo usuario, sendo -1 pois o range da lista eh de 0 a 3 (qtd operacoes);
        Class<? extends IOperation> currentClass = operacoes.get(requestDTO.getOpcao()-1);

        // Trys obrigatorios
        try {
            // Criacao de instancia da classe escolhida, metodo getDeclaredConstructor() precisa de um construtor padrao declarado em cada classe possivel...
            operation = currentClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        // Calculando o valor com a funcao calculation passando a operacao (classe) e os valores.
        result = calc.calculation(operation,requestDTO.getValor1(),requestDTO.getValor2());
        return new ResponseDTO(result);

    }
}