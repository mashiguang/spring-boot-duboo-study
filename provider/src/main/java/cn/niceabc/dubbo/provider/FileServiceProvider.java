package cn.niceabc.dubbo.provider;

import cn.niceabc.dubbo.api.FileService;
import org.springframework.stereotype.Service;

@Service("fileService")
public class FileServiceProvider implements FileService {
    @Override
    public byte[] download() {
        return "hello".getBytes();
    }
}
