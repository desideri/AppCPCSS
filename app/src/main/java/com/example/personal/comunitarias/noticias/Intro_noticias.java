package com.example.personal.comunitarias.Noticias;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.personal.comunitarias.R;

import java.util.LinkedList;
import java.util.List;

public class Intro_noticias extends AppCompatActivity {
    static List<Noticia> noticias, boletines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_noticias);

        //pantalla fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        noticias = new LinkedList<>();
        boletines = new LinkedList<>();
        //se hace una lectura inicial de las noticas en la pagina
        new PrimaryReader(this,noticias,false).execute("noticias","1");
        new PrimaryReader(this, boletines , true).execute("boletines","1");


    }
}
