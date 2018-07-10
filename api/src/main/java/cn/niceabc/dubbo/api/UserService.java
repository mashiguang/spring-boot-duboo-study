package cn.niceabc.dubbo.api;

import java.util.List;

public interface UserService {
    User get(Long id);

    List<User> getAll();
}
