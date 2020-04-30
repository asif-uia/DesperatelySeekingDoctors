package com.asif.dsdr.ui.dentalHelpline;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asif.dsdr.R;

import java.util.ArrayList;

/**
 * Created by Asif on 17-Apr-20
 */
public class dentalAdapter extends RecyclerView.Adapter<dentalAdapter.itemViewHolder> {
    private ArrayList<dentalResource> mitemResource;
    private onItemClickListener mListener;

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    void setOnItemClickListener(onItemClickListener listener) {
        mListener = listener;
    }

    static class itemViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;

        itemViewHolder(@NonNull View itemView, final onItemClickListener listener) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.den_name);
            textView2 = itemView.findViewById(R.id.den_no);

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

    dentalAdapter(ArrayList<dentalResource> itemResources) {
        mitemResource = itemResources;
    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_dentist, viewGroup, false);

        return new itemViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder viewHolder, int i) {
        dentalResource itemResource = mitemResource.get(i);

        viewHolder.textView1.setText(itemResource.getText1());
        viewHolder.textView2.setText(itemResource.getText2());
    }

    @Override
    public int getItemCount() {
        return mitemResource.size();
    }
}
