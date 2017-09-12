package com.winelx.mian.index;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.diabin.latte.ui.recytcler.Decoration;
import com.diabin.latte.ui.recytcler.ItemType;
import com.diabin.latte.ui.recytcler.MultipleFields;
import com.diabin.latte.ui.recytcler.MultipleItemEntity;

import java.util.ArrayList;

/**
 * Created by 10942 on 2017/9/11 0011.
 */

public class IndexDataConverter extends Decoration {
    @Override
    public ArrayList<MultipleItemEntity> convert() {
        final JSONArray dataArray = JSON.parseObject(getJsonData()).getJSONArray("data");
        final int size = dataArray.size();
        for (int i = 0; i < size; i++) {
            final JSONObject data = dataArray.getJSONObject(i);
            final String imgeUrl = data.getString("imageUrl");
            final String text = data.getString("text");
            final int spanSize = data.getInteger("spanSize");
            final int id = data.getInteger("goodsId");
            final JSONArray banners = data.getJSONArray("banners");
            final ArrayList<String> bannerImages = new ArrayList<>();
            int type = 0;
            if (imgeUrl == null && text != null) {
                type = ItemType.TEXT;
            } else if (imgeUrl != null && text == null) {
                type = ItemType.IMAGE;
            } else if (imgeUrl != null) {
                type = ItemType.TEXT_IMAGE;
            } else if (banners != null) {
                type = ItemType.BANNER;
                final int bannerSize = banners.size();
                for (int j = 0; j < bannerSize; j++) {
                    final String banner = banners.getString(j);
                    bannerImages.add(banner);
                }
            }
            final MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setField(MultipleFields.ITEM_TYPE, type)
                    .setField(MultipleFields.SPAN_SIZE,  spanSize)
                    .setField(MultipleFields.ID, id)
                    .setField(MultipleFields.TEXT, text)
                    .setField(MultipleFields.IMAGE_URL, imgeUrl)
                    .setField(MultipleFields.BANNERS, bannerImages)
                    .build();
            ENTITIES.add(entity);
        }
        return ENTITIES;
    }
}
