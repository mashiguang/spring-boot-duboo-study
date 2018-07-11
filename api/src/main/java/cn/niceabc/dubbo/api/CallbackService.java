package cn.niceabc.dubbo.api;

public interface CallbackService {

    void addListener(String key, CallbackListener listener);
}
