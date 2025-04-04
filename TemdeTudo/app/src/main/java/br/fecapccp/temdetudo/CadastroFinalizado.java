package br.fecapccp.temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CadastroFinalizado extends AppCompatActivity {

    private Button btnT3Reset;
    private TextView textT3Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro_finalizado);

        textT3Resultado = findViewById(R.id.textT3Resultado);
        btnT3Reset = findViewById(R.id.btnT3Fechar);

        Bundle bundle = getIntent().getExtras();

        String nome = bundle.getString("nome");

        String resultado = "Nome Cadastrado: \n" + nome;

        textT3Resultado.setText(resultado);

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