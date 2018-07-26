package cn.niceabc.dubbo.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserServiceStub implements UserService {
    private static Logger log = LoggerFactory.getLogger(UserServiceStub.class);

    private UserService userService;

    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User get(Long id) {
        log.debug("in stub");
        if (id == null) {
            User n = new User();
            n.setId(-1L);
            n.setName("Mr.Null.");

            return n;
        }
        return userService.get(id);
    }

    @Override
    public List<User> getAll() {
        return userService.getAll();
    }
}
