package br.fecapccp.lanchefcil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormularioPedido extends AppCompatActivity {

    private CheckBox cbLanche1, cbLanche2, cbLanche3;
    private Button btnT2Set;
    private EditText textNome;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_pedido);

        cbLanche1 = findViewById(R.id.cbLanche1);
        cbLanche2 = findViewById(R.id.cbLanche2);
        cbLanche3 = findViewById(R.id.cbLanche3);

        btnT2Set = findViewById(R.id.btnT2Set);

        textNome = findViewById(R.id.textNome);

        //CheckBox();

        btnT2Set.setOnClickListener(view -> {
            String nome = textNome.getText().toString();

            Intent intent = new Intent(this, PedidoFinalizado.class);

            intent.putExtra("nome", nome);

            double pedido = 0.0;
            String lanche1 = "";
            String lanche2 = "";
            String lanche3 = "";
            if(cbLanche1.isChecked()) {
                pedido += 34.90;
                lanche1 = "Felicidade em Pão com Carne";
                intent.putExtra("pedido", pedido);
            }
            if(cbLanche2.isChecked()) {
                pedido += 30.90;
                lanche2 = "Fácil e Rápido";
                intent.putExtra("pedido", pedido);
            }
            if(cbLanche3.isChecked()) {
                pedido += 40.90;
                lanche3 = "Eu sou a velocidade";
                intent.putExtra("pedido", pedido);
            }

            intent.putExtra("lanche1", lanche1);
            intent.putExtra("lanche2", lanche2);
            intent.putExtra("lanche3", lanche3);

            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

//    public void CheckBox() {
//        double pedido = 0.0;
//        if(cbLanche1.isChecked()) {
//            pedido += 34.90;
//            String lanche1 = "Felicidade em Pão com Carne";
//            intent.putExtra("pedido", pedido);
//            intent.putExtra("lanche1", lanche1);
//        }
//        if(cbLanche2.isChecked()) {
//            pedido += 30.90;
//            String lanche2 = "Fácil e Rápido";
//            intent.putExtra("pedido", pedido);
//            intent.putExtra("lanche2", lanche2);
//        }
//        if(cbLanche3.isChecked()) {
//            pedido += 40.90;
//            String lanche3 = "Eu sou a velocidade";
//            intent.putExtra("pedido", pedido);
//            intent.putExtra("lanche3", lanche3);
//        }
//    }
}