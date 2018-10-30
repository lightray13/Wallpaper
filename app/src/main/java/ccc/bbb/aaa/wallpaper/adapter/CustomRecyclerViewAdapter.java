package ccc.bbb.aaa.wallpaper.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ccc.bbb.aaa.wallpaper.activity.PhotoActivity;
import ccc.bbb.aaa.wallpaper.R;
import shivam.developer.featuredrecyclerview.FeatureRecyclerViewAdapter;

public class CustomRecyclerViewAdapter extends FeatureRecyclerViewAdapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE_FEATURED = 0;
    private static final int ITEM_TYPE_DUMMY = 1;

    private List<String> data;
    private int[] images = new int[5];
    Context context;

    public CustomRecyclerViewAdapter() {
        images[0] = R.drawable.image_one;
        images[1] = R.drawable.image_two;
        images[2] = R.drawable.image_three;
        images[3] = R.drawable.image_four;
        images[4] = R.drawable.image_five;
    }

    public void swapData(List<String> data, Context context) {
        this.context = context;
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateFeaturedViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ITEM_TYPE_FEATURED:
                return new FeaturedViewHolder(
                        LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.layout_featured_item, parent, false));
            case ITEM_TYPE_DUMMY:
            default:
                return new DummyViewHolder(
                        LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.layout_dummy_item, parent, false));
        }
    }

    @Override
    public void onBindFeaturedViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof FeaturedViewHolder) {
            FeaturedViewHolder featuredViewHolder = (FeaturedViewHolder) holder;
            if (position != 5) {
                Picasso.with(holder.itemView.getContext()).load(images[position % 5]).into(featuredViewHolder.ivBackground);
                featuredViewHolder.tvHeading.setText(data.get(position));
                featuredViewHolder.item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, PhotoActivity.class);
                        intent.putExtra("position", position);
                        context.startActivity(intent);
                    }
                });
            } else {
                featuredViewHolder.ivBackground.setBackgroundColor(context.getResources().getColor(R.color.black));
                featuredViewHolder.tvHeading.setBackgroundColor(context.getResources().getColor(R.color.black));

            }

        } else if (holder instanceof DummyViewHolder) {

        }
    }

    @Override
    public int getFeaturedItemsCount() {
        return data.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position >= 0 && position < data.size() ? ITEM_TYPE_FEATURED : ITEM_TYPE_DUMMY;
    }

    @Override
    public void onSmallItemResize(RecyclerView.ViewHolder holder, int position, float offset) {
        if (holder instanceof FeaturedViewHolder) {
            FeaturedViewHolder featuredViewHolder = (FeaturedViewHolder) holder;
            featuredViewHolder.tvHeading.setAlpha(offset / 100f);
        }
    }

    @Override
    public void onBigItemResize(RecyclerView.ViewHolder holder, int position, float offset) {
        if (holder instanceof FeaturedViewHolder) {
            FeaturedViewHolder featuredViewHolder = (FeaturedViewHolder) holder;
            featuredViewHolder.tvHeading.setAlpha(offset / 100f);
        }
    }


    static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        ImageView ivBackground;
        TextView tvHeading;
        RelativeLayout item;

        FeaturedViewHolder(View itemView) {
            super(itemView);

            ivBackground = (ImageView) itemView.findViewById(R.id.iv_background);
            tvHeading = (TextView) itemView.findViewById(R.id.tv_heading);
            item = (RelativeLayout) itemView.findViewById(R.id.item);
        }
    }

    static class DummyViewHolder extends RecyclerView.ViewHolder {

        DummyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
