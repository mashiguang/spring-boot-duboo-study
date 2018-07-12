package cn.niceabc.dubbo.consumer;

import cn.niceabc.dubbo.api.User;

public interface Notify {

    void onreturn(User user, Long id);
}
