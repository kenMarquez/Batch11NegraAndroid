package io.mariachi.recyclerviewexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.mariachi.recyclerviewexample.models.User;

/**
 * Created by Ken on 20/09/16.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<User> userList;
    private Context context;

    public ContactAdapter(List<User> userList) {
        this.userList = userList;

    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View rowView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);

        ContactViewHolder contactViewHolder = new ContactViewHolder(rowView);

        return contactViewHolder;
    }


    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        User user = userList.get(position);
        holder.bindUser(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    /**
     * Creamos el ViewHolder que se encargara de vincular los datos
     * del modelo a la vista
     */
    public class ContactViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgContact;
        private TextView tvName;
        private TextView tvPhone;


        public ContactViewHolder(View itemView) {
            super(itemView);
            //Inicializamos las vistas
            tvName = (TextView) itemView.findViewById(R.id.item_tv_name);
            tvPhone = (TextView) itemView.findViewById(R.id.item_tv_phone);
            imgContact = (ImageView) itemView.findViewById(R.id.item_img_profile);

        }

        /**
         * Asignamos los parametros del usuario que necesitemos a nuestras
         * vistas
         *
         * @param user
         */
        public void bindUser(final User user) {

            tvName.setText(user.getName());
            tvPhone.setText(user.getPhone());

            imgContact.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Su tel: " + user.getPhone(), Toast.LENGTH_SHORT).show();
                }
            });
        }


    }


}
