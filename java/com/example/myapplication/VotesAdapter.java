package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;

import java.util.ArrayList;

public class VotesAdapter extends BaseAdapter {

    private ArrayList<Votes> votes;
    private Context context;

    public VotesAdapter(ArrayList<Votes> votes, Context context) {
        this.votes = votes;
        this.context = context;
    }

    public void setVotes(ArrayList<Votes> votes) {
        this.votes = votes;
    }

    @Override
    public int getCount() {
        return votes.size();
    }

    @Override
    public Object getItem(int position) {
        return votes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return votes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_votes, parent, false);
        }
        TextView textViewPosition = convertView.findViewById(R.id.textViewItemPosition);
        textViewPosition.setText(votes.get(position).getPosition());
        TextView textViewTitre= convertView.findViewById(R.id.textViewItemVoteTitre);
        textViewTitre.setText(votes.get(position).getTitre());
        TextView textViewDate=convertView.findViewById(R.id.textViewItemVoteDate);
        textViewDate.setText(votes.get(position).getDate());

        ImageView imageView= convertView.findViewById(R.id.imageViewItemVote);
        //TextView textViewDescription = convertView.findViewById(R.id.textViewItemVoteDescription);
        //textViewDescription.setText(votes.get(position).getDescription());
        if(textViewPosition.equals("pour")){
            imageView.setImageResource(R.drawable.good);
            textViewPosition.setTextColor(Color.GREEN);
            textViewTitre.setTextColor(Color.GREEN);
        }
        else{
            imageView.setImageResource(R.drawable.bad);
            textViewPosition.setTextColor(Color.RED);
            textViewTitre.setTextColor(Color.RED);
        }
        return convertView;
    }
}
