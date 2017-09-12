package com.diabin.latte.ui.recytcler;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.diabin.latte.ui.Banner.bannerCreator;
import com.example.latte.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10942 on 2017/9/11 0011.
 */

public class MultipleRecyclerAdapter extends BaseMultiItemQuickAdapter<MultipleItemEntity, MultipleViewHolder>
        implements BaseQuickAdapter.SpanSizeLookup,OnItemClickListener {
    //确保初始化一次Banner，防止重复Item加载
    private boolean mIsInitBanner = false;
    //图片加载的策略
    private static final RequestOptions RECYCLER_OPTIONS =
            new RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate();

    public MultipleRecyclerAdapter(List<MultipleItemEntity> data) {
        super(data);
        init();
    }

    public static MultipleRecyclerAdapter create(List<MultipleItemEntity> data) {
        return new MultipleRecyclerAdapter(data);
    }

    public static MultipleRecyclerAdapter create(Decoration decoration) {
        return new MultipleRecyclerAdapter(decoration.convert());
    }

    //数据转换
    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity item) {
        final String text;
        final String imgUrl;
        final ArrayList<String> bannerImage;
        switch (holder.getItemViewType()) {
            case ItemType.TEXT:
                text = item.getFiled(MultipleFields.TEXT);
                holder.setText(R.id.tv_single, text);
                break;
            case ItemType.IMAGE:
                imgUrl = item.getFiled(MultipleFields.IMAGE_URL);
                Glide.with(mContext)
                        .load(imgUrl)
                        .apply(RECYCLER_OPTIONS)
                        .into((ImageView) holder.getView(R.id.img_single));

                break;
            case ItemType.TEXT_IMAGE:
                text = item.getFiled(MultipleFields.TEXT);
                imgUrl = item.getFiled(MultipleFields.IMAGE_URL);
                holder.setText(R.id.img_multiple, text);
                Glide.with(mContext)
                        .load(imgUrl)
                        .apply(RECYCLER_OPTIONS)
                        .into((ImageView) holder.getView(R.id.tv_multiple));

                break;
            case ItemType.BANNER:
                if (!mIsInitBanner) {
                    bannerImage = item.getFiled(MultipleFields.BANNERS);
                    final ConvenientBanner<String> convenientBanner =
                            holder.getView(R.id.banner_recycler_item);
                    bannerCreator.seDefault(convenientBanner, bannerImage, this);
                    mIsInitBanner=true;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return getData().get(position).getFiled(MultipleFields.SPAN_SIZE);
    }

    //初始化布局
    private void init() {
        addItemType(ItemType.IMAGE, R.layout.item_multiple_image);
        addItemType(ItemType.TEXT, R.layout.item_multiple_text);
        addItemType(ItemType.TEXT_IMAGE, R.layout.item_multiple_image_text);
        addItemType(ItemType.BANNER, R.layout.item_multiple_banner);
        //设置宽度监听
        setSpanSizeLookup(this);
        openLoadAnimation();
        //多次执行动画
        isFirstOnly(false);
    }

    //传入viewholder
    @Override
    protected MultipleViewHolder createBaseViewHolder(View view) {
        return MultipleViewHolder.create(view);
    }
    //点击事件处理
    @Override
    public void onItemClick(int position) {

    }
}
