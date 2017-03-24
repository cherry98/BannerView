package cn.junhua.android.view;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by junhua on 17-3-24.
 */

public class PagerAdapterWrapper extends PagerAdapter {

    private PagerAdapter mAdapter;

    public PagerAdapterWrapper(PagerAdapter adapter) {
        this.mAdapter = adapter;
    }

    public PagerAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return mAdapter.isViewFromObject(view, object);
    }

    @Override
    public void startUpdate(ViewGroup container) {
        mAdapter.startUpdate(container);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return mAdapter.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        mAdapter.destroyItem(container, position, object);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        mAdapter.setPrimaryItem(container, position, object);
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        mAdapter.finishUpdate(container);
    }

    @Override
    public void startUpdate(View container) {
        mAdapter.startUpdate(container);
    }

    @Override
    public Object instantiateItem(View container, int position) {
        return mAdapter.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        mAdapter.destroyItem(container, position, object);
    }

    @Override
    public void setPrimaryItem(View container, int position, Object object) {
        mAdapter.setPrimaryItem(container, position, object);
    }

    @Override
    public void finishUpdate(View container) {
        mAdapter.finishUpdate(container);
    }

    @Override
    public Parcelable saveState() {
        return mAdapter.saveState();
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        mAdapter.restoreState(state, loader);
    }

    @Override
    public int getItemPosition(Object object) {
        return mAdapter.getItemPosition(object);
    }

    @Override
    public void notifyDataSetChanged() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        mAdapter.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mAdapter.unregisterDataSetObserver(observer);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mAdapter.getPageTitle(position);
    }

    @Override
    public float getPageWidth(int position) {
        return mAdapter.getPageWidth(position);
    }
}
