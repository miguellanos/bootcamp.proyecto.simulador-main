package com.bootcamp.proyecto.simulador.persistence.repository;

import com.bootcamp.proyecto.simulador.domain.dto.ClienteDTO;
import com.bootcamp.proyecto.simulador.persistence.entities.Cliente;
import com.bootcamp.proyecto.simulador.persistence.entities.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimuladorRepository extends JpaRepository<Cliente,Long> {

    public Cliente findByDni(String dni);

    public Cliente findByNumeroTarjeta(String tarjeta);


}
