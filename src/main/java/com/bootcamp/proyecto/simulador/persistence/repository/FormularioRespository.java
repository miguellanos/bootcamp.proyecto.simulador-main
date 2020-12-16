package com.bootcamp.proyecto.simulador.persistence.repository;

import com.bootcamp.proyecto.simulador.persistence.entities.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormularioRespository extends JpaRepository<Formulario, Long> {

    public List<Formulario> findAll();

    public Formulario saveAndFlush(Formulario frm);

}
