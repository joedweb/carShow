package com.binary.carShow.security;

import com.binary.carShow.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



//-----------------------SPRING SECURITY------------------------------
@Configuration              //because class will have multiple types of objects (all different methods coming from the methods)
@EnableWebSecurity      //removes basics demo config to only use yours
public class SecurityConfig {

    // for JWT
    @Autowired
    private UserServiceImpl userService;
    //

    @Bean               //so we can inject when needed
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Everyone should be able to Get
        return http
                .cors(Customizer.withDefaults())
                .csrf(c -> c.disable())                                         //  disabling csrf for security
                .httpBasic(Customizer.withDefaults())                           //to customize the default we got
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers(HttpMethod.GET,"api/v1/car/*").hasAnyRole("USER","ADMIN")   //Everyone should be able to Get
                                    .requestMatchers(HttpMethod.POST, "api/v1/car/*").hasRole("ADMIN")        //Only Admin can post
                                .anyRequest()       //"any other-
                                .authenticated()    // -needs authentication"
                )
                .build();                                                       // build this bean
    }
    //csrf: Cross site request forgery(CSRF) attack
    //cors

    @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder(){           //to encode the passwords
            return new BCryptPasswordEncoder();
        }


        //needed for Spring Security (below). Not for JWT

//    @Bean
//    public UserDetailsService userDetailsService(){             //Generate the users details
//        //admin
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(bCryptPasswordEncoder().encode( "adminPass"))      //passwords are on plain text, so we need to encode them
//                .roles("ADMIN")
//                .build();
//
//        //user
//        var user = User.builder()       //same as:    UserDetails user = User.builder()
//                .username("user")
//                .password(bCryptPasswordEncoder().encode("userPass"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user,admin);          //saving here, not as an entity or database
//    }



    // For JWT
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}
