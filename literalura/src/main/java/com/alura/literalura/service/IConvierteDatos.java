package com.alura.literalura.service;

public interface IConvierteDatos {
 <T> T convertirDatos(String json, Class<T> clase);
}
