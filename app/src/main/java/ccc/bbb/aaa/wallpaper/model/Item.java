package ccc.bbb.aaa.wallpaper.model;

import android.graphics.drawable.Drawable;

public class Item {

    Drawable card;
    int id;

    public Item(Drawable card, int id) {
        this.card = card;
        this.id = id;
    }

    public Drawable getCard() {
        return card;
    }

    public void setCard(Drawable card) {
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
