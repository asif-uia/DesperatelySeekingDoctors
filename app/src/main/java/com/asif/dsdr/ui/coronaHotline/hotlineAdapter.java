package com.asif.dsdr.ui.coronaHotline;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asif.dsdr.R;

import java.util.ArrayList;

/**
 * Created by Asif on 20-Apr-20
 */
public class hotlineAdapter extends RecyclerView.Adapter<hotlineAdapter.hotlineViewHolder> {
    private ArrayList<hotlineResource> mhotlineResource;
    private hotlineAdapter.onItemClickListener mListener;

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    void setOnItemClickListener(hotlineAdapter.onItemClickListener listener) {
        mListener = listener;
    }


    static class hotlineViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textView1;

        hotlineViewHolder(@NonNull View itemView, final onItemClickListener listener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iV_hot);
            textView = itemView.findViewById(R.id.hot_no);
            textView1 = itemView.findViewById(R.id.hot_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    hotlineAdapter(ArrayList<hotlineResource> hotlineResources) {
        mhotlineResource = hotlineResources;
    }

    @NonNull
    @Override
    public hotlineViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemhotline, viewGroup, false);

        return new hotlineViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull hotlineViewHolder hotlineViewHolder, int i) {
        hotlineResource hotlineResource = mhotlineResource.get(i);

        hotlineViewHolder.imageView.setImageResource(hotlineResource.getImageR1());
        hotlineViewHolder.textView.setText(hotlineResource.getText1());
        hotlineViewHolder.textView1.setText(hotlineResource.getText2());
    }

    @Override
    public int getItemCount() {
        return mhotlineResource.size();
    }
}
