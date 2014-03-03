package com.fernandojimenez.ejerciciofinal.Activity;

import com.fernandojimenez.ejerciciofinal.R;
import com.fernandojimenez.ejerciciofinal.R.id;
import com.fernandojimenez.ejerciciofinal.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LugaresActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /**
         * Boton Lista
         */
        Button botonLista = (Button) findViewById(R.id.listar);
        // Manipulando el Botton
        botonLista.setOnClickListener(new OnClickListener() {
   	        public void onClick(View v) {
   	        	/**
   	        	 * Creamos Intent y llamamos a la siguiente actividad
   	        	 */
   	        	Intent intent = new Intent();
   	    		intent.setClass(getApplicationContext(),ListaLugaresActivity.class);
   	    		startActivity(intent);
   	        }
           });
        
        Button bd = (Button) findViewById(R.id.DB);
        // Manipulando el Botton
        bd.setOnClickListener(new OnClickListener() {
   	        public void onClick(View v) {
   	        	/**
   	        	 * Creamos Intent y llamamos a la siguiente actividad
   	        	 */
   	        	Intent intent = new Intent();
   	    		intent.setClass(getApplicationContext(),AndroidBaseDatosActivity.class);
   	    		startActivity(intent);
   	        }
           });
 }
}