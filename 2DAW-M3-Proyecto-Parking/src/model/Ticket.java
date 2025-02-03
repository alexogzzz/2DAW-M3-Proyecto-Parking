package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;

public class Ticket {
    private static int contador = 0;
    private String codigo;
    private LocalDate fechaEntrada;
    private LocalTime horaEntrada;
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private double costo;

    public Ticket() {
        contador++;
        this.codigo = "Codigo: " + contador;
        this.fechaEntrada = LocalDate.now();
        this.horaEntrada = LocalTime.now();
        this.costo = 0;  // Inicializa el costo como 0
    }

    // Método para cerrar el ticket y calcular el costo
    public void cerrarTicket() {
        this.fechaSalida = LocalDate.now();
        this.horaSalida = LocalTime.now();
        calcularCosto();
    }

    // Método para calcular el costo en base a la duración
    private void calcularCosto() {
        if (fechaEntrada.equals(fechaSalida)) {
            // Si la fecha de entrada y salida son el mismo día
            long horasDiferencia = Duration.between(horaEntrada, horaSalida).toHours();
            costo = horasDiferencia * 10;  // Supón que cada hora cuesta 10 unidades de dinero
        } else {
            // Si la duración abarca más de un día
            long horasDiferencia = Duration.between(horaEntrada.atDate(fechaEntrada), horaSalida.atDate(fechaSalida)).toHours();
            costo = horasDiferencia * 10;
        }
    }

    // Métodos getters
    public String getCodigo() {
        return codigo;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public double getCosto() {
        return costo;
    }

    // Método para obtener la duración total
    public String getDuracion() {
        if (horaSalida != null && horaEntrada != null) {
            long horasDiferencia = Duration.between(horaEntrada, horaSalida).toHours();
            long minutosDiferencia = Duration.between(horaEntrada, horaSalida).toMinutes() % 60;
            return horasDiferencia + " horas y " + minutosDiferencia + " minutos";
        }
        return "Duración no disponible";
    }

    // Sobrescribe el método toString para una salida detallada del ticket
    @Override
    public String toString() {
        String fechaSalidaStr = (fechaSalida != null ? fechaSalida.toString() : "No cerrada");
        String horaSalidaStr = (horaSalida != null ? horaSalida.toString() : "No cerrada");
        return "Ticket " + codigo + "\n" +
               "Fecha Entrada: " + fechaEntrada + "\n" +
               "Hora Entrada: " + horaEntrada + "\n" +
               "Fecha Salida: " + fechaSalidaStr + "\n" +
               "Hora Salida: " + horaSalidaStr + "\n" +
               "Costo: " + costo + " unidades\n" +
               "Duración: " + getDuracion();
    }
}
