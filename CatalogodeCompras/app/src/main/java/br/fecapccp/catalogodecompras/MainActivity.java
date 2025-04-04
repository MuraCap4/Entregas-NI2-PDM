package br.fecapccp.catalogodecompras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkArroz, checkLeite, checkCarne, checkFeijao, checkRefri;

    private TextView textResultado;

    private Button btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        checkArroz = findViewById(R.id.checkArroz);
        checkLeite = findViewById(R.id.checkLeite);
        checkCarne = findViewById(R.id.checkCarne);
        checkFeijao = findViewById(R.id.checkFeijao);
        checkRefri = findViewById(R.id.checkRefri);

        btnSet = findViewById(R.id.btnSet);

        textResultado = findViewById(R.id.textResultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void checkBox(View view) {
        double valorTotal = 0.0;
        if(checkArroz.isChecked()) {
            valorTotal += 2.69;
        }
        if(checkLeite.isChecked()) {
            valorTotal += 2.70;
        }
        if(checkCarne.isChecked()) {
            valorTotal += 16.70;
        }
        if(checkFeijao.isChecked()) {
            valorTotal += 3.38;
        }
        if(checkRefri.isChecked()) {
            valorTotal +=3;
        }

        textResultado.setText("O resultado é: R$" + valorTotal);
    }
}