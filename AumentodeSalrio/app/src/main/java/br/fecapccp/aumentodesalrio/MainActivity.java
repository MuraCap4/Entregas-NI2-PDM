package br.fecapccp.aumentodesalrio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnSet;
    private TextView textResultado;
    private RadioButton rbValor1, rbValor2, rbValor3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText campoSalario = findViewById(R.id.editTextSalario);
        btnSet = findViewById(R.id.btnSet);
        textResultado = findViewById(R.id.textResultado);

        rbValor1 = findViewById(R.id.rbValor1);
        rbValor2 = findViewById(R.id.rbValor2);
        rbValor3 = findViewById(R.id.rbValor3);

        btnSet.setOnClickListener(view -> {
            double salario = Double.parseDouble(campoSalario.getText().toString());

            if(rbValor1.isChecked()) {
                double resultado = salario + (salario * 0.4);
                textResultado.setText("O seu novo salário será R$" + resultado);
            } else if (rbValor2.isChecked()) {
                double resultado = salario + (salario * 0.45);
                textResultado.setText("O seu novo salário será R$" + resultado);
            } else if (rbValor3.isChecked()) {
                double resultado = salario + (salario * 0.50);
                textResultado.setText("O seu novo salário será R$" + resultado);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}