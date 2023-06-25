package ac.mz.gestaodeinformacao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ListarActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout layout;
    private String genero;
    private FrameLayout masclino_frag, feminino_frag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        masclino_frag = findViewById(R.id.Fragment_Masculino);
        feminino_frag = findViewById(R.id.Fragment_feminino);

         viewPager = findViewById(R.id.viewpager);
         layout = findViewById(R.id.layout);

        MyAdapterPage adapter = new MyAdapterPage(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        layout.setupWithViewPager(viewPager);

        genero = getIntent().getStringExtra("genero");
        List<Dados> listaDados = getIntent().getParcelableArrayListExtra("dados");

        if (genero.equals("Masculinos")) {
            Masculino masculinoFragment = new Masculino();
            masculinoFragment.setDados(listaDados);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Fragment_Masculino, masculinoFragment)
                    .commit();
        } else if (genero.equals("Femininos")) {
            Feminino femininoFragment = new Feminino();
            femininoFragment.setDados(listaDados);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Fragment_feminino, femininoFragment)
                    .commit();
        }
    }

}
