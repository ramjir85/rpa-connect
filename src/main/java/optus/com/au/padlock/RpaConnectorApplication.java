package optus.com.au.padlock;

import com.optus.au.authenticatedrestclient.AuthenticatedRestClientApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(AuthenticatedRestClientApplication.class)
public class RpaConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpaConnectorApplication.class, args);
	}

}
