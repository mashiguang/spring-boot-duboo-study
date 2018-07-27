package cn.niceabc.dubbo.api;

public class ProblemServiceMock implements ProblemService {

    public ProblemServiceMock() {
    }

    @Override
    public String invoke() {
        return "from mock.";
    }
}
