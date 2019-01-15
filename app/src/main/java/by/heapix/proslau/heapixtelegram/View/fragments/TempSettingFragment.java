package by.heapix.proslau.heapixtelegram.view.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.Button;
import android.widget.Toast;
import by.heapix.proslau.heapixtelegram.R;

import java.util.Objects;

public class TempSettingFragment extends Fragment implements View.OnClickListener {

    private Dialog cameraDialog;

    Button btnFromCamera;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_fragment, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        cameraDialog = new Dialog(getContext());
        cameraDialog.setContentView(R.layout.choise_camera_dialog);
        cameraDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        //actionBar.setTitle("Settings");

        Bundle args = getArguments();
        actionBar.setTitle(args.getString("nick"));

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                Toast.makeText(getContext(), "Floating button (settings)", Toast.LENGTH_SHORT).show();
                try {
                    cameraDialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}