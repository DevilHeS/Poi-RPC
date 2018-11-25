package com.bit.poi.server.register;

import com.bit.poi.common.Url;

public class NoOptionRegister implements Register {
    @Override
    public boolean register(Url url) {
        return true;
    }

    @Override
    public boolean unregister(Url url) {
        return true;
    }
}
