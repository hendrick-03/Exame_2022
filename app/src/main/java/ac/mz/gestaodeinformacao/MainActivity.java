package ac.mz.gestaodeinformacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nome, idade;
    private RadioButton rad_mas, rad_fem;
    private Spinner provinvia, gravidade;
    private Button gravar, listar;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nome_ed);
        idade = findViewById(R.id.idade_ed);
        rad_mas = findViewById(R.id.masculino_rad);
        rad_fem = findViewById(R.id.femenino_rad);
        provinvia = findViewById(R.id.provinvia_spi);
        gravidade = findViewById(R.id.gravidade_spi);
        gravar = findViewById(R.id.gravarbtn);
        listar = findViewById(R.id.listar_btn);

        ArrayAdapter<String> provinviaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        provinviaAdapter.add("Moçambique");
        provinviaAdapter.add("Inhambane");
        provinviaAdapter.add("Nampula");
        provinviaAdapter.add("Manica");
        provinvia.setAdapter(provinviaAdapter);

        ArrayAdapter<String> gravidadeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        gravidadeAdapter.add("Leve");
        gravidadeAdapter.add("Média");
        gravidadeAdapter.add("Grave");
        gravidade.setAdapter(gravidadeAdapter);

        databaseHelper = new DatabaseHelper(this);

        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeText = nome.getText().toString();
                int idadeValue = Integer.parseInt(idade.getText().toString());
                String generoText = rad_mas.isChecked() ? "Masculino" : "Feminino";
                String provinviaText = provinvia.getSelectedItem().toString();
                String gravidadeText = gravidade.getSelectedItem().toString();

                if (idadeValue >= 0 && idadeValue <= 17) {
                    databaseHelper.inserirUsuario(nomeText, idadeValue, generoText, provinviaText, gravidadeText);
                    Toast.makeText(MainActivity.this, "Dados inseridos com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "A idade deve estar entre 0 e 17 anos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String genero = rad_mas.isChecked() ? "masculinos" : "femininos";

                if (rad_mas.isChecked()) {
                    List<Dados> dadosMasculinos = databaseHelper.listarDadosMasculinos();
                    if (!dadosMasculinos.isEmpty()) {
                        exibirDados(dadosMasculinos, genero);
                    } else {
                        Toast.makeText(MainActivity.this, "Nenhum dado masculino encontrado.", Toast.LENGTH_SHORT).show();
                    }
                } else if (rad_fem.isChecked()) {
                    List<Dados> dadosFemininos = databaseHelper.listarDadosFemininos();
                    if (!dadosFemininos.isEmpty()) {
                        exibirDados(dadosFemininos, genero);
                    } else {
                        Toast.makeText(MainActivity.this, "Nenhum dado feminino encontrado.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Selecione um gênero.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void exibirDados(List<Dados> listaDados, String genero) {
        Intent intent = new Intent(MainActivity.this, ListarActivity.class);
        intent.putParcelableArrayListExtra("dados", new ArrayList<>(listaDados));
        intent.putExtra("genero", genero);
        startActivity(intent);
    }


}
