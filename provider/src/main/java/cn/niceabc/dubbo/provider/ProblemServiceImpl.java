package cn.niceabc.dubbo.provider;

import cn.niceabc.dubbo.api.ProblemService;
import org.springframework.stereotype.Service;

@Service("problemService")
public class ProblemServiceImpl implements ProblemService {
    @Override
    public String invoke() {
        return "no way";
    }
}
