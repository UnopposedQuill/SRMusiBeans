package Model;

import java.util.ArrayList;

public class Cliente extends Usuario {

    private ArrayList<Artista> artistasFavoritos;
    //private ArrayList<NoticiaAdministrador> noticias;//removida por reducción


    public Cliente(String nombreUsuario, String contrasenha, String nombre) {
        super(nombreUsuario, contrasenha, nombre);
        this.artistasFavoritos = new ArrayList<>();
    }

    public ArrayList<Artista> getArtistasFavoritos() {
        return artistasFavoritos;
    }

    public void setArtistasFavoritos(ArrayList<Artista> artistasFavoritos) {
        this.artistasFavoritos = artistasFavoritos;
    }
}
