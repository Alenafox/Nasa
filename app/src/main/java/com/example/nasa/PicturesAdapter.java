package com.example.nasa;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PicturesAdapter extends BaseAdapter {
    Context ctx;
    Picasso p;
    public PicturesAdapter(Context ctx, Hit[] hits) {
        this.ctx = ctx;
        this.hits = hits;
        p  = new Picasso.Builder(ctx).build();

    }

    Hit[] hits;

    @Override
    public int getCount() {
        return hits.length;
    }

    @Override
    public Object getItem(int position) {
        return hits[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(ctx).inflate(R.layout.item, parent, false);
        ImageView iv = convertView.findViewById(R.id.picture);
        TextView tvExp = convertView.findViewById(R.id.explanation);
        Hit h = hits[position];
        tvExp.setText("Explanation: "+h.explanation);


        p.load(h.previewURL).into(iv);
        Log.d("mytag", "Loading: " + h.previewURL);
        return convertView;
    }
}
