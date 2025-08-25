package org.example.calculadora.application;

import org.example.calculadora.controller.Controller;
import org.example.calculadora.dto.RequestDTO;
import org.example.calculadora.dto.ResponseDTO;
import org.example.calculadora.view.Menu;

public class Application {
    public static void main(String[] args) {
        Menu menu = new Menu();
        RequestDTO requestDTO = menu.show();
        Controller controllerCalc = new Controller();
        ResponseDTO responseDTO = controllerCalc.calc(requestDTO);
        menu.showResult(responseDTO);
    }
}
