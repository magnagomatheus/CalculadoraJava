package org.example.calculadora.controller;

import org.example.calculadora.dto.RequestDTO;
import org.example.calculadora.dto.ResponseDTO;
import org.example.calculadora.model.Operation;

public class Controller {

    public ResponseDTO calc(RequestDTO requestDTO){

        int result = 0;
        // APPLYING REFLECTION AQUI MAYBE
        Operation op = new Operation();
        int v1 = requestDTO.getValor1();
        int v2 = requestDTO.getValor2();
        switch (requestDTO.getOpcao()) {
            case 1:
                result = op.Soma(v1,v2);
                break;
            case 2:
                result = op.Subtracao(v1,v2);
                break;
            case 3:
                result = op.Multiplicacao(v1,v2);
                break;
            case 4:
                result = op.Divisao(v1,v2);
                break;
        }
        return new ResponseDTO(result);
    }

}
