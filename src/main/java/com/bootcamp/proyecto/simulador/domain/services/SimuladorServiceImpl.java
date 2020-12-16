package com.bootcamp.proyecto.simulador.domain.services;

import com.bootcamp.proyecto.simulador.domain.dto.ClienteDTO;
import com.bootcamp.proyecto.simulador.domain.dto.FormularioRespuestaDTO;
import com.bootcamp.proyecto.simulador.domain.mapper.ClienteMapper;
import com.bootcamp.proyecto.simulador.persistence.entities.Cliente;
import com.bootcamp.proyecto.simulador.persistence.entities.Formulario;
import com.bootcamp.proyecto.simulador.persistence.repository.FormularioRespository;
import com.bootcamp.proyecto.simulador.persistence.repository.SimuladorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimuladorServiceImpl implements  SimuladorService{

    @Autowired
    SimuladorRepository simuladorRepository;

    @Autowired
    FormularioRespository formularioRespository;

    @Autowired
    ClienteMapper clienteMapper;


    @Override
    public boolean validarCliente(String dni) {

       boolean valor = false;

       var existe = simuladorRepository.findByDni(dni);

       if (existe != null)
       valor = true;

        return valor;
    }

    @Override
    public String obtenerTipoTarjeta(String tarjeta) {

        var cliente = simuladorRepository.findByNumeroTarjeta(tarjeta);

        return clienteMapper.toClienteDto(cliente).getTipoTarjeta();


    }

    @Override
    public ClienteDTO obtenerCliente(String dni) {

        var cliente = simuladorRepository.findByDni(dni);

        return clienteMapper.toClienteDto(cliente);

    }

    @Override
    public List<Formulario> obtenerFormulario() {

        var formularios = formularioRespository.findAll();

        return formularios;
    }

    @Override
    public FormularioRespuestaDTO obtenerRespuestaFormulario(String dni, int moneda, int monto, int cuotas, Double tea, int diaPago) {

        //Formulario formulario = new Formulario(dni, moneda, monto,cuotas,tea, diaPago);

        var cuotaFor = monto/cuotas*tea;

        String monedaFor="";
        if(moneda == 0){
            monedaFor="S/.";
        }else{
            monedaFor="$";
        }

        String diaPagoFor="";

        if (diaPago>10){

            diaPagoFor="15-04-2020";
        }else{
            diaPagoFor="01-04-2020";
        }

        var statusFor = "Denegado";

        if (cuotaFor > 100){
            statusFor = "Aprobado";
        }



        //FormularioRespuestaDTO formularioRespuestaDTO = new FormularioRespuestaDTO(Double cuota, String moneda, String primeraCuota, boolean status);

        FormularioRespuestaDTO formularioRespuestaDTO = new FormularioRespuestaDTO(cuotaFor, monedaFor, diaPagoFor, statusFor);

        return formularioRespuestaDTO;
    }

    @Override
    public FormularioRespuestaDTO obtenerRespuestaFormularioJson(Formulario frm) {

        var cuotaFor = frm.getMonto()/frm.getCuotas() * frm.getTea();

        String monedaFor="";
        if(frm.getMoneda() == 0){
            monedaFor="S/.";
        }else{
            monedaFor="$";
        }

        String diaPagoFor="";

        if (frm.getDiaPago()>10){

            diaPagoFor="15-04-2020";
        }else{
            diaPagoFor="01-04-2020";
        }

        var statusFor = "Denegado";

        if (cuotaFor > 100){
            statusFor = "Aprobado";
        }

        FormularioRespuestaDTO formularioRespuestaDTO = new FormularioRespuestaDTO(cuotaFor, monedaFor, diaPagoFor, statusFor);

        return formularioRespuestaDTO;
    }

   /* @Override
    public FormularioRespuestaDTO obtenerRespuestaFormularioJson(String dni, int moneda, int monto, int cuotas, Double tea, int diaPago) {

        ///Formulario form = new Formulario(dni, moneda, monto,cuotas,tea, diaPago);

        var cuotaFor = monto/cuotas *tea;

        String monedaFor="";
        if(moneda == 0){
            monedaFor="S/.";
        }else{
            monedaFor="$";
        }

        String diaPagoFor="";

        if (diaPago>10){

            diaPagoFor="15-04-2020";
        }else{
            diaPagoFor="01-04-2020";
        }

        var statusFor = "Denegado";

        if (cuotaFor > 100){
            statusFor = "Aprobado";
        }



        //FormularioRespuestaDTO formularioRespuestaDTO = new FormularioRespuestaDTO(Double cuota, String moneda, String primeraCuota, boolean status);

        FormularioRespuestaDTO formularioRespuestaDTO = new FormularioRespuestaDTO(cuotaFor, monedaFor, diaPagoFor, statusFor);

        return formularioRespuestaDTO;
    }
*/

    public void guardarFormularioJson(Formulario frm){


        formularioRespository.saveAndFlush(frm);


    }


}
