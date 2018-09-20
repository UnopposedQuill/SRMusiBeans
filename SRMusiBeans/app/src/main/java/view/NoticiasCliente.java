package view;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;
import java.util.ArrayList;

import model.Administrador;
import model.Noticia;
import model.NoticiaAdministrador;

public class NoticiasCliente extends AppCompatActivity {

    private RecyclerView mRecyclerView;//necesito un handle al recycler view para poder manejarlo
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias_cliente);

        //ahora importar los parámetros pasados por el llamador
        Bundle bundle = getIntent().getExtras();
        String correoUsuario = bundle.getString("correo");

        TextView textViewNombreUsuario = (TextView) findViewById(R.id.nombreAdministrador);
        textViewNombreUsuario.setText(correoUsuario);

        //ahora el recycler view
        this.mRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewNoticias);

        this.mRecyclerView.setHasFixedSize(true);//no me interesa que cambie de tamaño.

        //necesito un manager de layout linear
        this.mLayoutManager = new LinearLayoutManager(this);
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);//le digo al recycler view que utilice este

        //ahora necesito el adaptador
        ArrayList<Noticia> noticias = new ArrayList<>();//TODO: Sustituir esto por una búsqueda en la base de datos
        java.util.Date testDate = new Date();
        noticias.add(new NoticiaAdministrador("Bienvenida", "Bienvenidos al nuevo sistema de MyBands", testDate, (Administrador) bundle.get("user")));
        this.mAdapter = new AdaptadorNoticias(noticias);
        this.mRecyclerView.setAdapter(this.mAdapter);
    }
}
