package com.bootcamp.proyecto.simulador.domain.mapper;


import com.bootcamp.proyecto.simulador.domain.dto.ClienteDTO;
import com.bootcamp.proyecto.simulador.persistence.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")

public interface ClienteMapper {

    public ClienteDTO toClienteDto(Cliente cliente);


}
