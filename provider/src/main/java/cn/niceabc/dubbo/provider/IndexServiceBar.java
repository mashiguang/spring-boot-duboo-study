package cn.niceabc.dubbo.provider;

import cn.niceabc.dubbo.api.IndexService;
import org.springframework.stereotype.Service;

@Service("indexServiceBar")
public class IndexServiceBar implements IndexService {
    public String index() {
        return "bar";
    }
}
