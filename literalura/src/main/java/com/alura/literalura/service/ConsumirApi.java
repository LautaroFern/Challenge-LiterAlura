package com.alura.literalura.service;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ConsumirApi {
    public String obtenerDatos(String url){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Enviar la solicitud HTTP y obtener la respuesta
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            // Lanzar una RuntimeException si ocurre un error de E/S
            throw new RuntimeException("Error de E/S al obtener datos de la API", e);
        } catch (InterruptedException e) {
            // Lanzar una RuntimeException si la solicitud es interrumpida
            throw new RuntimeException("La solicitud fue interrumpida", e);
        }

        //Retornar el cuerpo del Json
        String json = response.body();
        return json;
    }
}
