package com.bootcamp.proyecto.simulador.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name="formulario")
public class Formulario {


    @Id
    //@GeneratedValue
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "dni")
    private String dni;

    @Column (name = "tipoTarjeta")
    private String tipoTarjeta;

    @Column (name = "moneda")
    private int moneda;

    @Column (name = "monto")
    private int monto;

    @Column (name = "cuotas")
    private int cuotas;

    @Column (name = "tea")
    private Double tea;

    @Column (name = "diaPago")
    private int diaPago;



    public Formulario() {

    }

    public Formulario(Long id, String dni, String tipoTarjeta, int moneda, int monto, int cuotas, Double tea, int diaPago) {
        this.id = id;
        this.dni = dni;
        this.tipoTarjeta = tipoTarjeta;
        this.moneda = moneda;
        this.monto = monto;
        this.cuotas = cuotas;
        this.tea = tea;
        this.diaPago = diaPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public int getMoneda() {
        return moneda;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public Double getTea() {
        return tea;
    }

    public void setTea(Double tea) {
        this.tea = tea;
    }

    public int getDiaPago() {
        return diaPago;
    }

    public void setDiaPago(int diaPago) {
        this.diaPago = diaPago;
    }
}
