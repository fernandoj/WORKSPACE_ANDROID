
package com.fernandojimenez.ejerciciofinal.Activity;

import com.fernandojimenez.ejerciciofinal.R;
import com.fernandojimenez.ejerciciofinal.DAO.UsuariosSQLiteHelper;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class AndroidBaseDatosActivity extends Activity {
	  @Override
	    public void onCreate(Bundle savedInstanceState)
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        //Abrimos la base de datos 'DBUsuarios' en modo escritura
	        UsuariosSQLiteHelper usdbh =
	            new UsuariosSQLiteHelper(this, "BD", null, 1);
	        SQLiteDatabase db = usdbh.getWritableDatabase();
	 
	        //Si hemos abierto correctamente la base de datos
	        if(db != null)
	        {
	            //Insertamos 5 usuarios de ejemplo
	            for(int i=1; i<=5; i++)
	            {   //Insertamos los datos en la tabla Usuarios
	                db.execSQL("INSERT INTO Lugares (Nombre, Descripcion, Latitud, Longitud, Foto) VALUES (" +
	                		"'Lugar A', '"+i+"', 20, 20, 'RUTADELAFOTO')");  
	            }
	            //Cerramos la base de datos
	            db.close();
	        }
	        Log.i("INFO", "inserccion realizada");
	    }
}
