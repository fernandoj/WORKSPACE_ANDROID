package com.fernando.lugares;

import Persistencia.Lugar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MostrarLugarActivity extends Activity {
    /** Called when the activity is first created. */
    Lugar lugar=new Lugar();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrarlugar);
	
        

        /**
         * Boton Lista
         */
       Button botonEditar = (Button) findViewById(R.id.BotonEditar_mostrarLugar);
        // Manipulando el Botton
        botonEditar.setOnClickListener(new OnClickListener() {
   	        public void onClick(View v) {
   	        	/**
   	        	 * Creamos Intent y llamamos a la siguiente actividad
   	        	 */
   	        	Intent intent = new Intent();
   	    		intent.setClass(getApplicationContext(),EditarLugarActivity.class);
   	    		
   	    	    intent.putExtra("id",lugar.getId());
	            intent.putExtra("nombre",lugar.getNombre());
	            intent.putExtra("descripcion",lugar.getDescripcion());
	    		intent.putExtra("latitud",lugar.getLatitud());
	    		intent.putExtra("longitud",lugar.getLongitud());
	    		intent.putExtra("foto",lugar.getFoto());
   	    		
   	    		
   	    		startActivity(intent);
   	    	    	}
           });
    }
    @Override
    protected void onResume() {
    	super.onResume();
    	
    }
    public void recargarContenido()
	{
    	Bundle datos = this.getIntent().getExtras();
		
		lugar.setId(datos.getInt("id"));
		lugar.setDescripcion(datos.getString("descripcion"));
		lugar.setNombre(datos.getString("nombre"));
		lugar.setLatitud(datos.getLong("latitud"));
		lugar.setLongitud(datos.getLong("longitud"));
		lugar.setFoto(datos.getString("foto"));

    	/**
		 * Asignar valores a los campos
		 */
		TextView campoNombreMostrarLugar = (TextView) findViewById(R.id.campoNombreMostrarLugar); 
		campoNombreMostrarLugar.setText("");
		campoNombreMostrarLugar.setText(lugar.getNombre());
		campoNombreMostrarLugar.setLines(campoNombreMostrarLugar.getLineCount()+1);
		TextView campoDescripcionMostrarLugar= (TextView) findViewById(R.id.campoDescripcionMostrarLugar);
		
		campoDescripcionMostrarLugar.setText("");
		campoDescripcionMostrarLugar.setText(lugar.getDescripcion());
		campoDescripcionMostrarLugar.setLines(campoDescripcionMostrarLugar.getLineCount()+1);
	}	
}