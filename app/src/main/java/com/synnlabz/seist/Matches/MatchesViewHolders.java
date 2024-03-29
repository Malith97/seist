package com.synnlabz.seist.Matches;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.synnlabz.seist.Chat.ChatActivity;
import com.synnlabz.seist.R;

public class MatchesViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView mMatchId, mMatchName , mMatchIntake , mMatchDegree;
    public ImageView mMatchImage , img_on , img_off;

    public MatchesViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);

        mMatchId = (TextView) itemView.findViewById(R.id.Matchid);
        mMatchName = (TextView) itemView.findViewById(R.id.MatchName);
        mMatchIntake = (TextView) itemView.findViewById(R.id.MatchIntake);
        mMatchDegree = (TextView) itemView.findViewById(R.id.MatchDegree);
        mMatchImage = (ImageView) itemView.findViewById(R.id.MatchImage);

        img_on = (ImageView)itemView.findViewById(R.id.img_on);
        img_off = (ImageView)itemView.findViewById(R.id.img_off);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), ChatActivity.class);
        Bundle b = new Bundle();
        b.putString("matchId", mMatchId.getText().toString());
        intent.putExtras(b);
        view.getContext().startActivity(intent);
    }
}