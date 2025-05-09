package com.ifto.clinicamedica.model.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration //classe de configuração
@EnableWebSecurity //indica ao Spring que serão definidas configurações personalizadas de segurança
public class SecurityConfiguration {

    @Autowired
    UsuarioDetailsConfig usuarioDetailsConfig;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        customizer ->
                                customizer

                                        //todos podem cadastrar, editar um paciente
                                        .requestMatchers("/paciente/form").permitAll()
                                        .requestMatchers(HttpMethod.GET, "paciente/form").permitAll()
                                        .requestMatchers(HttpMethod.POST, "paciente/save").permitAll()
                                        .requestMatchers(HttpMethod.POST, "paciente/update").permitAll()
                                        //Apenas ADMINS podem deletar um paciente
                                        .requestMatchers(HttpMethod.POST,"/removePaciente/").hasAnyRole("ADMIN")

                                        //Apenas médicos e ADMINS podem realizar ações em consultas
                                        .requestMatchers("/consulta/*").hasAnyRole("MEDICO", "ADMIN")
                                        .requestMatchers("/consulta/list").hasAnyRole("MEDICO", "ADMIN")
                                        .requestMatchers("/consulta/save").hasAnyRole("MEDICO", "ADMIN")
                                        .requestMatchers("/consulta/update").hasAnyRole("MEDICO", "ADMIN")


                                        //Apenas ADMINS podem remover consultas
                                        .requestMatchers("/removeConsulta/{id}").hasAnyRole( "ADMIN")

                                        //Apenas ADMINS podem salvar, e deletar médicos
                                        .requestMatchers("/medico/form").hasAnyRole("ADMIN")
                                        .requestMatchers("/medico/*").hasAnyRole("ADMIN")


                                        .anyRequest() //define que a configuração é válida para qualquer requisição.
                                        .authenticated() //define que o usuário precisa estar autenticado.

                )
                .formLogin(customizer ->
                        customizer
                                .loginPage("/login") //passamos como parâmetro a URL para acesso à página de login que criamos
                                .defaultSuccessUrl("/home", true)
                                .permitAll() //define que essa página pode ser acessada por todos, independentemente do usuário estar autenticado ou não.
                )
                //.httpBasic(withDefaults()) //configura a autenticação básica (usuário e senha)
                .logout(LogoutConfigurer::permitAll) //configura a funcionalidade de logout no Spring Security.

                .rememberMe(withDefaults()); //permite que os usuários permaneçam autenticados mesmo após o fechamento do navegador
        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user1 = User.withUsername("user")
//                .password(passwordEncoder().encode("123"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1, admin);
//    }

    @Autowired
    public void configureUserDetails(final AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(usuarioDetailsConfig).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * Com o método, instanciamos uma instância do encoder BCrypt e deixando o controle dessa instância como responsabilidade do Spring.
     * Agora, sempre que o Spring Security necessitar condificar um senha, ele já terá o que precisa configurado.
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
