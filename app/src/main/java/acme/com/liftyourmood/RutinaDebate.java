package acme.com.liftyourmood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

public class RutinaDebate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina_debate);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String[] distorsionesSeleccionadas = intent.getStringArrayExtra(MenuSeleccionDistorsiones.DISTORSIONES_SELECCIONADAS);

        //for  (int i=0; i<distorsionesSeleccionadas.length; i++)
        //           Toast.makeText(this, distorsionesSeleccionadas[i], Toast.LENGTH_SHORT).show();

        //Toast.makeText(this, nombreUsuario, Toast.LENGTH_SHORT).show();



        if(distorsionesSeleccionadas != null) {
            for(int i = 0; i<distorsionesSeleccionadas.length;i++){

                if(distorsionesSeleccionadas[i].equals("")) i++;
                if(i == distorsionesSeleccionadas.length) return;


                    LinearLayout linearLayout = findViewById(R.id.linearLayoutRutina);
                    // Create TextView programmatically.
                    TextView[] distorsionDisplayedRutinaArray = new TextView[distorsionesSeleccionadas.length];
                    distorsionDisplayedRutinaArray[i] = new TextView(this);
                    distorsionDisplayedRutinaArray[i].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    distorsionDisplayedRutinaArray[i].setGravity(Gravity.CENTER);
                    distorsionDisplayedRutinaArray[i].setText(distorsionesSeleccionadas[i] + " ");

                    if (linearLayout != null) {
                        linearLayout.addView(distorsionDisplayedRutinaArray[i]);
                    }

                }







            }


    }


}