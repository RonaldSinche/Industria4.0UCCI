package com.example.maps;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class DetalleAgenda extends AppCompatActivity {

    private int idEvento;
    private String evento,fecha,hora,ponente,mapa;
    private Button btnLugar;
    private TextView tvFecha,tvEventoNombre,tvHora,tvPonente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_agenda);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tvFecha=findViewById(R.id.tvFecha);
        tvEventoNombre=findViewById(R.id.tvEventoNombre);
        tvHora=findViewById(R.id.tvHora);
        tvPonente=findViewById(R.id.tvPonente);
        btnLugar=findViewById(R.id.btnLugar);

        idEvento= Integer.parseInt(getIntent().getStringExtra("idEvento"));
        final IndustriaDB db=new IndustriaDB(this);
        List<Evento> eventoList=db.mostrarEventosAgenda();
        for(int i=0;i<=eventoList.size();i++)
        {
            if(i==idEvento)
            {
                evento=eventoList.get(i).getNombre();
                fecha=eventoList.get(i).getFecha();
                hora=eventoList.get(i).getHora();
                ponente=eventoList.get(i).getPonente();
                mapa=eventoList.get(i).getLugar();
            }
        }
        tvPonente.setText(ponente);
        tvHora.setText(hora);
        tvEventoNombre.setText(evento);
        tvFecha.setText(fecha);
        btnLugar.setText(mapa);
    }
}