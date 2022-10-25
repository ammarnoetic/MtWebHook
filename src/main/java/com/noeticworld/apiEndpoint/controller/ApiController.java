package com.noeticworld.apiEndpoint.controller;

import com.noeticworld.apiEndpoint.model.HTTPRequestHandler;
import com.noeticworld.apiEndpoint.service.MtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    Logger log = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    MtService mtService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(value = "/mtapi")
    public ResponseEntity<?> receiveData(@RequestBody HTTPRequestHandler httpRequestHandler) {
        log.info(httpRequestHandler.getMsisdn()+"\n"
                +httpRequestHandler.getTransId()+"\n"
                +httpRequestHandler.getShortcode()+"\n"
                +httpRequestHandler.getData()+"\n"
                +httpRequestHandler.getUsername()+"\n"
                +httpRequestHandler.getPassword());
        System.out.println("helo");

        try{
            mtService.SendMt(httpRequestHandler);
        }
        catch(Exception e){
            log.info("Failed to send MT");
            return ResponseEntity.ok("Failure");

        }
      return ResponseEntity.ok("Successfuly Sent MT");

    }

    //for testing
    @PostMapping(value = "/test")
    public ResponseEntity testApi(@RequestBody HTTPRequestHandler httpRequestHandler){
        try{
            mtService.saveInfo(httpRequestHandler);
        }
        catch(Exception e){
            log.info("Failed to send MT");
            return ResponseEntity.ok("Failure");

        }
        return ResponseEntity.ok("Successfuly Sent MT");

   }

}
