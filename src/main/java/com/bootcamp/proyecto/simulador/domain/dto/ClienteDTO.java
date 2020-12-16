package com.bootcamp.proyecto.simulador.domain.dto;


public class ClienteDTO {


    private String dni;
    private String nombre;

    private String tipoTarjeta;

    public ClienteDTO() {
    }

    public ClienteDTO(String dni, String nombre, String tipoTarjeta) {
        this.dni = dni;
        this.nombre = nombre;
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }
}
