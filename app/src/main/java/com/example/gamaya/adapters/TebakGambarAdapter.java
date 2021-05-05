package com.example.gamaya.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamaya.databinding.ItemTebakGambarAnswerBinding;
import com.example.gamaya.utils.RecyclerViewCallback;

public class TebakGambarAdapter extends RecyclerView.Adapter<TebakGambarAdapter.ViewHolder> {

    private RecyclerViewCallback.ItemClick<Integer> integerItemClick;
    private int[] currentList = {};

    public void submitList(int[] items){
        currentList = items;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(RecyclerViewCallback.ItemClick<Integer> onItemClickListener){
        integerItemClick = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemTebakGambarAnswerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(currentList[position]);

        if (integerItemClick == null) return;
    }

    @Override
    public int getItemCount() {
        return currentList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemTebakGambarAnswerBinding binding;

        public ViewHolder(ItemTebakGambarAnswerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(int imgRes) {
            binding.ivTebakGambarAnswer.setImageResource(imgRes);

            itemView.setOnClickListener(v -> {
                TebakGambarAdapter.this.integerItemClick.onItemClick(v, imgRes, getAdapterPosition());
            });
        }
    }
}
