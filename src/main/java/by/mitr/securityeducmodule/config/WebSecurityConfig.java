package by.mitr.securityeducmodule.config;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeHttpRequests()
              .antMatchers("/info").hasRole("INFO") //login: user, password: pas
              .antMatchers("/admin").hasRole("ADMIN") //login: admin, password: password
              .antMatchers("/about").permitAll()
              .anyRequest().authenticated()
              .and().formLogin().defaultSuccessUrl("/about",true)
              .and().logout().and()
              .httpBasic();
    }

    @Bean
    public UserDetailsService users(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
}
