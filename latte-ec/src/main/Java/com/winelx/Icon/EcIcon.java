package com.winelx.Icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by 10942 on 2017/8/23 0023.
 */

public enum EcIcon implements Icon {
    icon_scan('\ue602'),

    icon_ali_pay('\ue606');

    private char character;

    EcIcon(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
