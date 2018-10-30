package ccc.bbb.aaa.wallpaper.adapter;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.util.List;

import ccc.bbb.aaa.wallpaper.model.Item;
import ccc.bbb.aaa.wallpaper.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Item> list;
    Context context;

    public MyAdapter(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder vh;
        View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        vh = new MyViewHolder(v1);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, final int position) {
        final Item item = (Item) list.get(position);
        holder.ivCard.setImageDrawable(item.getCard());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View view = layoutInflater.inflate(R.layout.fragment_buttonsheet_card, null);
                final BottomSheetDialog dialog = new BottomSheetDialog(context);
                dialog.setContentView(view);
                dialog.show();
                ImageView iv = (ImageView) dialog.findViewById(R.id.iv);
                assert iv != null;
                iv.setBackground(item.getCard());
                Button btn = (Button) dialog.findViewById(R.id.btn);
                final Drawable drawable = item.getCard();
                assert btn != null;
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        WallpaperManager myWallpaperManager
                                = WallpaperManager.getInstance(context);
                        try {
                            myWallpaperManager.setResource(item.getId());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivCard;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivCard = (ImageView) itemView.findViewById(R.id.iv_card);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }

}
