package org.example;

import org.example.controlador.ControladorBebidas;
import org.example.vista.VentanaBebida;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        VentanaBebida view = new VentanaBebida("Proyecto Bebidas Alcoholicas");
        ControladorBebidas controlador = new ControladorBebidas(view);
    }
}