package com.winelx.singn;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;

import com.diabin.latte.delegates.LatteDelegate;
import com.diabin.latte.net.RestClient;
import com.diabin.latte.net.callBack.ISuccess;
import com.diabin.latte.util.log.LatteLogger;
import com.example.latteec.ec.R;
import com.example.latteec.ec.R2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 10942 on 2017/9/5 0005.
 * 登陆
 */

public class SigninDetegate extends LatteDelegate {

    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;

    private ISignLiastener mISignListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignLiastener) {
            mISignListener = (ISignLiastener) activity;
        }
    }


    @OnClick(R2.id.btn_sign_in)
    void onclicksignin() {
        if (checkForm()) {
            RestClient.Builder()
                    .url("http://116.196.95.67/RestServer/api/user_profile.php")
                    .params("email", mEmail.getText().toString())
                    .params("password", mPassword.getText().toString())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            LatteLogger.json("USER_PROFILE", response);
                            SignHandler .onSignIn(response, mISignListener);
                        }
                    })
                    .build()
                    .post();
        }

    }

    @OnClick(R2.id.log_in_weixin)
    void onclickweixin() {

    }

    /**
     * 没有祖册，跳转注册
     */
    @OnClick(R2.id.tv_link_sign_up)
    void onClickWeChat() {
        start(new SingUpDelegate());
    }

    /**
     * 判断
     *
     * @return
     */
    private boolean checkForm() {
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();
        boolean isPass = true;
        //邮箱
        if (email.isEmpty() || checkEmaile(email) == false) {
            mEmail.setError("邮箱格式不对");
            isPass = false;
        } else {
            mEmail.setError(null);
        }
        //密码
        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }
        return isPass;
    }

    /**
     * 绑定布局
     *
     * @return
     */
    @Override
    public Object setLayout() {
        return R.layout.sing_on_detegate;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

    /**
     * 邮箱验证
     *
     * @param emaile
     * @return
     */

    private static boolean checkEmaile(String emaile) {
        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        //正则表达式的模式
        Pattern p = Pattern.compile(RULE_EMAIL);
        //正则表达式的匹配器
        Matcher m = p.matcher(emaile);
        //进行正则匹配
        return m.matches();
    }

}
