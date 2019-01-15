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
import by.heapix.proslau.heapixtelegram.model.ChatListItem;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;

public class ChatListRecyclerViewAdapter  extends RecyclerView.Adapter<ChatListRecyclerViewAdapter.ViewHolder>{

    private ArrayList<ChatListItem> chatListItems = new ArrayList<>();
    private Context context;

    public ChatListRecyclerViewAdapter(ArrayList<ChatListItem> chatListItems, Context context) {
        this.chatListItems = chatListItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final ChatListItem currentItem = chatListItems.get(i);
        Glide.with(context)
                .asBitmap()
                .load(currentItem.getImage())
                .into(viewHolder.chatListImageView);
        viewHolder.chatListName.setText(currentItem.getName());
        viewHolder.chatListLastMessage.setText(currentItem.getLastMessage());
        viewHolder.chatListDate.setText(currentItem.getDate());
        viewHolder.chatListRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, currentItem.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateList(ArrayList<ChatListItem> newList){
        chatListItems = new ArrayList<>();
        chatListItems.addAll(newList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return chatListItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView chatListImageView;
        TextView chatListName;
        TextView chatListLastMessage;
        TextView chatListDate;
        RelativeLayout chatListRelativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chatListImageView = itemView.findViewById(R.id.chat_list_avatar);
            chatListName = itemView.findViewById(R.id.chat_list_nickname);
            chatListLastMessage = itemView.findViewById(R.id.chat_list_last_message);
            chatListDate = itemView.findViewById(R.id.chat_list_date);
            chatListRelativeLayout = itemView.findViewById(R.id.chat_list_parent_layout);
        }
    }
}
