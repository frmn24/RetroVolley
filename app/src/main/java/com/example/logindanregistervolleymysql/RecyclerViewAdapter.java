package com.example.logindanregistervolleymysql;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;
import com.android.volley.toolbox.ImageLoader;
import android.content.Context;
import android.view.LayoutInflater;

import com.example.logindanregistervolleymysql.DataAdapter;


import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<DataAdapter> dataAdapters;
    ImageLoader imageLoader;

    public RecyclerViewAdapter(List<DataAdapter> getDataAdapter, Context context){

        super();
        this.dataAdapters = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        DataAdapter dataAdapterOBJ =  dataAdapters.get(position);

        imageLoader = ImageAdapter.getInstance(context).getImageLoader();

        imageLoader.get(dataAdapterOBJ.getUrl(),
                ImageLoader.getImageListener(
                        Viewholder.imgvolley,
                        R.mipmap.ic_launcher,
                        android.R.drawable.ic_dialog_alert
                )
        );

        Viewholder.imgvolley.setImageUrl(dataAdapterOBJ.getUrl(), imageLoader);
        Viewholder.txtjudul.setText(dataAdapterOBJ.getName()); // Mengambil nama dari objek DataAdapter


    }

    @Override
    public int getItemCount() {

        return dataAdapters.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtjudul;
        public NetworkImageView imgvolley ;

        public ViewHolder(View itemView) {

            super(itemView);

            txtjudul = (TextView) itemView.findViewById(R.id.txtjudul) ;
            imgvolley = (NetworkImageView) itemView.findViewById(R.id.imgvolley) ;

        }
    }
}
