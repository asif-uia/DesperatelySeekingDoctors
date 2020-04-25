package com.asif.dsdr.ui.doctorsHelpline;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asif.dsdr.R;

import java.util.ArrayList;

/**
 * Created by Asif on 17-Apr-20
 */
public class itemAdapter extends RecyclerView.Adapter<itemAdapter.itemViewHolder> {
    private ArrayList<itemResource> mitemResource;
    private onItemClickListener mListener;

    public interface onItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener){
        mListener = listener;
    }

    public static class itemViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView1;
        public ImageView imageView2;
        public TextView textView1;
        public TextView textView2;

        public itemViewHolder(@NonNull View itemView, final onItemClickListener listener) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.imageView1);
            imageView2 = itemView.findViewById(R.id.imageView2);
            textView1 = itemView.findViewById(R.id.d_name);
            textView2 = itemView.findViewById(R.id.d_no);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    itemAdapter(ArrayList<itemResource> itemResources) {
        mitemResource = itemResources;
    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_doctor, viewGroup, false);
        itemViewHolder iv = new itemViewHolder(view, mListener);

        return iv;
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder viewHolder, int i) {
        itemResource itemResource = mitemResource.get(i);

        viewHolder.imageView1.setImageResource(itemResource.getImageR1());
        viewHolder.imageView2.setImageResource(itemResource.getImageR2());
        viewHolder.textView1.setText(itemResource.getText1());
        viewHolder.textView2.setText(itemResource.getText2());

    }

    @Override
    public int getItemCount() {
        return mitemResource.size();
    }
}
