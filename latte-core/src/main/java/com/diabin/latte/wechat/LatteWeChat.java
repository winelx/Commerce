package com.diabin.latte.wechat;

import android.app.Activity;

import com.diabin.latte.app.ConfigType;
import com.diabin.latte.app.latte;
import com.diabin.latte.wechat.callbacks.IWeChartSignInCallback;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by Administrator on 2017/8/27 0027.
 */

public class LatteWeChat {
    public static final String APP_ID = latte.getConfiguration(ConfigType.WE_CHAT_APP_ID);
    public static final String APP_SECRET = latte.getConfiguration(ConfigType.WE_CHAT_APP_SECRET);
    private final IWXAPI WXAPI;
    private IWeChartSignInCallback mSignInCallback = null;

    private static final class Holder {
        private static LatteWeChat INSTANCE = new LatteWeChat();
    }

    public static LatteWeChat getInstance() {
        return Holder.INSTANCE;
    }

    private LatteWeChat() {
        Activity activity = latte.getConfiguration(ConfigType.ACTIVITY);
        WXAPI = WXAPIFactory.createWXAPI(activity, APP_ID, true);
        WXAPI.registerApp(APP_ID);
    }

    public LatteWeChat onSignSuccess(IWeChartSignInCallback callback) {
        this.mSignInCallback = callback;
        return this;
    }

    public IWeChartSignInCallback getSignInCallback() {
        return mSignInCallback;
    }

    public final IWXAPI getWXAPI() {
        return WXAPI;
    }

    public final void signIn() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        WXAPI.sendReq(req);
    }
}
