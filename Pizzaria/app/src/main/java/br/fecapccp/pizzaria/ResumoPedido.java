package br.fecapccp.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumoPedido extends AppCompatActivity {

    private Button btnT3Reset;

    private TextView textT3Resultado, textT3ValorTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_pedido);

        Bundle bundle = getIntent().getExtras();

        double pedido = bundle.getDouble("pedido");

        String sabor1 = bundle.getString("sabor1");
        String sabor2 = bundle.getString("sabor2");
        String sabor3 = bundle.getString("sabor3");

        String pagCard = bundle.getString("pagCard");
        String pagDin = bundle.getString("pagDin");

        String tamPeq = bundle.getString("tamPeq");
        String tamMed = bundle.getString("tamMed");
        String tamGran = bundle.getString("tamGran");

        textT3Resultado = findViewById(R.id.textT3Resultado);
        btnT3Reset = findViewById(R.id.btnT3Fechar);
        textT3ValorTotal = findViewById(R.id.textT3ValorTotal);

        String resultado = "Sabor escolhido: " + "\n" + sabor1 + "\n" + sabor2 + "\n" + sabor3 + "\nTamanho Escolhido: " + tamPeq + tamMed + tamGran + "\nForma de Pagamento: " + "\n" + pagDin + pagCard;

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