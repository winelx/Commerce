package com.winelx.singn;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Toast;

import com.diabin.latte.delegates.LatteDelegate;
import com.example.latteec.ec.R;
import com.example.latteec.ec.R2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 10942 on 2017/9/5 0005.
 */

public class SingUpDelegator extends LatteDelegate {
    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText mName = null;
    @BindView(R2.id.edit_sign_up_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText mPhone = null;
    @BindView(R2.id.edit_sign_up_password)
    TextInputEditText mPassword = null;
    @BindView(R2.id.edit_sign_up_re_password)
    TextInputEditText mRePassword = null;

    @OnClick(R2.id.btn_sign_up)
    void onClickSignUp() {
        if (checkForm()) {
//            RestClient.Builder()
//                    .url("sign_up")
//
//                    .success(new ISuccess() {
//                        @Override
//                        public void onSuccess(String msg) {
//
//                        }
//                    })
//                    .build();
            Toast.makeText(getActivity(), "验证通过", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean checkForm() {
        final String name = mName.getText().toString();
        final String email = mEmail.getText().toString();
        final String phone = mPhone.getText().toString();
        final String password = mPassword.getText().toString();
        final String passwords = mRePassword.getText().toString();
        boolean isPass = true;
        //用户名
        if (name.isEmpty()) {
            mName.setError("请输入用户名");
            isPass = false;
        } else {
            mName.setError(null);
        }
        //邮箱
        if (email.isEmpty() || emailFormat(email) == false) {
            mEmail.setError("邮箱格式不对");
            isPass = false;

        } else {
            mEmail.setError(null);
        }
        //手机
        if (phone.isEmpty() || isChinaPhoneLegal(password) == false) {
            mPhone.setError("手机号不正确");
            isPass = false;
        } else {
            mPhone.setError(null);
        }
        //密码
        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }
        if (passwords.isEmpty() || passwords.length() < 6 || !(passwords.equals(password))) {
            mRePassword.setError("密码验证错误");
            isPass = false;
        } else {
            mRePassword.setError(null);
        }

        return isPass;
    }

    @Override
    public Object setLayout() {

        return R.layout.singup_detegate;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

    //国内手机号码判断（不过括港澳台）
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean emailFormat(String email) {
        boolean tag = true;
        final String pattern1 = "^([a-z0-9A-Z]+[-|//.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?//.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }

}
