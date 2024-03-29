package com.fernandojimenez.ejerciciofinal.Activity;

import java.util.ArrayList;
import java.util.List;


import android.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.fernandojimenez.ejerciciofinal.DAO.LugaresSQLiteHelper;
import com.fernandojimenez.ejerciciofinal.Persistencia.Lugar;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class PrincipalActivity extends Activity {
	List<Lugar> lugares=new ArrayList<Lugar>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		
		//Creamos objetos en la base de datos
		//setLugaresFromDB();
		
		
		//Obtenemos los lugares para pintarlos en la lista
		lugares=getLugaresFromDB();
		lugares.size();
		
		Log.println(0, "info", lugares.size()+"");
		
		Button lista = (Button) findViewById(R.id.lista);
		Button mapa = (Button) findViewById(R.id.mapa);
		Button nuevo = (Button) findViewById(R.id.nuevo);
		
		//Lista
		lista.setOnClickListener(new OnClickListener() {
	         public void onClick(View v) {
	        	 String lugareJson = JSONParser.parseJsonLugares(lugares);
	        	 
	        	Intent intent = new Intent(PrincipalActivity.this, ListaLugaresActivity.class);
	        	intent.putExtra("listaLugares", lugareJson);
	            startActivity(intent);
	         }
	      });
		
		//Mapa
		 mapa.setOnClickListener(new OnClickListener() {
	         public void onClick(View v) {
	            Intent intent = new Intent(PrincipalActivity.this, MapaLugaresActivity.class);
	            startActivity(intent);
	         }
	      });
		
		 //Nuevo
		 nuevo.setOnClickListener(new OnClickListener() {
	         public void onClick(View v) {
	            Intent intent = new Intent(PrincipalActivity.this, EditarLugarActivity.class);
	            intent.putExtra("lugar", "");
	            startActivity(intent);
	         }
	      });
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}
	
	public void setLugaresFromDB()
	{
		//Abrimos la base de datos 'DBUsuarios' en modo escritura
		LugaresSQLiteHelper usdbh =
            new LugaresSQLiteHelper(this, "DBUsuarios", null, 1);
 
        SQLiteDatabase db = usdbh.getWritableDatabase();
 
        //Si hemos abierto correctamente la base de datos
        if(db != null)
        {
            //Insertamos 5 usuarios de ejemplo
            for(int i=1; i<=5; i++)
            {
                //Generamos los datos
                int codigo = i;
                String nombre = "Usuario" + i;
                String Descripcion = "Descripcion" + i;
                String Latitud = "Latitud" + i;
                String Longitud = "Longitud" + i;
                String Foto = "Foto" + i;
 
                //Insertamos los datos en la tabla Usuarios
                db.execSQL("INSERT INTO LUGARES (_id, nombre,descripcion,latitud,longitud,foto) " +
                           "VALUES (" + codigo + ", '" + nombre +"','" + Descripcion +"','" + Latitud +"','" + Longitud +"','" + Foto +"')");
            }
 
            //Cerramos la base de datos
            db.close();
        }
	}
	
	/**
	 * Metodo que reucpera de base de datos TODO: lleva a un dao todo
	 */
	public List<Lugar> getLugaresFromDB()
	{
		List<Lugar> lugares=new ArrayList<Lugar>();
		
		
		//String[] args = new String[] {"usu1"};
		//Cursor c = db.rawQuery(" SELECT codigo,nombre FROM Usuarios WHERE nombre=? ", args);
		
		//Abrimos la base de datos 'DBUsuarios' en modo escritura
		LugaresSQLiteHelper usdbh = new LugaresSQLiteHelper(this, "LUGARES", null, 1);
		
		//bd
		SQLiteDatabase db = usdbh.getWritableDatabase();
		Cursor c = db.rawQuery(" SELECT * FROM LUGARES", null);
        
		//Nos aseguramos de que existe al menos un registro
		if (c.moveToFirst()) {
		     //Recorremos el cursor hasta que no haya m�s registros
		     do {
		    	 Lugar l=new Lugar();
		    	 l.setId(c.getLong(0));
		    	 l.setNombre(c.getString(1));
		    	 l.setDescripcion(c.getString(2));
		    	 l.setLatitud(c.getString(3));
		    	 l.setLongitud(c.getString(4));
		    	 l.setTextoFoto(c.getString(5));
		    	 lugares.add(l);
		     } while(c.moveToNext());
		}
        //Cerramos la base de datos
        db.close();
        return lugares;
	}
	

}
