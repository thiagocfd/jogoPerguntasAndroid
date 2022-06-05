package br.com.othonbatista.jogodeperguntas;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> perguntas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, new JogarFragment())
                .commit();
    }

    // Botões do Fragmento Jogar
    public void buttonCadastrarJogarFragment(View v) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, new CadastrarFragment())
                .commit();
    }

    // Botões do Fragmento Cadastrar
    public void buttonJogarCadastrarFragment(View v) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, new JogarFragment())
                .commit();
    }

    public void clickButton(View v) {

        EditText editTextPergunta = findViewById(R.id.editTextPergunta);
        EditText editTextResposta = findViewById(R.id.editTextResposta);

        if(editTextPergunta.getText().toString().isEmpty()) {

            Toast.makeText(this, "Precisa ter dados na pergunta", Toast.LENGTH_SHORT).show();
            return;
        }
        if(editTextResposta.getText().toString().isEmpty()) {

            Toast.makeText(this, "Precisa ter dados na resposta", Toast.LENGTH_SHORT).show();
            return;
        }

        Questoes questoes = new Questoes();
        questoes.setPergunta(editTextPergunta.getText().toString());
        questoes.setResposta(editTextResposta.getText().toString());

        QuestoesDAO.addQuestoes(this, questoes);

        editTextPergunta.setText("");
        editTextResposta.setText("");

        perguntas.add(editTextPergunta.getText().toString());

        Toast.makeText(this, "Pergunta cadastrada.", Toast.LENGTH_SHORT).show();


    }

}