/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author christianrieigl
 */
public class VehiculoInvalidoException extends Exception {
    public VehiculoInvalidoException() {
        super("Tipo de vehículo no válido.");
    }
    
    public VehiculoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
