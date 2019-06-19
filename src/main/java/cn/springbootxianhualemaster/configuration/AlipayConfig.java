package cn.springbootxianhualemaster.configuration;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016093000630839";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDnFmWIG0QlnKEKR0RePJa/pBhW9pS8mp8Q0hmcvIGT/a7ROcsgPIxjuFF5JP/osUT4v9b0LgJSl1djaATRbZew+0BGCbuFXn8ryNRSL/rS3+xrq0rnljtxAvzpumTYtAIsasL8lqPQEa4A4T/4vyQM5GNMHdryBE2q/a+D1ZbYcPmi8NbGETiAtilzUU+y4lpeZCr3okD+vcAPST9DhQ7QYg8MW9a65y+urQ6QJvSXMpvIVQ15q4+jbMIVQiIWPGt8v7JsmYBo19zRaZT1vBd2cM9UEHGJ615DxZezW0kG2cAEectS6BbOpmaWJumlPtO24EzKunhLA/ZBxvpi6LR7AgMBAAECggEBAKvTMWeErqUw02VrHGDduFGC2D5BVtLuPXwqXLT4TXkW1dfomyq7GsBDGwFzC32f4eL78f7Z/wweT/IwM/TtAi+sglwRfIdsfi62Q3lhB6WorohYc3fDcytSx2+bEsU3A663K4jZEbDylGk/E2wH4+xaHaNJR7VQkdekjc7/EAyaequ5sDvWBLDLnTOKVC7DpGMWKel5+dw0l8VLdTDtIM3eb3YeKNRnZmrxv6uxJeemPbNSbeedvt7RjHnkCeWSvW2KWFAcdk1wzmXYWc8z9gO8gOCoTd5pmibpRk4g9biN8h9H5LnAjZ4bolYC0Vl3WceOHXTYwMj8k7AFnlq8rHECgYEA9X1UdLHz1ZOUC2C2FyufgdslWu8NC1uwm891FdNtZn9EcvNzPSEmyTKmuDrWQSD1KFL7FK14L5bvmNl7+QhcTkXczW0SUJLWEYXRYMf29iovuIJN6e/braqOf9FdL9pQwLkXrATj9ZXmm+t/jioqngIKD1+x6a0ZcCFbZyDKKE8CgYEA8Ps2uARM9XNuOAISK6w294kgVmMG0DaOElM/4DPzCt24/9tvUx4VngWh5hdcxonFhLk29N4rVbpi0EOkGSNpQ/5pvZLvedYd4+40nGjJ0fup7xuYkq7LTDEt3KM9JqAUvDDtSSp/BYBF/l9wgRq6K3p7dIg4bah9R8lE8zHWuhUCgYAGevJ5yiDHqIel7T2hSvOA+An6ZokPnbIByu4qT1R5+i4SYr7OBEwDz6R7BIKXYYlXMSmTmCiuCOv2Ovd80W2uW0XC3ng3TEj+WWv3hA/O27o6wqXP4RcJdJEiaqJtGvQ6wigP0Gk8GGLoBsVtOUu6tA8T7NDDfGBJh3fkNwdfHQKBgGb5om9N/yjf05iBYgxhgfeTFEt184Jj3Z/9DQ2chV3+U0CaH18wOuKU25L8Jrv8QXguwUov6eqvQ+xlCylm1WOlwr+sm0K/+XPd5YN0z9E4LmyrqS39HYiId2WSJ95qh5HHgo5CZ5cNMlu5otS4fBd6NmkckKhjWG2llx4pDO3lAoGBANstU4TM8SxdCeiGc+tIdiiSagDXL2IpEimxCg/4Wa3md0CH5hUK7yXtAsxmtzxxb9ASDpyhI71VCwvRVefGIT8IOfVJ3/z8Q5pAeV7TbS+MG/VooHpFgLNoTxXrWAhAYkIAApLT9AEc50Ke1bI7jun0jsImZbh4TaghKJXAKKwK";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo/PhfELLjFEo2ETLazJrPI4yTw3jyxIXdfili71phaNkmXZrfS95lJOpr9hAK/jzECeL24kEIQS2p7ppOAdk8y1xvTxBXy3I6Kz4QzBbVBLFjkUaMvSZapLgvcNDkbVRdoF66AkMc823LxHnyOGG8clGUsymUQ1+pLxjEN3NAsiBo8iPptS1vKLzxgLBII3MA5BaOadeoYEqFC6ZjSDPUEqJ6TNHbdIp22l1vbOALL9jUVoGhaVIRoKxSIrmloQuTiu5XBn4bOxEE+4gO0ZQlP08rtyryKDDfd5HENYuEk+eKl93+9RefDZL9BQ2Gpi5RGVI7Tt9AC4YVkqfCskFuQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/alipay/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://127.0.0.1:8080/view/alipay_success.html";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}