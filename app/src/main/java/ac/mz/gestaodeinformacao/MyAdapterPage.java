package ac.mz.gestaodeinformacao;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
public class MyAdapterPage extends FragmentPagerAdapter {
    private static final int NUM_TABS = 2; //Número de fragments
    private ArrayList<Dados> dados;

    public MyAdapterPage(@NonNull FragmentManager fm, int behavior, ArrayList<Dados> dados) {
        super(fm, behavior);
        this.dados = dados;
    }

    public MyAdapterPage(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                // Retorne o fragmento lado1
                return Masculino.newInstance(dados);
            case 1:
                // Retorne o fragmento lado2
                return Feminino.newInstance(dados);
            // Caso tenha mais guias, adicione os casos correspondentes aqui
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Masculino";
            case 1:
                return "Feminino";
            default:
                return null;
        }
    }
}
