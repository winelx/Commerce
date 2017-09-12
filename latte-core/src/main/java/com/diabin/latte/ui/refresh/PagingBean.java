package com.diabin.latte.ui.refresh;

/**
 * Created by 10942 on 2017/9/12 0012.
 */

public class PagingBean {

    private int mPagerIndex = 0;
    private int mTotal = 0;
    private int mPageSize = 0;
    private int mDelayed = 0;

    public int getPagerIndex() {
        return mPagerIndex;
    }

    public PagingBean setPagerIndex(int pagerIndex) {
        mPagerIndex = pagerIndex;
        return this;
    }

    public int getTotal() {
        return mTotal;
    }

    public PagingBean setTotal(int total) {
        mTotal = total;
        return this;
    }

    public int getPageSize() {
        return mPageSize;
    }

    public PagingBean setPageSize(int pageSize) {
        mPageSize = pageSize;
        return this;
    }

    public int getDelayed() {
        return mDelayed;
    }

    public PagingBean setDelayed(int delayed) {
        mDelayed = delayed;
        return this;
    }

    PagingBean addIndex() {
        mPagerIndex++;
        return this;
    }
}
