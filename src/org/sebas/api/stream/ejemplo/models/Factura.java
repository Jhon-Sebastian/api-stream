package org.sebas.api.stream.ejemplo.models;

public class Factura {
    private String descripcion;
    //Opcional, para hacer referencia al Usuario
    private Usuario usuario;

    public Factura(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
