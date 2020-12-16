package com.bootcamp.proyecto.simulador.domain.dto;

import java.util.Date;

public class FormularioRespuestaDTO {

    private Double cuota;
    private String moneda;
    private String primeraCuota;
    private String status;

    public FormularioRespuestaDTO() {
    }

    public FormularioRespuestaDTO(Double cuota, String moneda, String primeraCuota, String status) {
        this.cuota = cuota;
        this.moneda = moneda;
        this.primeraCuota = primeraCuota;
        this.status = status;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getPrimeraCuota() {
        return primeraCuota;
    }

    public void setPrimeraCuota(String primeraCuota) {
        this.primeraCuota = primeraCuota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
