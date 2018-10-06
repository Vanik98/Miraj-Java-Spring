package miraj.pack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

                    .antMatchers("/fonts/**","/js/**","/css/**","/images/**","/","/en-home","/am-home","/ru-home","/reserve","/message").permitAll()
                    .antMatchers("/bootstrap-3.3.2/css/**","/fancybox/**","/fonts/**","/js/**","/css/**","/images/**","/en-image","/am-image","/ru-image").permitAll()
                    .antMatchers("/booking/font/**","/booking/js/**","/booking/css/**","/fonts/**","/js/**","/css/**","/en-images/**","/en-reservation","/am-reservation","/ru-reservation").permitAll()
                    .antMatchers("/fonts/**","/js/**","/css/**","/images/**","/en-information","/am-information","/ru-information").permitAll()
                    .antMatchers("/fonts/**","/js/**","/css/**","/images/**","/en-contacts","/am-contacts","/ru-contacts").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("my-miraj-username")
                        .password("my-miraj-password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .usersByUsernameQuery("select username, password, active from usr where username=?")
//                .authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?");
//    }
}
