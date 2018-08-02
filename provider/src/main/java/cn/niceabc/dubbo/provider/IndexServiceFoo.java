package cn.niceabc.dubbo.provider;

import cn.niceabc.dubbo.api.IndexService;
import org.springframework.stereotype.Service;

@Service("indexServiceFoo")
public class IndexServiceFoo implements IndexService {
    public String index() {
        return "foo";
    }
}
