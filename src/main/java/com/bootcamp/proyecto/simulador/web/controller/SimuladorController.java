package com.bootcamp.proyecto.simulador.web.controller;



import com.bootcamp.proyecto.simulador.domain.dto.ClienteDTO;
import com.bootcamp.proyecto.simulador.domain.dto.FormularioRespuestaDTO;
import com.bootcamp.proyecto.simulador.domain.services.SimuladorService;
import com.bootcamp.proyecto.simulador.persistence.entities.Formulario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/simulador")


public class SimuladorController {


    @GetMapping("")
    public String simuladorCredito(){

        return "Simulador de Creditos";

    }

    @Autowired
    private SimuladorService simuladorService;


    //Endpoint que me obtiene si una tarjeta existe o no en booleano
    @GetMapping("/validar/{dni}")
    public boolean validacionDNI(@PathVariable("dni")String dni){

        return simuladorService.validarCliente(dni);

    }

    //Endpoint que me obtiene el tipo de la tarjeta
    @GetMapping("/tipoTarjeta/{dni}")
    public String nombrarTipoTarjeta(@PathVariable("dni")String dni){

        return simuladorService.obtenerTipoTarjeta(dni);

    }

    //Endpoint que me retorna un ClienteDTO buscado por el DNI
    @GetMapping("/cliente/{dni}")
    public ClienteDTO obtenerClienteTipoTarjeta(@PathVariable("dni")String dni){

        return simuladorService.obtenerCliente(dni);

    }

    //Endpoint que me devuelve una lista de formularios
    @GetMapping("/formularios")
    public List<Formulario> obtenerFormulario(){

        return simuladorService.obtenerFormulario();

    }


    //Endpoint que me retorna el formulario para el front
    @GetMapping("/formulario")
    public FormularioRespuestaDTO obtenerRespuestaFormulario(
            @RequestParam(value="dni") String dni,
            @RequestParam(value="moneda") int moneda,
            @RequestParam(value="monto") int monto,
            @RequestParam(value="cuotas") int cuotas,
            @RequestParam(value="tea") Double tea,
            @RequestParam(value="diaPago") int diaPago){

        var simulador= simuladorService.obtenerRespuestaFormulario(dni, moneda, monto, cuotas, tea, diaPago);

        /*
        http://localhost:8080/simulador/formulario?dni=70438135&moneda=1&monto=1000&tea=5&cuotas=5&diaPago=20

        http://localhost:8080/simulador/formulario?dni=70438135&moneda=0&monto=10&tea=0.99&cuotas=5&diaPago=3

        * */


        return simulador;
    }

    //Endpoint que me retorna el formularioProcesado para el front pero el input es un objeto enviado tipo json

    //@PostMapping(path="/formulario/frm",consumes = "application/json", produces = "application/json")
    @PostMapping("/formulario/frm")
    @ResponseStatus(value= HttpStatus.CREATED)
    public FormularioRespuestaDTO obtenerResultadoFormulario(
            @RequestBody Formulario frm){



        simuladorService.guardarFormularioJson(frm);

        var simulador= simuladorService.obtenerRespuestaFormularioJson(frm);

        return simulador;
    }


}
