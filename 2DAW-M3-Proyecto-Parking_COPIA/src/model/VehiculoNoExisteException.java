/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author christianrieigl
 */
public class VehiculoNoExisteException extends Exception {
    public VehiculoNoExisteException() {
        super("¡¡El tipo de vehículo especificado no existe!!");
    }
    
    public VehiculoNoExisteException(String mensaje) {
        super(mensaje);
    }
}
