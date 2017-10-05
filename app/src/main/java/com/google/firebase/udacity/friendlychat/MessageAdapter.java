package com.google.firebase.udacity.friendlychat;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.Query;


public class MessageAdapter extends FirebaseListAdapter<Message> {

    public MessageAdapter(Activity activity, Class<Message> modelClass, int modelLayout, Query ref) {
        super(activity, modelClass, modelLayout, ref);
    }

    @Override
    protected void populateView(View view, Message message, int position) {
        TextView messageTextView = (TextView) view.findViewById(R.id.messageTextView);
        TextView authorTextView = (TextView) view.findViewById(R.id.nameTextView);
        ImageView photoImageView = (ImageView) view.findViewById(R.id.photoImageView);
        boolean isPhoto = message.getPhotoUrl() != null;
        if (isPhoto) {
            messageTextView.setVisibility(View.GONE);
            photoImageView.setVisibility(View.VISIBLE);
            Glide.with(photoImageView.getContext())
                    .load(message.getPhotoUrl())
                    .into(photoImageView);
        } else {
            messageTextView.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            messageTextView.setText(message.getText());
        }
        authorTextView.setText(message.getName());
    }
}

