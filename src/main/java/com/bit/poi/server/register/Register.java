package com.bit.poi.server.register;

import com.bit.poi.common.Url;

public interface Register {

    boolean register(Url url);

    boolean unregister(Url url);
}
