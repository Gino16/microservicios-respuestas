package com.microservicios.fullstack.backend.microserviciosrespuestas.services;

import com.microservicios.fullstack.backend.microserviciosrespuestas.models.entity.Respuesta;

public interface RespuestaService {

    public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas);

    public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId);

    public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);

    public Iterable<Respuesta> findByAlumnoId(Long alumnoId);
}
