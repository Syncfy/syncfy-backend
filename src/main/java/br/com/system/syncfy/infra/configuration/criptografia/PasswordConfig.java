package br.com.system.syncfy.infra.configuration.criptografia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    // Define um bean PasswordEncoder para a aplicação
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Retorna uma instância de BCryptPasswordEncoder como implementação de PasswordEncoder
        return new BCryptPasswordEncoder();
    }
}
