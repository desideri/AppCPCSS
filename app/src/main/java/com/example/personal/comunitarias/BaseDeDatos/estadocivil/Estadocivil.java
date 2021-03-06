/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.personal.comunitarias.BaseDeDatos.estadocivil;

import android.util.Log;

import com.example.personal.comunitarias.DatabaseRemote.Conexion;
import com.example.personal.comunitarias.DatabaseRemote._Default;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kattya Desiderio
 */
public class Estadocivil extends _Default {
    int idestadocivil; //pk
    String nombre;

    public Estadocivil() {
        idestadocivil=-1;
        nombre="";
    }

    public int getID_DB(String nombre){
        int id_encontrada=-1;

        //Establecemos la conexión
        Conexion c = null;
        try {
            c = new Conexion();
            Connection conn= c.getConn();

            //Creamos el query
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM estadocivil WHERE nombre='"+nombre+"';");

            if (resultSet != null) {
                resultSet.next();
                id_encontrada=resultSet.getInt("id");
            }
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            this._status = false;
        } catch (SQLException e) {
            e.printStackTrace();
            this._status = false;
        }
        return id_encontrada;
    }

    //Obtener la lista de estadoCivil
    public ArrayList<Estadocivil> getListaEstadoCivil()  {
        ArrayList<Estadocivil> lista = new ArrayList<>();

        //Establecemos la conexión
        Conexion c = null;
        try {
            c = new Conexion();
            Connection conn= c.getConn();

            //Creamos el query
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM estadocivil;");

            if (resultSet != null){
                while (resultSet.next()){
                    Estadocivil obj = new Estadocivil();
                    obj.setIdestadocivil(resultSet.getInt("id"));
                    obj.setNombre(resultSet.getString("nombre"));
                    lista.add(obj);
                    obj = null;
                }
            }
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            this._status = false;
        } catch (SQLException e) {
            e.printStackTrace();
            this._status = false;
        }

        return lista;
    }

    //Obtener la lista de estadoCivil
    public ArrayList<String> getListaEstadoCivilNombres()  {
        ArrayList<String> lista = new ArrayList<>();
        Log.e("Funcion:","ANTES1 de entrar");
        //Establecemos la conexión
        Conexion c = null;

        try {
            c = new Conexion();
            Connection conn= c.getConn();

            //Creamos el query
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM estadocivil;");
            Log.e("Funcion:","ANTES de entrar");

            if (resultSet != null){
                while (resultSet.next()){
                    Log.e("Funcion:",resultSet.getString("nombre") );
                    lista.add(resultSet.getString("nombre"));
                }
            }
            conn.close();
        } catch (ClassNotFoundException e) {
            Log.e("ERROR: ","EstadoCivil; "+ e);
            e.printStackTrace();
            this._status = false;
        } catch (SQLException e) {
            Log.e("ERROR: ","EstadoCivil; "+ e);
            e.printStackTrace();
            this._status = false;
        }

        return lista;
    }

    public int getIdestadocivil() {
        return idestadocivil;
    }

    public void setIdestadocivil(int estadocivil) {
        this.idestadocivil = estadocivil;
    }

    public Estadocivil(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
