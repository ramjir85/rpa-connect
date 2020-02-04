package optus.com.au.padlock.service;

import com.optus.au.authenticatedrestclient.domain.Token;
import com.optus.au.authenticatedrestclient.exception.AuthenticateException;
import com.optus.au.authenticatedrestclient.exception.TupolevCallException;
import com.optus.au.authenticatedrestclient.rest.AuthenticatedClient;
import optus.com.au.padlock.RpaConnectorConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.io.IOException;


@Component
@Service
public class CallRpaOrchestrator {

    private final Logger LOG = LoggerFactory.getLogger(CallRpaOrchestrator.class);


    @Autowired
    AuthenticatedClient authenticatedClient;

    @Autowired
    RpaConnectorConfiguration rpaConnectorConfiguration;




    public String callRpaOrchestrator() throws IOException, AuthenticateException, TupolevCallException {
        LOG.info("Into the Call Tupolev Cloud Service");

        Token authToken = null;
        String stringResponse = null;

        try {
            Response response = authenticatedClient.get(rpaConnectorConfiguration.getBotIdUrl());
            stringResponse = response.readEntity(String.class);
            LOG.info("Response Status: [{}]", response.getStatus());
            LOG.info("Response from Orchestrator: [{}]", stringResponse);
        } catch(Exception e) {
            LOG.info("Exception happened: [{}]",e.getMessage());
            return stringResponse;
        }
       return stringResponse;
    }
}
