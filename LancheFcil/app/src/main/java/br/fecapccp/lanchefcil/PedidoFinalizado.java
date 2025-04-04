package br.fecapccp.lanchefcil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PedidoFinalizado extends AppCompatActivity {

    private Button btnT3Reset;
    private TextView textT3Resultado, textT3ValorTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pedido_finalizado);

        textT3Resultado = findViewById(R.id.textT3Resultado);
        textT3ValorTotal = findViewById(R.id.textT3ValorTotal);
        btnT3Reset = findViewById(R.id.btnT3Fechar);

        Bundle bundle = getIntent().getExtras();

        String nome = bundle.getString("nome");
        double pedido = bundle.getDouble("pedido");
        String lanche1 = bundle.getString("lanche1");
        String lanche2 = bundle.getString("lanche2");
        String lanche3 = bundle.getString("lanche3");

        String resultado = "Seu pedido é: \n" + lanche1 + "\n" + lanche2 + "\n" + lanche3 + "\nE foi feito no nome de " + nome;
        String valorTotal = "Valor Total: R$" + pedido;

        textT3Resultado.setText(resultado);
        textT3ValorTotal.setText(valorTotal);

        btnT3Reset.setOnClickListener(view -> {
            // Qual tela vou chamar após clicar nesse botão:
            Intent intent = new Intent(this, MainActivity.class);

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