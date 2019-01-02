package by.heapix.proslau.heapixtelegram.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import by.heapix.proslau.heapixtelegram.R;

import java.util.ArrayList;


public class ChatFragment extends Fragment {
    private TextView tvUsername;
    private TextView tvLastMessage;
    private TextView tvDate;

    final String ATTRIBUTE_USERNAME = "username";
    final String ATTRIBUTE_LAST_MESSAGE = "lastMessage";
    final String ATTRIBUTE_DATE = "date";

    String[] users = {"Alex", "Pedro", "Nick"};
    String[] lastMessages = {"ok", "lol", "kek"};
    String[] dates = {"Mon", "Sun", "Thu"};

    RecyclerView recyclerView;
    ArrayAdapter adapter;
    ArrayList<String[]> data;
    String[] strings;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment, container, false);

        LinearLayout linLayout = (LinearLayout) view.findViewById(R.id.lin_layout_chat);

        LayoutInflater ltInflater = getLayoutInflater();

        for (int i = users.length - 1; i >= 0; i--) {
            View item = ltInflater.inflate(R.layout.chat_item, linLayout, false);
            tvUsername = (TextView) item.findViewById(R.id.tv_chat_item_name);
            tvUsername.setText(String.valueOf(users[i]));
            tvLastMessage = (TextView) item.findViewById(R.id.tv_chat_item_last_message);
            tvLastMessage.setText(String.valueOf(lastMessages[i]));
            tvDate = (TextView) item.findViewById(R.id.tv_chat_date);
            tvDate.setText(String.valueOf(dates[i]));
            item.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
            linLayout.addView(item);
        }

        /*data = new ArrayList<>();
        for(int i = users.length - 1; i >= 0; i--){
            strings = new String[]{users[i], lastMessages[i], dates[i]};
            data.add(strings);
        }

        String[] from = {ATTRIBUTE_USERNAME, ATTRIBUTE_LAST_MESSAGE, ATTRIBUTE_DATE};
        int[] to = {R.id.tv_chat_item_name, R.id.tv_chat_item_last_message, R.id.tv_chat_date};

        adapter = new ArrayAdapter(view.getContext(), data, R.layout.chat_item, from, to);*/


        return view;
    }


}
