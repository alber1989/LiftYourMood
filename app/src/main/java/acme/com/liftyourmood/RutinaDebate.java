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

        //con un iterador, quitamos las distorsiones que no hemos seleccionado, ya que nos han llegado vacías.

        Iterator itr = distorsionesSeleccionadasArrayList.iterator();
        while (itr.hasNext())
        {
            String x = (String) itr.next();
            if (x.equals(""))
                itr.remove();
        }

        // A través del manejador/adaptador, le metemos al listview las distorsiones

        AdaptadorDistorsiones adaptador = new AdaptadorDistorsiones(this);
        ListView lv1 = findViewById(R.id.listaDistorsionesSeleccionadas);
        lv1.setAdapter(adaptador);

    }

    //con este manejador colocamos las distorsiones en la listview correspondiente
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