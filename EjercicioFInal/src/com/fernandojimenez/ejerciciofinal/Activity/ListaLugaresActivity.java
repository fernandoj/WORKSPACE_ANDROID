package com.fernandojimenez.ejerciciofinal.Activity;

import java.util.ArrayList;
import java.util.List;

import com.fernandojimenez.ejerciciofinal.R;
import com.fernandojimenez.ejerciciofinal.R.layout;

import DAO.LugaresDAO;
import Persistencia.Lugar;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListaLugaresActivity extends Activity {
	
    LugaresDAO dao=new LugaresDAO();
	@Override
    public void onCreate(Bundle savedInstanceState) {
		final UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "BD", null, 1);
	    final SQLiteDatabase db = usdbh.getWritableDatabase();
		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.listalugares);
        
      /**
      * Cargamos los lugares de la base de datos
      */
        ListView listView= recargarContenido(db);
        /**
         * Evento onClick de los Items del menu
         */
        listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				ListAdapter la = (ListAdapter) parent.getAdapter();
				String texto = (String) la.getItem(position);
				
				Toast.makeText(view.getContext(), texto,Toast.LENGTH_SHORT).show();
			
				SQLiteDatabase db = usdbh.getWritableDatabase();
			    Lugar lugar=dao.getLugarByDescripcion(texto, db);
					        	    
	                Intent intent = new Intent();
    	            intent.setClass(getApplicationContext(),MostrarLugarActivity.class);
    	            intent.putExtra("id",lugar.getId());
    	            intent.putExtra("nombre",lugar.getNombre());
    	            intent.putExtra("descripcion",lugar.getDescripcion());
    	    		intent.putExtra("latitud",lugar.getLatitud());
    	    		intent.putExtra("longitud",lugar.getLongitud());
    	    		intent.putExtra("foto",lugar.getFoto());
    	        
    	    		startActivity(intent);
		}});
               
        
    }
	@Override
	protected void onResume() {
		super.onResume();
		final UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "BD", null, 1);
	    final SQLiteDatabase db = usdbh.getWritableDatabase();
		recargarContenido(db);
		
	}
	
	public ListView recargarContenido(SQLiteDatabase db)
	{
		 List<String> listado=new ArrayList<String>();
	       	List<Lugar> lugares=dao.getListaLugares(db);
	        	    
	        for (int i = 0; i < lugares.size(); i++) {
				listado.add(lugares.get(i).getDescripcion());
			}
	        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listado);
	        ListView listView = (ListView)findViewById(android.R.id.list);
	        listView.setAdapter(adapter);
			return listView;
	}
}
