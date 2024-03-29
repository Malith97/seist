package com.synnlabz.seist.Chat;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.synnlabz.seist.R;

public class ChatViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView mMessage,mChatName , mChatStatus;
    public CardView mCard;
    public LinearLayout mContainer , mLinear;
    public ChatViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);

        mCard = itemView.findViewById(R.id.bubble);
        mLinear = itemView.findViewById(R.id.linear_lay);
        mMessage = itemView.findViewById(R.id.message);
        mContainer = itemView.findViewById(R.id.container);

        mChatName = itemView.findViewById(R.id.username);
        mChatStatus = itemView.findViewById(R.id.onlineStatus);
    }

    @Override
    public void onClick(View view) {
    }
}
