package Model;

import java.util.ArrayList;

public class Administrador extends Usuario {

    private ArrayList <NoticiaAdministrador> noticiasPropias;

    public Administrador(String nombreUsuario, String contrasenha, String nombre) {
        super(nombreUsuario, contrasenha, nombre);
        this.noticiasPropias = new ArrayList<>();
    }

    public ArrayList<NoticiaAdministrador> getNoticiasPropias() {
        return noticiasPropias;
    }

    public void setNoticiasPropias(ArrayList<NoticiaAdministrador> noticiasPropias) {
        this.noticiasPropias = noticiasPropias;
    }
}
