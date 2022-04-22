package acme.com.liftyourmood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class RutinaDebate extends AppCompatActivity {

    private ArrayList<String> distorsionesSeleccionadasArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina_debate);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String[] distorsionesSeleccionadas = intent.getStringArrayExtra(MenuSeleccionDistorsiones.DISTORSIONES_SELECCIONADAS);

        distorsionesSeleccionadasArrayList = new ArrayList<String>(Arrays.asList(distorsionesSeleccionadas));

        Iterator itr = distorsionesSeleccionadasArrayList.iterator();
        while (itr.hasNext())
        {
            String x = (String) itr.next();
            if (x.equals(""))
                itr.remove();
        }







/*

        for(int i = 0; i< distorsionesSeleccionadas.length; i++){

            if(distorsionesSeleccionadas[i].equals("")) i++;
            if(i == distorsionesSeleccionadas.length) return;

            distorsionesSeleccionadasArrayList.add(distorsionesSeleccionadas[i]);

        }*/




        AdaptadorDistorsiones adaptador = new AdaptadorDistorsiones(this);
        ListView lv1 = findViewById(R.id.listaDistorsionesSeleccionadas);
        lv1.setAdapter(adaptador);





        //for  (int i=0; i<distorsionesSeleccionadas.length; i++)
        //           Toast.makeText(this, distorsionesSeleccionadas[i], Toast.LENGTH_SHORT).show();

        //Toast.makeText(this, nombreUsuario, Toast.LENGTH_SHORT).show();


    /*
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







            }*/


    }

    class AdaptadorDistorsiones extends ArrayAdapter<String> {

        AppCompatActivity appCompatActivity;

        AdaptadorDistorsiones(AppCompatActivity context) {
            super(context, R.layout.distorsion_seleccionada, distorsionesSeleccionadasArrayList);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.distorsion_seleccionada ,null);

            TextView textView1 = item.findViewById(R.id.textViewDistorsion);
            textView1.setText(distorsionesSeleccionadasArrayList.get(position));

            return(item);
        }
    }


}