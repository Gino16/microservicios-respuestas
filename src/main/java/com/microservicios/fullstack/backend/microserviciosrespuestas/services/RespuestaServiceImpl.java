package com.microservicios.fullstack.backend.microserviciosrespuestas.services;

import com.microservicios.fullstack.backend.microserviciosrespuestas.models.entity.Respuesta;
import com.microservicios.fullstack.backend.microserviciosrespuestas.models.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespuestaServiceImpl implements RespuestaService {

//    @Autowired
//    private ExamenFeignClient examenClient;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Override
    public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
        return respuestaRepository.saveAll(respuestas);
    }

    @Override
    public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId) {
//        Examen examen = examenClient.obtenerExamenPorId(examenId);
//        List<Pregunta> preguntas = examen.getPreguntas();
//        List<Long> preguntasIds = preguntas.stream().map(Pregunta::getId).collect(Collectors.toList());
//        List<Respuesta> respuestas = (List<Respuesta>) respuestaRepository.findRespuestaByAlumnoByPreguntaId(alumnoId, preguntasIds);
//        respuestas = respuestas.stream().map(respuesta -> {
//            preguntas.forEach(pregunta -> {
//                if (pregunta.getId().equals(respuesta.getPreguntaId())){
//                    respuesta.setPregunta(pregunta);
//                }
//            });
//            return respuesta;
//        }).collect(Collectors.toList());

        List<Respuesta> respuestas = (List<Respuesta>) respuestaRepository.findRespuestaByAlumnoByExamen(alumnoId, examenId);
        return respuestas;
    }

    @Override
    public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId) {
        /*List<Respuesta> respuestasAlumno = (List<Respuesta>) respuestaRepository.findByAlumnoId(alumnoId);
        List<Long> examenIds = Collections.emptyList();
        if (respuestasAlumno.size() > 0) {
            List<Long> preguntaIds = respuestasAlumno.stream().map(Respuesta::getPreguntaId).collect(Collectors.toList());
            examenIds = examenClient.obtenerExamenesIdsPorPreguntasIdRespondidas(preguntaIds);
            return examenIds;
        }*/
        List<Respuesta> respuestasAlumno = (List<Respuesta>) respuestaRepository.findExamenesIdsConRespuestasByAlumnoId(alumnoId);
        List<Long> examenIds = respuestasAlumno.stream().map(respuesta -> respuesta.getPregunta().getExamen().getId())
                .distinct()
                .collect(Collectors.toList());
        return examenIds;
    }

    @Override
    public Iterable<Respuesta> findByAlumnoId(Long alumnoId) {
        return respuestaRepository.findByAlumnoId(alumnoId);
    }
}
