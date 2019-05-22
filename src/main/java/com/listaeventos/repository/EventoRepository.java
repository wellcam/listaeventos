package com.listaeventos.repository;

import org.springframework.data.repository.CrudRepository;

import com.listaeventos.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{

}
