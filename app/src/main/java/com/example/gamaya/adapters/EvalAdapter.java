package com.example.gamaya.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.gamaya.R;
import com.example.gamaya.databinding.ItemVideoExplanationBinding;
import com.example.gamaya.models.EvalVideo;
import com.example.gamaya.utils.RecyclerViewCallback;

import java.util.ArrayList;
import java.util.List;

public class EvalAdapter extends RecyclerView.Adapter<EvalAdapter.ViewHolder> {

    private RecyclerViewCallback.ItemClick<EvalVideo> itemClick;
    private List<EvalVideo> currentList = new ArrayList<>();

    public void submitList(List<EvalVideo> items){
        currentList = items;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(RecyclerViewCallback.ItemClick<EvalVideo> onItemClickListener){
        itemClick = onItemClickListener;
    }

    @NonNull
    @Override
    public EvalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EvalAdapter.ViewHolder(ItemVideoExplanationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EvalAdapter.ViewHolder holder, int position) {
        holder.bind(currentList.get(position));
    }

    @Override
    public int getItemCount() {
        return currentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemVideoExplanationBinding binding;

        public ViewHolder(ItemVideoExplanationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(EvalVideo evalVideo) {

            binding.tvTitle.setText(evalVideo.getTitle());
            binding.tvSubtitle.setText(evalVideo.getSubtitle());

            Glide.with(binding.getRoot().getContext())
                    .load(evalVideo.getImageUrl())
                    .centerCrop()
                    .override(48, 48)
                    .transform(new RoundedCorners(14))
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .error(R.drawable.ic_icon_rounded_placeholder)
                    .placeholder(R.drawable.ic_icon_rounded_placeholder)
                    .into(binding.ivThumbnailVideo);

            if (itemClick == null) return;

            itemView.setOnClickListener(v -> {
                EvalAdapter.this.itemClick.onItemClick(v, evalVideo, getAdapterPosition());
            });
        }
    }
}
