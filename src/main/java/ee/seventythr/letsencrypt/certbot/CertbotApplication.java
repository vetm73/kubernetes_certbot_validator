package ee.seventythr.letsencrypt.certbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CertbotApplication {

    public static void main( String[] args ) {
        SpringApplication.run( CertbotApplication.class, args );
    }
}
