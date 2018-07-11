package cn.niceabc.dubbo.provider;

import cn.niceabc.dubbo.api.CallbackListener;
import cn.niceabc.dubbo.api.CallbackService;
import org.springframework.stereotype.Service;

@Service("callbackService")
public class CallbackServiceImpl implements CallbackService {
    @Override
    public void addListener(String key, CallbackListener listener) {

        listener.changed(key);
    }
}
