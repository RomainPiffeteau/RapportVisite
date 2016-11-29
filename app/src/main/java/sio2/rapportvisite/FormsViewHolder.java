package sio2.rapportvisite;

import android.view.View;
import android.widget.TextView;

/**
 * Created by pbouchez on 29/11/2016.
 */
/*public class FormsViewHolder {
    public TextView numForms;


    View cellule = ...

    FormsViewHolder viewHolder = (FormsViewHolder) cellule.getTag();

    if(viewHolder == null){
        viewHolder = new FormsViewHolder();

        //récupérer les sous vues
        viewHolder.numForms = (TextView) cellule.findViewById(R.id.numForms);

        //sauvegarde du mini-controlleur
        cellule.setTag((viewHolder));
    }

    //convertView est notre vue recyclée
    @Override
    public View getView(int position, View convertView, View parent){
        //Android nous fournit un convertView null lorsqu'il nous demande de la créer
        //dans le cas contraire, cela veut dire qu'il nous fournit une vue recyclée
        if(convertView == null){
            viewHolder = new FormsViewHolder();
            viewHolder.numForms = (TextView) convertView.findViewById(R.id.numForms);
            convertView.setTag(viewHolder);
        }

        //nous renvoyons notre vue à l'adapter, afin qu'il l'affiche
        //et qu'il puisse la mettre à recycler lorsqu'elle sera sortie de l'écran
        return convertView;
    }
}
*/