package br.fecapccp.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnT1Set;
    private CheckBox cbSabor1, cbSabor2, cbSabor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Vinculando o btnT1Set com o Views pela id:
        btnT1Set = findViewById(R.id.btnT1Set);

        cbSabor1 = findViewById(R.id.cbSabor1);
        cbSabor2 = findViewById(R.id.cbSabor2);
        cbSabor3 = findViewById(R.id.cbSabor3);

        btnT1Set.setOnClickListener(view -> {
            // Qual tela vou chamar após clicar nesse botão:
            Intent intent = new Intent(this, SelecaoTamPag.class);

            String sabor1 = "";
            String sabor2 = "";
            String sabor3 = "";

            if(cbSabor1.isChecked()) {
                sabor1 = "Calabresa";
            }
            if(cbSabor2.isChecked()) {
                sabor2 = "Marguerita";
            }
            if(cbSabor3.isChecked()) {
                sabor3 = "Portuguesa";
            }
            intent.putExtra("sabor1", sabor1);
            intent.putExtra("sabor2", sabor2);
            intent.putExtra("sabor3", sabor3);

            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}