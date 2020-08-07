package com.am.mynetbaased;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;
    private final String[] maintitleq;
    private final String[] subtitleq;
   // private final Integer[] imgid;

    public MyListAdapter(Activity context, String[] maintitle, String[] subtitle, String[] maintitleq, String[] subtitleq) {
        super(context, R.layout.mylist, maintitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.maintitle=maintitle;
        this.subtitle=subtitle;
     //   this.imgid=imgid;

        this.maintitleq = maintitleq;
        this.subtitleq = subtitleq;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
     //   ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);
        TextView titleTextw = (TextView) rowView.findViewById(R.id.title2);
        TextView subtitleTextw = (TextView) rowView.findViewById(R.id.subtitle2);

        titleText.setText(maintitle[position]);
      //  imageView.setImageResource(imgid[position]);
        subtitleText.setText(subtitle[position]);
        subtitleTextw.setText(maintitleq[position]);
        titleTextw.setText(subtitleq[position]);

        return rowView;

    };
}

