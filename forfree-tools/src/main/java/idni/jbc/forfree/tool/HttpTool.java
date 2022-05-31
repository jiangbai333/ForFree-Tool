package idni.jbc.forfree.tool;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.alibaba.fastjson.JSON;

public final class HttpTool {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    private HttpTool() { }

    /**
     * 用get方法返回url内容.
     *
     * <pre>
     *                        +--------------------------+
     *                        |        ◀  sdf  ▶         |
     *                        +--------------------------+
     *                                      |
     *              +-----------------------+-------------------------+
     *              |                                                 |
     *              v                                                 v
     * +------------------------+                         +-----------------------+
     * |                        |                         |                       |
     * |                        |                         |                       |
     * |                        |                         |                       |
     * |                        |                         |                       |
     * +------------------------+                         +-----------------------+
     * </pre>
     *
     * @param url url
     *
     * @return 返回结果
     */
    public static String executeGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        String result = null;

        try {
            response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
