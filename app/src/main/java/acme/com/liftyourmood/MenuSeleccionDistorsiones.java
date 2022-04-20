package acme.com.liftyourmood;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MenuSeleccionDistorsiones extends AppCompatActivity {

    String[] distorsionesDisponibles;      // = new String[3]{"Catastrofizacion","RazonamientoEmocional","PrediccionFuturo"};
    String[] distorsionesSeleccionadas = new String[]{"","",""};


    public static final String DISTORSIONES_SELECCIONADAS = "acme.com.liftyourmood"; //Lo usaremos para el Intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_seleccion_distorsiones);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String nombreUsuario = intent.getStringExtra(MainActivity.NOMBRE_DE_USUARIO);

        //Toast.makeText(this, nombreUsuario, Toast.LENGTH_SHORT).show();
        // Capture the layout's TextView and set the string as its text
        if(nombreUsuario != null) {
            TextView textView = (TextView) findViewById(R.id.pruebaNombre);
            textView.setText(nombreUsuario);
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox)view).isChecked();


        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_catastrof_DC:
                if (checked){

                    //Toast.makeText(this, "Funciona Checkbox", Toast.LENGTH_SHORT).show();
                  distorsionesSeleccionadas[0] = ((CheckBox)view).getText().toString();

                }

            else
                    distorsionesSeleccionadas[0] = "";
                break;
            case R.id.checkbox_prediccion_DC:
                if (checked)
                    distorsionesSeleccionadas[1] = ((CheckBox)view).getText().toString();
            else
                    distorsionesSeleccionadas[1] = "";
                break;

            case R.id.checkbox_remocional_DC:
                if (checked)
                    distorsionesSeleccionadas[2] = ((CheckBox)view).getText().toString();
            else
                    distorsionesSeleccionadas[2] = "";
                break;
            default:


        }
    }

    public void enviarDistorsionesADebate(View view){


        //Toast.makeText(this, nombreUsuarioEnviar, Toast.LENGTH_SHORT).show();

     //   for  (int i=0; i<distorsionesSeleccionadas.length; i++)
     //       Toast.makeText(this, distorsionesSeleccionadas[i], Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, RutinaDebate.class);
        intent.putExtra(DISTORSIONES_SELECCIONADAS, distorsionesSeleccionadas);
        startActivity(intent);


    }
    
}
