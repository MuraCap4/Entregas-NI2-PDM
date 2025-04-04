package br.fecapccp.temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class telaCadastro extends AppCompatActivity {

    private Button btnT2Fechar;
    private Button btnT2Set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cadastro);

        EditText campoNome = findViewById(R.id.editTextNome);
        btnT2Fechar = findViewById(R.id.btnT2Fechar);

        btnT2Set = findViewById(R.id.btnT2Set);

        btnT2Set.setOnClickListener(view -> {
            // Transferência de valores:
            String nome = campoNome.getText().toString();

            Intent intent = new Intent(this, CadastroFinalizado.class);

            intent.putExtra("nome", nome);

            startActivity(intent);
            finish();

        });

        btnT2Fechar.setOnClickListener(view -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void limpar (View view) {
        EditText campoNome = findViewById(R.id.editTextNome);

        campoNome.setText("");
    }
}