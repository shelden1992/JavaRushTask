package com.javarush.task.task30.task3003;

import java.util.Objects;

//This class shows how to call other constructors using 'this'
public class ShareItem {
    public String description;
    public int itemId;

    public ShareItem() {
        this("ShareItem- ", 0);
    }

    public ShareItem(String description) {

        this(description, 0);
    }

    public ShareItem(int itemId) {

        this("ShareItem-" + itemId, itemId);
    }

    public ShareItem(String description, int itemId) {
        this.description=description;
        this.itemId=itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShareItem shareItem=(ShareItem) o;
        return itemId == shareItem.itemId &&
                Objects.equals(description, shareItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, itemId);
    }

    @Override
    public String toString() {
        final StringBuilder sb=new StringBuilder("ShareItem{");
        sb.append("description='").append(description).append('\'');
        sb.append(", itemId=").append(itemId);
        sb.append('}');
        return sb.toString();
    }

    public String getDescription() {
        return description;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId=itemId;
    }
}
