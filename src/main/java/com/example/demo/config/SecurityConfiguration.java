package com.example.demo.config;

//import org.modelmapper.ModelMapper;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.authentication.AuthenticationManagerBeanDefinitionParser;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;


@KeycloakConfiguration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends KeycloakWebSecurityConfigurerAdapter {


    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
                return  new RegisterSessionAuthenticationStrategy( new SessionRegistryImpl());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/swagger-ui.html/").permitAll();
       //
        http.authorizeRequests().antMatchers("/api/commandes/**").permitAll();
        http.authorizeRequests().antMatchers("/api/contacts/**").authenticated();
      //  http.authorizeRequests().antMatchers("/api/**").authenticated();
        http.authorizeRequests().antMatchers("/api/**").permitAll();
        http.headers().frameOptions().disable();
        http.authorizeRequests().anyRequest().authenticated();

    }
    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(keycloakAuthenticationProvider());
//    }
//
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.csrf().disable();
//
//        //les apis accessible sans token
//        http.authorizeRequests().antMatchers("/api/commandes").permitAll();
//        http.authorizeRequests().anyRequest().authenticated();
//    }
//
}


//    @Bean
//    public ModelMapper modeilMapper(){
//        return  new  ModelMapper();
//    }
//
//
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
// .authorizeRequests()
//.anyRequest().authenticated()
//.and()
// .sessionManagement()
// .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
// .and()
//               .cors()
//               .and()
//               .csrf()
//                .disable();
//  .oauth2ResourceServer()
//  .jwt();


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors()
//
//                .and()
//                .csrf().disable()
//                 .authorizeRequests()
//                 .antMatchers(/*HttpMethod.GET,*/ "/api")
//                // .permitAll()
//                 //.anyRequest()
//                 .hasAnyAuthority("user")
//                .anyRequest()
//                .authenticated()
//               .and()
//                .oauth2ResourceServer()
//                .jwt();



//        .authorizeRequests()
//                .antMatchers("/api/**").authenticated()
//                .antMatchers("/").permitAll()
//                .and()
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
//}
