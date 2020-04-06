package thread01.src;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 下载图片
 */
public class WebDownloader {
    public void download(String url,String name)  {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("URL不合法");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片下载失败");
        }

    }
}
