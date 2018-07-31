package cn.niceabc.dubbo.provider;

import cn.niceabc.dubbo.api.ProblemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("problemService")
public class ProblemServiceImpl implements ProblemService {
    private static Logger log = LoggerFactory.getLogger(ProblemServiceImpl.class);

    @Override
    public String invoke() {

        log.debug("并发测试，超过5个线程应该异常");

        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "from provider";
    }
}
