package com.example.manisha.election;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manisha.election.models.Polling;

import java.util.List;

public class PollingAdapter extends RecyclerView.Adapter<PollingAdapter.CustomViewHolder> {

    private List<Polling> pollings;

    public PollingAdapter(List<Polling> pollings){
        this.pollings = pollings;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView epic;
        TextView textView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            epic = itemView.findViewById(R.id.textView5);
            textView = itemView.findViewById(R.id.textView6);
        }

    }

    @NonNull
    @Override
    public PollingAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.row_polling, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PollingAdapter.CustomViewHolder customViewHolder, int i) {
        customViewHolder.epic.setText(pollings.get(i).getPollingStation().getName());
        customViewHolder.textView.setText(pollings.get(i).getEPIC());

    }

    @Override
    public int getItemCount() {
        return pollings.size();
    }
}
