package com.example.astrid.appzar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class InfoActivity extends AppCompatActivity {

    private TextView titulo, horario, precio;
    private ImageView imagen1, imagen2;
    private String marcador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        titulo = (TextView)findViewById(R.id.titulo);
        imagen1 = (ImageView)findViewById(R.id.imagen1);
        imagen2 = (ImageView)findViewById(R.id.imagen2);
        horario = (TextView)findViewById(R.id.horario);
        precio = (TextView)findViewById(R.id.precio);

        Bundle bundle = getIntent().getExtras();

        marcador = bundle.getString("marcador");

        if (marcador.equals("Basílica del Pilar")){
            imagen1.setImageResource(R.mipmap.pilar1);
            imagen2.setImageResource(R.mipmap.pilar2);
            horario.setText(infoHorario[0]);
            precio.setText(infoPrecio[0]);
        } else if (marcador.equals("Palacio de la Aljafería")){
            imagen1.setImageResource(R.mipmap.aljaferia1);
            imagen2.setImageResource(R.mipmap.aljaferia2);
            horario.setText(infoHorario[1]);
            precio.setText(infoPrecio[1]);
        } else if (marcador.equals("Teatro Romano")){
            imagen1.setImageResource(R.mipmap.romano1);
            imagen2.setImageResource(R.mipmap.romano2);
            horario.setText(infoHorario[2]);
            precio.setText(infoPrecio[2]);
        } else if (marcador.equals("Catedral de La Seo")){
            imagen1.setImageResource(R.mipmap.seo1);
            imagen2.setImageResource(R.mipmap.seo2);
            horario.setText(infoHorario[3]);
            precio.setText(infoPrecio[3]);
        } else if (marcador.equals("Foro Romano")){
            imagen1.setImageResource(R.mipmap.foro1);
            imagen2.setImageResource(R.mipmap.foro2);
            horario.setText(infoHorario[4]);
            precio.setText(infoPrecio[4]);
        }

        titulo.setText(marcador);

    }

    public void comollegar (View view){
        Intent i = new Intent(this, ComoLLegar_Activiy.class);
        i.putExtra("marcador", marcador);
        finalizar(view);
        startActivity(i);
    }

    public void finalizar (View view){
        finish();
    }

    /*
        Información del horario y precios de los lugares
        Orden: Pilar, Aljaferia, Teatro Romano, La Seo, Foro Romano
      */
    static String[] infoHorario = {
            "\nLunes a sábado de 6:45 a 20:30 h. Domingo y festivos de 6:45 a 21:30 h\n\nVISITA " +
                    "AL MUSEO PILARISTA:\nLunes a viernes de 10 a 14 y de 16 a 20h\n\nSábados:10 a 14h.\n" +
                    "\nDomingos y festivos: cerrado\n\nVISITA PANORÁMICA DESDE LA TORRE:\nInvierno 10 a" +
                    " 14 y de 16 a 18\n\nVerano de 10 a 14 y de 16 a 20h\n",

            "\nDe abril a octubre: todos los días* de 10 a 14 h y de 16:30 a 20 h.Visitas" +
                    " guiadas a las 10:30, 11:30, 12:30, 16:30, 17:30 y 18:30 h.\n\nDe noviembre a marzo: " +
                    "de lunes a sábado* de 10 a 14 y de 16 a 18:30 h. Domingos: 10 a 14 h. Visitas " +
                    "guiadas a las 10:30, 11:30, 12:30, 16:30 y 17:30 h.\n",

            "\nMartes a sábado de 10 a 14h y 17 a 21h\n\nDomingos 10 a " +
                    "14.30h\n\nLunes cerrado\n\nMedia hora antes del cierre se interrumpe la entrada.\n",

            "\nHORARIO DE INVIERNO:\nLunes a viernes: de 10h a 14h y de 16h a 18.30h.\n\nSábados: " +
                    "de 10 a 12.30 y de 16.00 a 18.30h.\n\nDomingos y festivos religiosos de 10 a 12.00 " +
                    "y de 16 a 18.30h\n\nHORARIO DE VERANO:\nLunes a Domingo: de 10 a 21h(20.30 última " +
                    "entrada)\n\nEl viernes de 10-18h \n\nL-D: 18h se interrumpe la entrada para la misa " +
                    "de 19.00 \n\nSábados: 12h se interrumpe la entrada para la misa de 13h \n\nDomingos:" +
                    " 11.30h se interrumpe la entrada para la misa de 12.30 \n\nMedia hora antes del " +
                    "cierre concluirá la entrada de visitantes. Se suspenderán las visitas en caso de " +
                    "celebración extraordinaria.\n",

            "\nMartes a sábado de 10 a 14h y 17 a 21h\n\nDomingos 10 a 14.30h\n\nLunes cerrado" +
                    "\n\nMedia hora antes del cierre se interrumpe la entrada.\n"
    };

    static String[] infoPrecio = {
            "\nEntrada Basílica gratuita \n\nVisita a la Torre: 3 euros. Niños de 0 a 9 años: " +
                    "gratuito \n\nVisita Museo Pilarista: 2 euros.",

            "\nAdulto: 5 euros.\n\nC. Joven, estudiantes y mayores de 65 años: 1 euro.\nNiños " +
                    "0-12 años: gratuito.\n\nDomingos gratuito.",

            "\nGRATUITO: primer domingo de cada mes y los días 29 enero San Valero, 18 mayo" +
                    " Día Internacional del Museo, 12 octubre Día del Pilar.\n\nEntrada:4 euros\n\nGratuito:" +
                    " Mayores de 65 años, desempleados, periodistas acreditados, monitores acompañantes" +
                    " y responsables de grupos de escolares, miembros del ICOM,Asociación de Críticos de " +
                    "Arte, niños menores de 8 años.\n\nConsultar las tarifas reducidas para grupos y" +
                    " estudiantes",

            "\nEntrada conjunto Catedral y Museo de tapices: 4 euros\n\nHasta 18 años y mayores " +
                    "de 65 años: 3 euros\n\nNiños de 0 a 10 años: gratuito\n\n",

            "\nEntrada: 3 euros\n\nConsultar las tarifas reducidas para grupos y estudiantes\n\n" +
                    "Gratuito: Mayores de 65 años, desempleados, periodistas acreditados, monitores " +
                    "acompañantes y responsables de grupos de escolares, miembros del ICOM, Asociación de" +
                    " Críticos de Arte, niños menores de 8 años."
    };
}



