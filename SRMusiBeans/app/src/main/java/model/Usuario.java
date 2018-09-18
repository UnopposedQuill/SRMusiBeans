package model;

public abstract class Usuario {

    private String nombreUsuario;
    private String contrasenha;
    private String nombre;

    public Usuario(String nombreUsuario, String contrasenha, String nombre) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenha = contrasenha;
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
