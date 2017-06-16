package mx.edu.cetis108.cetis1084av_app005;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {
    Button btnJugar,btnRespuestas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnJugar= (Button) findViewById(R.id.Jugar);
        btnRespuestas= (Button) findViewById(R.id.Respuestas);


        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagina2 = new Intent(Inicio.this,Jugar.class);
                startActivity(pagina2);
            }
        });

        btnRespuestas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagina3 = new Intent(Inicio.this,Respuestas.class);
                startActivity(pagina3);
            }
        });
    }
}
