package cn.niceabc.dubbo.api;

public class ProblemServiceMock implements ProblemService {
    @Override
    public String invoke() {
        return "from mock.";
    }
}
