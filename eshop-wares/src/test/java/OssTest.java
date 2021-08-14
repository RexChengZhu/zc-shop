//import com.aliyun.oss.OSS;
//import com.aliyun.oss.OSSClientBuilder;
//import com.zc.eshop.wares.WaresApp;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.FileInputStream;
//import java.io.InputStream;
//
//@SpringBootTest(classes = WaresApp.class)
//@RunWith(SpringRunner.class)
//public class OssTest {
//
//
//
//    @Test
//    public void uploadTest() throws Exception{
//        // Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
//// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
//        String accessKeyId = "LTAI5tAAvLEkqaGvpGu2H6Cf";
//        String accessKeySecret = "CUvR3g6e4IVb35qy2dZXP2TdpkmpUO";
//        String bucketName = "zc-eshop";
//// <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
//        String objectName = "FFSSS";
//
//// 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//// 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（objectName）。
//        InputStream inputStr = new FileInputStream("D:\\workSpace\\zc-shop\\eshop-wares\\src\\main\\resources\\memo.txt");
//        ossClient.putObject(bucketName, objectName, inputStr);
//
//// 关闭OSSClient。
//        ossClient.shutdown();
//    }
//}
