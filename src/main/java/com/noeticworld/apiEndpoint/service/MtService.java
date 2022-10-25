package com.noeticworld.apiEndpoint.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.noeticworld.apiEndpoint.model.HTTPRequestHandler;
import com.noeticworld.apiEndpoint.model.PartnerServiceConfigEntity;
import com.noeticworld.apiEndpoint.repositories.HttpRequestHandlerRepo;
import com.noeticworld.apiEndpoint.repositories.PartnerServiceConfigRepo;
import com.noeticworld.apiEndpoint.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
@Service
public class MtService {

    @Autowired
    PartnerServiceConfigRepo partnerServiceConfigRepo;
    @Autowired
    HttpRequestHandlerRepo httpRequestHandlerRepo;
    public static String serviceId;

    private SecretKeySpec secretKey;

    public String   SendMt(HTTPRequestHandler httpRequestHandler) throws Exception {
        Logger log = LoggerFactory.getLogger(MtService.class);
         String originalMsisdn = decryptmsisdn(httpRequestHandler.getMsisdn());
        System.out.println("check");
         if (!(originalMsisdn.startsWith("92"))){
             return "Error in Encrypted MSISDN";
         }

        List<PartnerServiceConfigEntity> partnerServiceConfigEntity = partnerServiceConfigRepo.findByShortcodeAndUsername(httpRequestHandler.getShortcode(),httpRequestHandler.getUsername());
        for(int j=0; j<1;j++){
            this.serviceId= partnerServiceConfigEntity.get(0).getMt_serviceid();

        }
        System.out.println("checking");
       // System.out.println(this.serviceId);
        try {
        //   Unirest.setTimeouts(10000, 60000);
            HttpResponse<String> response1 = Unirest.post(Constants.MTURL)
                    .header("Content-Type", "application/json")
                    .body("{\n    \"username\" :\"" + httpRequestHandler.getUsername() + "\",\n    \"password\":\"" + httpRequestHandler.getPassword() + "\",\n    \"shortCode\":\"" + httpRequestHandler.getShortcode() + "\",\n    \"serviceId\":" + this.serviceId + ",\n    \"data\":\"" + httpRequestHandler.getData() + "\",\n    \"msisdn\":\"" + originalMsisdn + "\"\n}")
                    .asString();
            log.info("Response From MT for msisdn is "+originalMsisdn+ " " +  httpRequestHandler.getData());


        } catch (UnirestException e) {
            log.info("Exception Sending mt: "+e.getMessage() +" for username "+httpRequestHandler.getUsername());

            e.printStackTrace();
            return "error occured";
        }
        return "Success";
    }

    public String decryptmsisdn(String Base64String) throws Exception {
        //System.out.println("decrypting " +secret);
        String secret = "po90ki8u76gt";
        setKey(secret);
        System.out.println("decrypt");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        System.out.println("cipher");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        System.out.println("line 74");
        byte[] one = Base64.getDecoder().decode(Base64String.getBytes("UTF-8"));
        System.out.println("line 76");
        byte[] two = cipher.doFinal(one);

        String msisdn1 = new String(two, "UTF-8");

     //   System.out.println("original msisdn:" +msisdn1);


        return msisdn1;
    }

    public void setKey(String myKey) {
        MessageDigest sha;
        byte[] key;
        try {

            key = myKey.getBytes("UTF-8");
             System.out.println("key after utf 8 conversion "+key);
            sha = MessageDigest.getInstance("SHA-1");
             System.out.println("sha "+ sha);
            key = sha.digest(key);
             System.out.println("key after digest " +key);
            key = Arrays.copyOf(key, 16);
            System.out.println("key after arrays.copyof "+key);
            secretKey = new SecretKeySpec(key, "AES");
             System.out.println("secretkey "+secretKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void saveInfo(HTTPRequestHandler httpRequestHandler) {
        httpRequestHandlerRepo.save(httpRequestHandler);
    }


//    public void saveInfo(HTTPRequestHandler httpRequestHandler) {
//        partnerServiceConfigRepo.saveAll(httpRequestHandler);
//    }
}
