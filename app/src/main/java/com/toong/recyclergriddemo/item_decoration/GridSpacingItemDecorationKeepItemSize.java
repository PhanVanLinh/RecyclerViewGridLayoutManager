package com.toong.recyclergriddemo.item_decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * https://stackoverflow.com/a/44898892/5381331
 */
public class GridSpacingItemDecorationKeepItemSize extends RecyclerView.ItemDecoration {

    private int mSpanCount;
    private float mItemSize;

    public GridSpacingItemDecorationKeepItemSize(int spanCount, int itemSize) {
        this.mSpanCount = spanCount;
        mItemSize = itemSize;
    }

    @Override
    public void getItemOffsets(final Rect outRect, final View view, RecyclerView parent,
            RecyclerView.State state) {
        final int position = parent.getChildLayoutPosition(view);
        final int column = position % mSpanCount;
        final int parentWidth = parent.getWidth();
        int spacing = (int) (parentWidth - (mItemSize * mSpanCount)) / (mSpanCount + 1);
        outRect.left = spacing - column * spacing / mSpanCount;
        outRect.right = (column + 1) * spacing / mSpanCount;

        if (position < mSpanCount) {
            outRect.top = spacing;
        }
        outRect.bottom = spacing;
    }
}