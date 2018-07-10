package cn.niceabc.dubbo.provider;

import cn.niceabc.dubbo.api.User;
import cn.niceabc.dubbo.api.UserService;
import com.alibaba.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("userService")
public class UserServiceProvider implements UserService {
    private static Logger log = LoggerFactory.getLogger(UserServiceProvider.class);

    @Override
    public User get(Long id) {
        log.debug("in cn.niceabc.dubbo.provider.UserServiceProvider.get");

        log.debug("测试隐式参数param1:{}", RpcContext.getContext().getAttachment("param1"));

        User u = new User();
        u.setId(1L);
        u.setName("Jack");
        return u;
    }

    @PostConstruct
    public void init() {
        log.debug("init");
    }
}
