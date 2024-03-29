package com.fernandojimenez.ejerciciofinal.Activity;

import com.fernandojimenez.ejerciciofinal.DAO.LugaresDAO;
import com.fernandojimenez.ejerciciofinal.DAO.UsuariosSQLiteHelper;
import com.fernandojimenez.ejerciciofinal.Persistencia.Lugar;

import android.R;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarLugarActivity extends Activity {
    /** Called when the activity is first created. */
	Lugar lugar=new Lugar();
	LugaresDAO dao=new LugaresDAO();
	@Override
    public void onCreate(Bundle savedInstanceState) {
		UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "BD", null, 1);
		final SQLiteDatabase db = usdbh.getWritableDatabase();
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editarlugar);
        
        Bundle datos = this.getIntent().getExtras();
		
		lugar.setId(datos.getInt("id"));
		lugar.setDescripcion(datos.getString("descripcion"));
		lugar.setNombre(datos.getString("nombre"));
		lugar.setLatitud(datos.getLong("latitud"));
		lugar.setLongitud(datos.getLong("longitud"));
		lugar.setFoto(datos.getString("foto"));
        
		final EditText nombreTextEditarLugar=  (EditText) findViewById(R.id.nombreTextEditarLugar);
		nombreTextEditarLugar.setText(lugar.getNombre());
		
		
		final EditText descripcionTextEditarLugar=  (EditText) findViewById(R.id.descripcionTextEditarLugar);
		descripcionTextEditarLugar.setText(lugar.getDescripcion());
		
	    Button cancel = (Button) findViewById(R.id.BotonCancelarEditarLugar);
        // Manipulando el Botton
	    cancel.setOnClickListener(new OnClickListener() {
   	        public void onClick(View v) {
   	        	/**
   	        	 * Creamos Intent y llamamos a la siguiente actividad
   	        	 */
   	        	finish();
   	        }
           });
        Button save = (Button) findViewById(R.id.BotonGuardarEditarLugar);
        // Manipulando el Botton
	    save.setOnClickListener(new OnClickListener() {
   	        public void onClick(View v) {
   	 	    	//Si se a modifcado alguno de los dos textbox TODO: Faltaria comprobar la imagen
   	        	if (!descripcionTextEditarLugar.getText().equals(lugar.getDescripcion()) || 
   	          			!nombreTextEditarLugar.getText().equals(lugar.getNombre())) {
					//Guardamos en la base de datos
   	        		String sql=
   	        			"Update LUGARES set nombre='"+nombreTextEditarLugar.getText()+"', descripcion='"
   	        			+descripcionTextEditarLugar.getText()+"', Latitud="+lugar.getLatitud()+", Longitud="+lugar.getLongitud()+" where _id="+lugar.getId()+"";
   	        		
   	        		try {
   	        			dao.Update(sql, db);	
					} catch (Exception e) {
						Toast.makeText(v.getContext(),"No se a podido actualizar en la base de datos.",Toast.LENGTH_SHORT).show();
					}
   	        		finish();
   	    		}//END_IF        	
   	        }
           });
 
    }
}