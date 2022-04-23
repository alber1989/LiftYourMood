package acme.com.liftyourmood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
TODO 200422: ya tenemos la lista de distorsiones y el envío al cambio de activity
    nos queda:
        - Hacer la vista que contenga el pensamiento distorsionado
        - Una nueva view con la que poner el pensamiento racional resultante
 */

public class MainActivity extends AppCompatActivity {

    public static final String NOMBRE_DE_USUARIO = "acme.com.liftyourmood";
    String nombreUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button facetaPresente = findViewById(R.id.buttonPresente);

        EditText campoNombreUsuario = (EditText) findViewById(R.id.campoNombreUsuario);



        facetaPresente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                nombreUsuario = campoNombreUsuario.getText().toString();
                seleccionarFaceta(facetaPresente, nombreUsuario);
            }
        });





    }
                //seleccionamos la faceta que queremos trabajar y nos vamos a su activity correspondiente
    public void seleccionarFaceta(View view, String nombreUsuarioEnviar){


        //Toast.makeText(this, nombreUsuarioEnviar, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MenuSeleccionDistorsiones.class);
        intent.putExtra(NOMBRE_DE_USUARIO, nombreUsuarioEnviar);
        startActivity(intent);

    }
}