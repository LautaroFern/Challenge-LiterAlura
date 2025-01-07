package com.alura.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ConvierteDatos implements IConvierteDatos {

    private ObjectMapper objectMapper;

    public ConvierteDatos() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public <T> T convertirDatos(String Json, Class<T> clase) {
        try {
            return objectMapper.readValue(Json, clase);
        } catch (JsonProcessingException e){
            throw new RuntimeException("Error al deserializar el JSON");
        }
    }
}
