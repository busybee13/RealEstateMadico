package com.bk.lrandom.realestate.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.view.View.OnClickListener;
import com.bk.lrandom.realestate.R;

public class AboutUsFragment extends Fragment {
    public static final AboutUsFragment newInstance() {
        // TODO Auto-generated constructor stub
        AboutUsFragment fragment = new AboutUsFragment();
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.about_us,
                container, false);
        Button button = (Button) view.findViewById(R.id.sendEmail);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });
        return view;
    }



    public void sendMessage (View view){
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        String[] recipients = new String[]{"mandmbadgers@gmail.com",""};
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Info");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "This is email's message");
        emailIntent.setType("text/plain");
        //emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        //getActivity().finish();
    }
}

