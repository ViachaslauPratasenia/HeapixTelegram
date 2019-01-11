package by.heapix.proslau.heapixtelegram.controller.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import by.heapix.proslau.heapixtelegram.R;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;

public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> contactNames = new ArrayList<>();
    private ArrayList<String> contactImages = new ArrayList<>();
    private Context context;

    public ContactRecyclerViewAdapter(ArrayList<String> contactNames, ArrayList<String> contactImages, Context context) {
        this.contactNames = contactNames;
        this.contactImages = contactImages;
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
        Glide.with(context)
                .asBitmap()
                .load(contactImages.get(i))
                .into(viewHolder.imageView);
        viewHolder.contactName.setText(contactNames.get(i));
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contactNames.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactNames.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView contactName;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            contactName = itemView.findViewById(R.id.image_name);
            relativeLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
