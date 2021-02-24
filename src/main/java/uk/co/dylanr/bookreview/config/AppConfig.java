package uk.co.dylanr.bookreview.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"test","dev"})
public class AppConfig {

}