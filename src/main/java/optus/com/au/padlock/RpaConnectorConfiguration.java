package optus.com.au.padlock;

import com.optus.au.authenticatedrestclient.AuthenticatedRestClientConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class RpaConnectorConfiguration {

    private AuthenticatedRestClientConfiguration authenticatedRestClientConfiguration;

      @Value("${botIdUrl}")
    private String botIdUrl;

    public RpaConnectorConfiguration() {
    }

    public RpaConnectorConfiguration(AuthenticatedRestClientConfiguration authenticatedRestClientConfiguration, String botIdUrl) {
        this.authenticatedRestClientConfiguration = authenticatedRestClientConfiguration;
        this.botIdUrl = botIdUrl;
    }

    public AuthenticatedRestClientConfiguration getAuthenticatedRestClientConfiguration() {
        return authenticatedRestClientConfiguration;
    }

    public void setAuthenticatedRestClientConfiguration(AuthenticatedRestClientConfiguration authenticatedRestClientConfiguration) {
        this.authenticatedRestClientConfiguration = authenticatedRestClientConfiguration;
    }

    public String getBotIdUrl() {
        return botIdUrl;
    }

    public void setBotIdUrl(String botIdUrl) {
        this.botIdUrl = botIdUrl;
    }
}
