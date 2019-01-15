package by.heapix.proslau.heapixtelegram.controller.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import by.heapix.proslau.heapixtelegram.R;
import by.heapix.proslau.heapixtelegram.model.contact.Contact;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;

public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private Context context;

    public ContactRecyclerViewAdapter(ArrayList<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final Contact currentContact = contacts.get(i);
        Glide.with(context)
                .asBitmap()
                .load(currentContact.getAvatar())
                .into(viewHolder.imageView);
        viewHolder.contactName.setText(currentContact.getNickname());
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, currentContact.getNickname(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateList(ArrayList<Contact> newList){
        contacts = new ArrayList<>();
        contacts.addAll(newList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView contactName;
        RelativeLayout relativeLayout;
        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            contactName = itemView.findViewById(R.id.image_name);
            relativeLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
