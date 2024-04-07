package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;

public class DeputyActivity extends AppCompatActivity
        implements  DeputyObserver
{

    private ImageView imageView;

    private ListView listView;
    private VotesAdapter adapter;
    private ArrayList<Votes> votes;



    private TextView textViewName, textViewCirco, textViewEmail, textViewGroupe;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Deputy deputy= (Deputy) getIntent().getSerializableExtra("deputy");
        String deputyName = deputy.getFirstname()+"-"+deputy.getLastname();
        ApiServices.searchRequestVote(this,deputyName, this::onReceiveVotesInfo);
        setContentView(R.layout.activity_deputy);
        textViewName= findViewById(R.id.textViewDeputyName);
        textViewCirco= findViewById(R.id.textViewDeputyCirco);
        textViewGroupe= findViewById(R.id.textViewDeputyGroupe);
        textViewEmail= findViewById(R.id.textViewDeputyEmail);
        imageView= findViewById(R.id.imageViewDeputy);


        listView= findViewById(R.id.listViewMainVote);
        votes= new ArrayList<Votes>();

        adapter= new VotesAdapter(votes, this);
        listView.setAdapter(adapter);
        Log.d("lol","test");




    }

    @Override
    protected void onResume() {
        super.onResume();
        Deputy deputy= (Deputy) getIntent().getSerializableExtra("deputy");
        textViewName.setText(deputy.getFirstname()+" "+deputy.getLastname());
        textViewCirco.setText(deputy.getDepartment()+", "+
                deputy.getNameCirco()+ " "+ deputy.getNumCirco()+
                (deputy.getNumCirco()==1? "er": "eme")+" circoncription");
        textViewGroupe.setText(deputy.getGroupe());
        textViewEmail.setText(deputy.getEmail());
        ApiServices.loadDeputyAvatar(this, deputy.getNameForAvatar(), imageView);
    }

    @Override
    public void onReceiveVotesInfo(Votes vote) {
        if(!votes.contains(vote)){
            votes.add(vote);
            adapter.setVotes(votes);
            adapter.notifyDataSetChanged();
        }
    }





}
