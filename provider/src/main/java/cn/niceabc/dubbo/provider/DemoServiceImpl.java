package cn.niceabc.dubbo.provider;

import cn.niceabc.dubbo.api.DemoService;
import com.alibaba.dubbo.config.annotation.Service;

@Service(
        application = "spring-boot-dubbo-provider",
        protocol = "dubbo",
        registry = "zk_registry")
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "hi,"+name;
    }
}
