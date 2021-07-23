package com.noeticworld.apiEndpoint.controller;

import com.noeticworld.apiEndpoint.model.HTTPRequestHandler;
import com.noeticworld.apiEndpoint.repositories.PartnerServiceConfigRepo;
import com.noeticworld.apiEndpoint.service.MtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/timwe/")
public class ApiController {
    Logger log = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    MtService mtService;
    @PostMapping(value = "/mtData")
    public ResponseEntity<?> receiveData(@RequestBody HTTPRequestHandler httpRequestHandler) {
        System.out.println(httpRequestHandler.getMsisdn()+"\n"
                +httpRequestHandler.getTransId()+"\n"
                +httpRequestHandler.getShortcode()+"\n"
                +httpRequestHandler.getData()+"\n"
                +httpRequestHandler.getUsername()+"\n"
                +httpRequestHandler.getPassword());
        try{
            mtService.SendMt(httpRequestHandler);
        }
        catch(Exception e){
            return ResponseEntity.ok("failure");

        }

        return ResponseEntity.ok("success");

    }

}
