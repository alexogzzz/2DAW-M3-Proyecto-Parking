/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.gui;
import model.Parking;

import view.gui.ParkingView;
/*
 *
 * @author alexormgom
 */
public class Main {
    
    public static Parking parking = new Parking(1, 10);
    
    public static void main(String[] args) {
        
        //conectar interfaz grafica
        ParkingView panta = new ParkingView(Main.parking);
        panta.setVisible(true);
        panta.setLocationRelativeTo(null);
    }
    
}
