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


public class Masculino extends Fragment {

    private ListView listView;
    private ArrayAdapter<Dados> adapter;
    private DatabaseHelper databaseHelper;
    private List<Dados> listaDadosMasculinos;
    public FrameLayout masculino_frag;

    public static Masculino newInstance(ArrayList<Dados>dados){

        Masculino fragment = new Masculino();
        Bundle args = new Bundle();
        args.putParcelableArrayList("dados", dados);
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_masculino, container, false);

        listView = view.findViewById(R.id.listview_1);
        databaseHelper = new DatabaseHelper(getActivity());
        masculino_frag = view.findViewById(R.id.Fragment_Masculino);

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