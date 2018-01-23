package net.agusharyanto.hargaminuman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextKopi;
    private EditText editTextCoklat;
    private EditText editTextJahe;
    private Button buttonHitung;
    private TextView textViewHarga;
    int kopi = 10000;
    int coklat = 15000;
    int jahe = 5000;

    int jmlkopi =0;
    int jmlcoklat =0;
    int jmljahe = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextKopi = (EditText) findViewById(R.id.editTextKopi);
        editTextCoklat = (EditText) findViewById(R.id.editTextCoklat);
        editTextJahe = (EditText) findViewById(R.id.editTextJahe);
        buttonHitung = (Button) findViewById(R.id.buttonHitung);
        textViewHarga = (TextView) findViewById(R.id.textViewTotalHarga);
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungHarga();
            }
        });
    }

    private void hitungHarga() {

            try {
                jmlkopi = Integer.parseInt(editTextKopi.getText().toString());
            }catch (java.lang.NumberFormatException e){
                jmlkopi=0;
            }
            try {
                jmlcoklat = Integer.parseInt(editTextCoklat.getText().toString());
            }catch (Exception e){
                jmlcoklat=0;
            }
            try {
                jmljahe = Integer.parseInt(editTextJahe.getText().toString());

            }catch (java.lang.NumberFormatException e){
                jmljahe = 0;
            }

        int totalharga = (kopi * jmlkopi) + (coklat * jmlcoklat) + (jahe * jmljahe);

        textViewHarga.setText("Total Harga :" + totalharga);

       /* if (isValidInput()) {
            int jmlkopi = Integer.parseInt(editTextKopi.getText().toString());
            int jmlcoklat = Integer.parseInt(editTextCoklat.getText().toString());
            int jmljahe = Integer.parseInt(editTextJahe.getText().toString());
            int totalharga = (kopi * jmlkopi) + (coklat * jmlcoklat) + (jahe * jmljahe);
            textViewHarga.setText("Total Harga :" + totalharga);
        }
        */

    }


    private boolean isValidInput(){
        if (editTextKopi.getText().toString().equals("")){
            Toast.makeText(this, "Kopi Harus diisi", Toast.LENGTH_SHORT).show();
            editTextKopi.setText("0");
            jmlkopi=0;
            return false;
        }
        if (editTextCoklat.getText().toString().equals("")){
            Toast.makeText(this, "Coklat Harus diisi", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (editTextJahe.getText().toString().equals("")){
            Toast.makeText(this, "Jahe Harus diisi", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }
}
