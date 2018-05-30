package app.desarrollo.proyecto.plasiette;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Pedidos extends ListFragment {
    public View oncreView(LayoutInflater inflater, ViewGroup container, Bundle saveInstance){
        ViewGroup rootView= (ViewGroup) inflater.inflate(R.layout.menu,container,false);
        String[] datasource={"item1", "item2","item1", "item2","item1", "item2"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(getActivity(),R.layout.menu_row,R.id.comida_title,datasource);
        setListAdapter(adapter);
        setRetainInstance(true);
        return rootView;
    }
    public void onListItemClick(ListView l, View view,int position,long id){
        ViewGroup viewGroup=(ViewGroup)  view;
        TextView txt= (TextView)viewGroup.findViewById(R.id.comida_title);
        Toast.makeText(getActivity(),txt.getText().toString(),Toast.LENGTH_LONG).show();
    }
}
