package optus.com.au.padlock.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import optus.com.au.padlock.service.CallRpaOrchestrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
public class ProvisioningController {

    Logger LOG = LoggerFactory.getLogger(ProvisioningController.class);

    @Autowired
    CallRpaOrchestrator callRpaOrchestrator;

    @RequestMapping(value = "/callOrchestrator", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity callOrchestrator() throws JsonProcessingException {


        LOG.info("Going to call the RPA Orchestrator!!!");
        String stringResponse = null;

        try {
            stringResponse = callRpaOrchestrator.callRpaOrchestrator();
        }catch(Exception e) {
            LOG.info("There was some exception: [{}]",e.getMessage());
        }

        return ResponseEntity.ok().body(stringResponse);
    }
}
