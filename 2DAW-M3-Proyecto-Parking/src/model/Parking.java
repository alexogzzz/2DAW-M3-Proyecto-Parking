package model;
import java.util.Scanner;

public class Parking {
    private Plaza[][] plazas;

    public Parking(int numPisos, int numPlazasPorPiso) {
        plazas = new Plaza[numPisos][numPlazasPorPiso];
        for (int piso = 0; piso < numPisos; piso++) {
            for (int plaza = 0; plaza < numPlazasPorPiso; plaza++) {
                Plaza nuevaPlaza = new Plaza("P" + (piso + 1) + "_" + (plaza + 1));
                if (plaza < 5) {
                    nuevaPlaza.setTipoPermitido("coche");
                } else if (plaza < 8) {
                    nuevaPlaza.setTipoPermitido("moto");
                } else {
                    nuevaPlaza.setTipoPermitido("camion");
                }
                plazas[piso][plaza] = nuevaPlaza;
            }
        }
    }

    public void generarTicket(Scanner s) {
        try {
            System.out.println("¡Bienvenido al parking Monlau!");
            System.out.println("Introduce el tipo de vehículo (coche, moto, camion): ");
            String tipo = s.next().trim().toLowerCase();
            
            if (!tipo.equals("coche") && !tipo.equals("moto") && !tipo.equals("camion")) {
                throw new IllegalArgumentException("Tipo de vehículo no válido.");
            }
            
            System.out.println("Introduce la matrícula del vehículo: ");
            String matricula = s.next().trim();
            System.out.println("Introduce el color del vehículo: ");
            String color = s.next().trim();

            Vehiculo vehiculo = switch (tipo) {
                case "coche" -> new Coche(matricula, color);
                case "moto" -> new Moto(matricula, color);
                case "camion" -> new Camion(matricula, color);
                default -> throw new IllegalArgumentException("Tipo de vehículo no válido.");
            };
            
            Plaza plazaAsignada = asignarVehiculo(vehiculo);
            if (plazaAsignada != null) {
                Ticket ticket1 = new Ticket();
                System.out.println("          TICKET de ENTRADA");
                System.out.println("----------------------------------------");
                System.out.println("            Parking Monlau");
                System.out.println("         C/ Monlau 6, Barcelona");
                System.out.println("             +34 666 66 66");
                System.out.println("         " + ticket1.getCodigo());
                System.out.println("----------------------------------------");
                System.out.println("   Fecha de Entrada: " + ticket1.getFechaEntrada());
                System.out.println("    Hora de Entrada: " + ticket1.getHoraEntrada());
                System.out.println("Matrícula: " + vehiculo.getMatricula());
                System.out.println("Plaza asignada: " + plazaAsignada.getNumeroPlaza());
            } else {
                System.out.println("No hay plazas disponibles para este tipo de vehículo.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void retirarVehiculo(String numeroPlaza) {
        try {
            for (Plaza[] piso : plazas) {
                for (Plaza plaza : piso) {
                    if (plaza.getNumeroPlaza().equals(numeroPlaza)) {
                        if (plaza.getVehiculo() == null) {
                            throw new IllegalStateException("La plaza está vacía.");
                        }
                        double tarifa = plaza.getVehiculo().calcularTarifa();
                        plaza.eliminarVehiculo();
                        System.out.println("Vehículo retirado de la plaza " + numeroPlaza + ". Tarifa: " + tarifa + " €");
                        return;
                    }
                }
            }
            throw new IllegalArgumentException("Plaza no encontrada.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
