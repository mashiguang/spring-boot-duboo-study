package cn.niceabc.dubbo.consumer;

import cn.niceabc.dubbo.api.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("notify")
public class NotifyImpl implements Notify {
    private static Logger log = LoggerFactory.getLogger(NotifyImpl.class);

    @Override
    public void onreturn(User user, Long id) {
        log.debug("onreturn, {}", user.getName());
    }
}
