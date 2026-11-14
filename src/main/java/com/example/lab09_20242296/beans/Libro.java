package com.example.lab09_20242296.beans;

public class Libro {

    private int id_libro;
    private Genero id_genero;
    private String titulo;
    private String autor;
    private int anio_publicacion;

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public Genero getId_genero() {
        return id_genero;
    }

    public void setId_genero(Genero id_genero) {
        this.id_genero = id_genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(int anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }
}
