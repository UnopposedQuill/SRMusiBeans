package view;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import model.Administrador;
import model.Artista;
import model.Noticia;
import model.NoticiaAdministrador;
import model.NoticiaArtista;

public class NoticiasArtista extends AppCompatActivity {

    private RecyclerView mRecyclerView;//necesito un handle al recycler view para poder manejarlo
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private Artista currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias_artista);

        //ahora importar los parámetros pasados por el llamador
        Bundle bundle = getIntent().getExtras();
        String correoUsuario = bundle.getString("correo");
        currentUser = (Artista) bundle.get("user");

        //ahora el recycler view
        this.mRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewNoticiasArtista);

        this.mRecyclerView.setHasFixedSize(true);//no me interesa que cambie de tamaño.

        //necesito un manager de layout linear
        this.mLayoutManager = new LinearLayoutManager(this);
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);//le digo al recycler view que utilice este

        //ahora necesito el adaptador
        ArrayList<Noticia> noticias = new ArrayList<>();//TODO: Sustituir esto por una búsqueda en la base de datos
        java.util.Date testDate = new Date();
        noticias.add(new NoticiaArtista("Bienvenida", "Bienvenidos al nuevo sistema de MyBands", testDate, currentUser));
        this.mAdapter = new AdaptadorNoticias(noticias);
        this.mRecyclerView.setAdapter(this.mAdapter);

        Button addNewsButton = findViewById(R.id.btnAgregarNoticia);
        addNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("hi"); // TODO hacer el cambio de activity
            }
        });

        Button storeButton = findViewById(R.id.btnVisitarTienda);
        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("hi"); // TODO hacer el cambio de activity
            }
        });

        Button nextEventsButton = findViewById(R.id.btnProximosEventos);
        nextEventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("hi"); // TODO hacer el cambio de activity
            }
        });

        Button exitButton = findViewById(R.id.btnExitArtist);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit();
            }
        });
    }

    private void exit() {
        Intent intento = new Intent(this, LoginActivity.class);
        startActivityForResult(intento, 0);
    }
/*
    private void nextEvents() {
        Intent intento = new Intent(this, EventosArtista.class);
        intento.putExtra("user", (Parcelable) currentUser);
        startActivityForResult(intento, 0);
    }

    private void bandStore() {
        Intent intento = new Intent(this, TiendasArtista.class);
        intento.putExtra("user", (Parcelable) currentUser);
        startActivityForResult(intento, 0);
    }

    private void addNews() {
        Intent intento = new Intent(this, NuevaNoticia.class);
        intento.putExtra("user", (Parcelable) currentUser);
        startActivityForResult(intento, 0);
    }*/
}
