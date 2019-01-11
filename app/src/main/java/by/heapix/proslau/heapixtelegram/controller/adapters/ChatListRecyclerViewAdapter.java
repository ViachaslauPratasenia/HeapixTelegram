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
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;

public class ChatListRecyclerViewAdapter  extends RecyclerView.Adapter<ChatListRecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> chatListNicknames = new ArrayList<>();
    private ArrayList<String> chatListImages = new ArrayList<>();
    private ArrayList<String> chatListLastMessages = new ArrayList<>();
    private ArrayList<String> chatListDates = new ArrayList<>();
    private Context context;

    public ChatListRecyclerViewAdapter(ArrayList<String> chatListNicknames, ArrayList<String> chatListImages,
                                       ArrayList<String> chatListLastMessages, ArrayList<String> chatListDates,
                                       Context context) {
        this.chatListNicknames = chatListNicknames;
        this.chatListImages = chatListImages;
        this.chatListLastMessages = chatListLastMessages;
        this.chatListDates = chatListDates;
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
        Glide.with(context)
                .asBitmap()
                .load(chatListImages.get(i))
                .into(viewHolder.chatListImageView);
        viewHolder.chatListName.setText(chatListNicknames.get(i));
        viewHolder.chatListLastMessage.setText(chatListLastMessages.get(i));
        viewHolder.chatListDate.setText(chatListDates.get(i));
        viewHolder.chatListRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, chatListNicknames.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return chatListNicknames.size();
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
