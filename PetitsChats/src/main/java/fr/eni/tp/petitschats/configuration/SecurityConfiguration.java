package fr.eni.tp.petitschats.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration

public class SecurityConfiguration {

    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select pseudo,password,1 from utilisateur where pseudo=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select pseudo,role from roles where pseudo=?");

        return jdbcUserDetailsManager;
    }

    /**
     * Restriction des URLs selon la connexion utilisateur et leurs rôles
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
//            auth.requestMatchers(HttpMethod.GET,"/").permitAll();
//
//            auth.requestMatchers(HttpMethod.GET,"/liste").permitAll();
//            auth.requestMatchers(HttpMethod.POST,"/liste").hasRole("ADMIN");
//
//            auth.requestMatchers(HttpMethod.GET,"/detail").authenticated();
//
//            auth.requestMatchers(HttpMethod.GET,"/modifier").hasRole("ADMIN");
//            auth.requestMatchers(HttpMethod.POST,"/modifier").hasRole("ADMIN");
//
//            auth.requestMatchers(HttpMethod.POST,"/creer").hasRole("ADMIN");
//            auth.requestMatchers(HttpMethod.GET,"/creer").hasRole("ADMIN");
//
//
//            //Permettre à tous les utilisateurs d'afficher correctement les images et la css
//            auth.requestMatchers("/css/*").permitAll();
//            auth.requestMatchers("/images/*").permitAll();    //.authenticated()
//            auth.requestMatchers(HttpMethod.GET,"/images/CHAT/*").permitAll();
//            auth.requestMatchers(HttpMethod.POST,"/images/CHAT/*").hasRole("ADMIN");
//            auth.anyRequest().denyAll();

            auth.anyRequest().permitAll();

        });


        //formulaire de connexion par défaut
        http.formLogin(form -> form
                .loginPage("/login")

                .permitAll()
        )
                .logout(logout -> logout.logoutSuccessUrl("/"));

        return http.build();


    }
}