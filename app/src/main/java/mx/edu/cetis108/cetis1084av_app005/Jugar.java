package mx.edu.cetis108.cetis1084av_app005;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Jugar extends AppCompatActivity {

    TextView Puntos,Contador,Vidas,txtCorrecto,txtIncorrecto;
    ImageView Imagen;
    EditText txtEdit;
    Button btnConfirmar;

    String [] nombre_pers={"Wolverine","Black Panther"};
    String [] nombre_pers2={"wolverine","black panther"};
    String [] imagen_pers={"img1","img2"};

    int intPunto=0;
    int intVidas=3;
    int numerogenerado= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        txtCorrecto= (TextView) findViewById(R.id.txtCorrecto);
        txtIncorrecto= (TextView) findViewById(R.id.txtIncorrecto);

        Puntos= (TextView) findViewById(R.id.Puntos);
        Vidas= (TextView) findViewById(R.id.Vidas);
        Contador= (TextView) findViewById(R.id.Cuenta);
        Imagen= (ImageView) findViewById(R.id.imgWolverine);
        txtEdit= (EditText) findViewById(R.id.txtEdit);
        btnConfirmar= (Button) findViewById(R.id.btnConfirmar);

        establecer_imagen(numerogenerado);


        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoconfirmar= txtEdit.getText().toString().toLowerCase();
                if (textoconfirmar.equals(nombre_pers[numerogenerado]) | textoconfirmar.equals(nombre_pers2[numerogenerado])){

                    txtCorrecto.setVisibility(View.VISIBLE);
                    intPunto=intPunto+1;
                    Puntos.setText("Puntos: " + intPunto);
                    esperar1();

                }
                else {

                    txtIncorrecto.setVisibility(View.VISIBLE);
                    intVidas=intVidas-1;
                    Vidas.setText("Vidas: " + intVidas);
                    esperar2();

                };
            }
        });
    }

    void esperar2 () {
        new CountDownTimer(2000,1) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnConfirmar.setVisibility(View.GONE);

            }

            @Override
            public void onFinish() {
                btnConfirmar.setVisibility(View.VISIBLE);
                txtIncorrecto.setVisibility(View.INVISIBLE);
                txtEdit.setText("");
                txtEdit.setHint("Ingrese el personaje");

            }
        }.start();
    }

    void esperar1 (){
        new CountDownTimer(3000,1) {
            @Override
            public void onTick(long millisUntilFinished) {
                Contador.setText("" + (millisUntilFinished/1000 + 1));
                btnConfirmar.setVisibility(View.GONE);

            }

            @Override
            public void onFinish() {
                btnConfirmar.setVisibility(View.VISIBLE);
                numerogenerado=numerogenerado+1;
                Contador.setText("");
                establecer_imagen(numerogenerado);
                txtCorrecto.setVisibility(View.INVISIBLE);
                txtEdit.setText("");
                txtEdit.setHint("Ingrese el personaje");

            }
        }.start();
    }

    void establecer_imagen (int numero){
        int id = getResources().getIdentifier(imagen_pers[numero],"mipmap",getPackageName());
        Imagen.setImageResource(id);

    }
}
