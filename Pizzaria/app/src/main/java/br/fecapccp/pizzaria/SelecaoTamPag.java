package br.fecapccp.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelecaoTamPag extends AppCompatActivity {

    private Button btnT2Set;
    private RadioButton rbPeq, rbMedio, rbGrande, rbCard, rbDin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selecao_tam_pag);

        btnT2Set = findViewById(R.id.btnT2Set);

        rbPeq = findViewById(R.id.rbPeq);
        rbMedio = findViewById(R.id.rbMedio);
        rbGrande = findViewById(R.id.rbGrande);
        rbCard = findViewById(R.id.rbCard);
        rbDin = findViewById(R.id.rbDin);

        Bundle bundle = getIntent().getExtras();

        String sabor1 = bundle.getString("sabor1");
        String sabor2 = bundle.getString("sabor2");
        String sabor3 = bundle.getString("sabor3");


        btnT2Set.setOnClickListener(view -> {

            Intent intent = new Intent(this, ResumoPedido.class);

            String pagCard = "";
            String pagDin = "";
            String tamPeq = "";
            String tamMed = "";
            String tamGran = "";
            double pedido = 0.0;
            if(rbPeq.isChecked()) {
                pedido += 34.90;
                tamPeq = "Pequeno";
                intent.putExtra("pedido", pedido);
            }
            if(rbMedio.isChecked()) {
                pedido += 45.90;
                tamMed = "Médio";
                intent.putExtra("pedido", pedido);
            }
            if(rbGrande.isChecked()) {
                pedido += 62.90;
                tamGran = "Grande";
                intent.putExtra("pedido", pedido);
            }

            if(rbCard.isChecked()) {
                pagCard = "Cartão - Débito / Crédito";
            }
            if(rbDin.isChecked()) {
                pagDin = "Dinheiro";
            }

            intent.putExtra("pagDin", pagDin);
            intent.putExtra("pagCard", pagCard);

            intent.putExtra("tamPeq", tamPeq);
            intent.putExtra("tamMed", tamMed);
            intent.putExtra("tamGran", tamGran);

            intent.putExtra("sabor1", sabor1);
            intent.putExtra("sabor2", sabor2);
            intent.putExtra("sabor3", sabor3);


            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}