package com.ufrpe.bccsurvivor;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Daniel on 25/11/2017.
 */

public class AdapterRanking extends ArrayAdapter<Player> {


    public AdapterRanking(Context context, int resource,List<Player>players) {
        super(context, resource,players);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.item_ranking, null);
        }

        Player player = getItem(position);

        if (player != null) {
            TextView name = (TextView) v.findViewById(R.id.playername);
            TextView score = (TextView) v.findViewById(R.id.playerscore);

            if (name != null) {
                name.setText(player.getNickname());
            }

            if (score != null) {
                score.setText(String.valueOf(player.getScore()));
            }

        }

        return v;
    }
}
