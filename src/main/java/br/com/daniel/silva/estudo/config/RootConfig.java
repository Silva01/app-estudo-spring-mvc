package br.com.daniel.silva.estudo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("br.com.daniel.silva.estudo")
@EnableWebMvc
public class RootConfig {

}
