/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author christianrieigl
 */
public class ParkingLlenoException extends Exception {
    public ParkingLlenoException() {
        super("No hay plazas disponibles para este tipo de vehiculo.");
    }
    
    public ParkingLlenoException(String mensaje) {
        super(mensaje);
    }
}
