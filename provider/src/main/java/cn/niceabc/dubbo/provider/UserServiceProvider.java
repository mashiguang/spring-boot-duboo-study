package cn.niceabc.dubbo.provider;

import cn.niceabc.dubbo.api.User;
import cn.niceabc.dubbo.api.UserService;
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
