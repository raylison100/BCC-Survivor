package com.ufrpe.bccsurvivor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RankingActivity extends AppCompatActivity {

    private ArrayList<Player>players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        if(savedInstanceState == null){
            carregaPlayers();
        }else{
            players = savedInstanceState.getParcelableArrayList("lista");
        }

        ListView ranking = (ListView)findViewById(R.id.ranking);
        AdapterRanking adapter = new AdapterRanking(this, R.layout.item_ranking,players);

        ranking.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("lista",players);
    }

    private void carregaPlayers(){
        this.players = new ArrayList<Player>();
        Random rand = new Random();

        for(int i = 1; i<=100;i++){
            players.add(new Player("Player"+i,rand.nextInt(1000)));
        }
        Collections.sort(players);
    }
}
