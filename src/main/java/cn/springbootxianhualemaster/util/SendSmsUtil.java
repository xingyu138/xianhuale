package cn.springbootxianhualemaster.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SendSmsUtil {

    public static void sendSms(String phone,String messageCode) {

        //Generating Random Numbers
        //String messageCode = String.valueOf((int) (Math.random() * 1000000 + 100000));
        System.out.println(messageCode);

        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIzh6OA94HwVBk", "85bD4bw5DFf91OMWGoa4phGiPoUo4T");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "鲜花乐");
        request.putQueryParameter("TemplateCode", "SMS_164508053");
        request.putQueryParameter("TemplateParam", "{code:"+messageCode+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
}

