package cn.niceabc.dubbo.provider;

import cn.niceabc.dubbo.api.ProblemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("problemService")
public class ProblemServiceImpl implements ProblemService {
    private static Logger log = LoggerFactory.getLogger(ProblemServiceImpl.class);

    @Override
    public String invoke() {
        log.debug("并发测试，超过5个线程应该异常");
        return "from provider";
    }
}
