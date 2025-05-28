package com.insideIgloo.projeto.igloo.Enums;

public enum UsuarioEnum {
    ADMIN("admin"),

    USUARIO("usuario");

    private String tipo;

    UsuarioEnum(String tipoUsuario){
        this.tipo = tipoUsuario;
    }

    public String getTipo(){
        return this.tipo;
    }
}
