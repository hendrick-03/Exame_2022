package ac.mz.gestaodeinformacao;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Feminino#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Feminino extends Fragment {
    private ListView listView;
    private ArrayAdapter<Dados> adapter;
    private DatabaseHelper databaseHelper;
    private List<Dados> listaDadosMasculinos;

    public FrameLayout feminino_frag;

    public static Feminino newInstance(ArrayList<Dados> dados){

        Feminino fragment = new Feminino();
        Bundle args = new Bundle();
        args.putParcelableArrayList("dados", dados);
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feminino, container, false);

        listView = view.findViewById(R.id.listview_2);
        feminino_frag = view.findViewById(R.id.Fragment_feminino);
        databaseHelper = new DatabaseHelper(getActivity());

        List<Dados> dados = databaseHelper.listarDados();

        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, dados);
        listView.setAdapter(adapter);

        return view;
    }
    public void setDados(List<Dados> dados) {
        this.listaDadosMasculinos = dados;
        // Atualize o adaptador ou faça outras operações necessárias para exibir os dados
    }

}