package cn.junhua.android.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 图片轮播
 * Created by junhua on 17-3-24.
 */
public class BannerView extends ViewPager {
    private static final int FLAG = 0;

    private PagerAdapterWrapper mPagerAdapterWrapper;
    private Handler mHandler;
    //自动播放延迟延迟时间默认1s
    private int mDelayTime = 1000;
    private boolean mIsAutoPlay = false;

    public BannerView(Context context) {
        this(context, null);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        createHandler();
    }

    private void createHandler() {
        if (mHandler != null) {
            return;
        }
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (mIsAutoPlay) {
                    BannerView.super.setCurrentItem(BannerView.super.getCurrentItem() + 1, true);
                    mHandler.sendEmptyMessageDelayed(FLAG, mDelayTime);
                }
            }
        };
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        mPagerAdapterWrapper = new PagerAdapterWrapper(adapter);
        super.setAdapter(mPagerAdapterWrapper);
        int count = mPagerAdapterWrapper.getCount();
        super.setCurrentItem(Integer.MAX_VALUE / 2 - ((Integer.MAX_VALUE / 2) % count));
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public PagerAdapter getAdapter() {
        return mPagerAdapterWrapper.getAdapter();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        createHandler();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mHandler.getLooper().quit();
        mHandler = null;
    }

    private boolean mTouchFlag = false;

    /**
     * 触摸的时候停止自动播放功能
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mTouchFlag = mIsAutoPlay;
                mIsAutoPlay = false;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mIsAutoPlay = mTouchFlag;
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 开启自动播放
     */
    public void startPlay() {
        mIsAutoPlay = true;
        mHandler.sendEmptyMessageDelayed(FLAG, mDelayTime);
    }

    public void stopPlay() {
        mIsAutoPlay = false;
    }

    public void setDelayTime(int time) {
        if (time < 100) {
            time = 100;
        }
        this.mDelayTime = time;
    }
}
