package ee.seventythr.letsencrypt.certbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CertbotController {
    private static final Logger LOG = LoggerFactory.getLogger( CertbotController.class );
    private static final String configuredUrl = "/.well-known/acme-challenge/";

    @Value( "${certbot.challenge}" )
    private String configuredChallenge;

    @Value( "${certbot.response}" )
    private String configuredResponse;

    private String checkChallenge( String challenge ) {
        if ( configuredChallenge.equals( challenge ) ) {
            LOG.info( "Returning response {} for challenge {}", configuredResponse, challenge );
            return configuredResponse;
        }
        LOG.error( "No response for challenge {} found.", challenge );
        return "Unknown challenge";
    }

    @GetMapping( CertbotController.configuredUrl + "{challenge}" )
    public String getChallenge( @PathVariable String challenge ) {
        return checkChallenge( challenge );
    }
}
