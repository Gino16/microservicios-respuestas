package com.microservicios.fullstack.backend.microserviciosrespuestas.controllers;

import com.microservicios.fullstack.backend.microserviciosrespuestas.models.entity.Respuesta;
import com.microservicios.fullstack.backend.microserviciosrespuestas.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RespuestaController {
    @Autowired
    private RespuestaService service;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Iterable<Respuesta> respuestas){
        respuestas = ((List<Respuesta>)respuestas).stream().map(respuesta -> {
            respuesta.setAlumnoId(respuesta.getAlumno().getId());
            respuesta.setPreguntaId(respuesta.getPregunta().getId());
            return respuesta;
        }).collect(Collectors.toList());

        Iterable<Respuesta> respuestasDb = service.saveAll(respuestas);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuestasDb);
    }

    @GetMapping("/alumno/{alumnoId}/examen/{examenId}")
    public ResponseEntity<?> obtenerRespuestasPorAlumnoPorExamen(@PathVariable Long alumnoId, @PathVariable Long examenId){
        Iterable<Respuesta> respuestas = service.findRespuestaByAlumnoByExamen(alumnoId, examenId);
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/alumno/{id}/examenes-respondidos")
    public ResponseEntity<?> obtenerExamenesIdsConRespuestasAlumno(@PathVariable("id") Long alumnoId){
        return ResponseEntity.ok(service.findExamenesIdsConRespuestasByAlumno(alumnoId));
    }
}
