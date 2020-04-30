package com.asif.dsdr.ui.coronavirus;

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
public class itemAdapter extends RecyclerView.Adapter<itemAdapter.itemViewHolder> {
    private ArrayList<itemResource> mitemResource;

    itemAdapter(ArrayList<itemResource> itemResources) {
        mitemResource = itemResources;
    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pushti_item, viewGroup, false);

        return new itemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder viewHolder, int i) {
        itemResource itemResource = mitemResource.get(i);
        viewHolder.textView1.setText(itemResource.getText1());
    }

    @Override
    public int getItemCount() {
        return mitemResource.size();
    }

    static class itemViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;

        itemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.push_descrip);

        }
    }
}
