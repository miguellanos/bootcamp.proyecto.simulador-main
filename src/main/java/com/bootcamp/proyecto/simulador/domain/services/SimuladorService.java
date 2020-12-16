package com.bootcamp.proyecto.simulador.domain.services;


import com.bootcamp.proyecto.simulador.domain.dto.ClienteDTO;
import com.bootcamp.proyecto.simulador.domain.dto.FormularioRespuestaDTO;
import com.bootcamp.proyecto.simulador.persistence.entities.Formulario;

import java.util.List;

public interface SimuladorService {


    public boolean validarCliente(String dni);

    public String obtenerTipoTarjeta(String tarjeta);

    public ClienteDTO obtenerCliente(String dni);

    public List<Formulario> obtenerFormulario();

    public FormularioRespuestaDTO obtenerRespuestaFormulario(String dni, int moneda, int monto, int cuotas, Double tea, int diaPago);

    public FormularioRespuestaDTO obtenerRespuestaFormularioJson(Formulario frm);

    public void guardarFormularioJson(Formulario frm);


}
