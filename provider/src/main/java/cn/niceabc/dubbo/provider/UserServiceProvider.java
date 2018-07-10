package cn.niceabc.dubbo.provider;

import cn.niceabc.dubbo.api.User;
import cn.niceabc.dubbo.api.UserService;
import com.alibaba.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceProvider implements UserService {
    private static Logger log = LoggerFactory.getLogger(UserServiceProvider.class);

    @Override
    public User get(Long id) {
        log.debug("in cn.niceabc.dubbo.provider.UserServiceProvider.get");

        log.debug("测试隐式参数param1:{}", RpcContext.getContext().getAttachment("param1"));

        List<User> list = getAll()
                .stream()
                .filter(user -> id.equals(user.getId()))
                .collect(Collectors.toList());

        return list.size()==0?null:list.get(0);
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();

        User u = new User();
        u.setId(1L);
        u.setName("Jack");
        list.add(u);

        User u_2 = new User();
        u_2.setId(2L);
        u_2.setName("Tom");
        list.add(u_2);

        return list;
    }

    @PostConstruct
    public void init() {
        log.debug("init");
    }
}
