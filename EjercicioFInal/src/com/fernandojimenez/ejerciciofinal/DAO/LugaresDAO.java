package com.fernandojimenez.ejerciciofinal.DAO;

import java.util.ArrayList;
import java.util.List;

import com.fernandojimenez.ejerciciofinal.Persistencia.Lugar;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class LugaresDAO {
		
	
	public Lugar getLugarById(int _id, SQLiteDatabase db)
		{
		Lugar l =new Lugar();
		/**
		 * Recuperamos de base de datos el lugar
		 */
		
		
		l.setId(_id);
			return l;
		}
	
	public List<Lugar> getListaLugares(SQLiteDatabase db)
	{
	List<Lugar> lugares=new ArrayList<Lugar>();
	
	    Cursor cursor = db.rawQuery("SELECT * FROM LUGARES", null);
   	 
	    if (cursor.moveToFirst()) {
	        do {
	            Lugar lugar = new Lugar();
	            lugar.setId(Integer.parseInt(cursor.getString(0)));
	            lugar.setDescripcion((cursor.getString(1)));
	            lugar.setLatitud(cursor.getString(2));
	            lugar.setLongitud(cursor.getString(3));
	            lugar.setFoto((cursor.getString(4)));
	            
	            // Adding contact to list
	            lugares.add(lugar);
	        } while (cursor.moveToNext());
	        
	    }
	    db.close();
	    return lugares;
	}

	public Lugar getLugarByDescripcion(String texto, SQLiteDatabase db) {
		Cursor cursor = db.rawQuery("SELECT * FROM LUGARES where nombre = '"+ texto +"'", null);
	    Lugar lugar = new Lugar();
		if (cursor.moveToNext()) {
    	            lugar.setId(Integer.parseInt(cursor.getString(0)));
    	            lugar.setNombre(cursor.getString(1));
    	            lugar.setDescripcion((cursor.getString(2)));
    	            lugar.setLatitud(cursor.getString(3));
    	            lugar.setLongitud(cursor.getString(4));
    	            lugar.setFoto((cursor.getString(5)));
    	            
    	        	    }
    	    db.close();
		return lugar;
	}

	public void excuteSQL(String sql, SQLiteDatabase db) {
		/*
		 * Metodo que ejecuta cualquier sql
		 */
		db.execSQL(sql);
   		db.close();
		
	}


}
