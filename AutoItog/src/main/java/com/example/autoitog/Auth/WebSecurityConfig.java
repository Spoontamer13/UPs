package com.example.autoitog.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

//Конфигурационный класс
@Configuration
//EnableWebSecurity - указывает, что класс имеет настрйоки безопасности
@EnableWebSecurity
//Аннотация, включающая использование аннотаций безопасности на уровне методов
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    //Внедрение зависимости для доступа к базе данных
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder; //Кодировщик пароля

    @Bean
    //Кодировщик пароля
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder(8);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication() // Настройка аутентификации на основе данных из базы данных
                .dataSource(dataSource) // Устанавливаем источник данных
                .passwordEncoder(getPasswordEncoder()) // Устанавливаем кодировщик пароля
                .usersByUsernameQuery("select [Login], [Password], [Role_ID] from [Users] where [Login] = ?") // SQL-запрос для получения информации о пользователе по его логину
                .authoritiesByUsernameQuery("select [Login], [Name_Role] from [Users] inner join [Roles] on [Role_ID] = Roles.Id  where [Login] = ?"); // SQL-запрос для получения ролей пользователя по его логину
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // Настройка авторизации для запросов
                .antMatchers("/login","/registration").permitAll() // Указание URL-адресов, доступных без аутентификации
                .anyRequest().authenticated() // Указание того, что остальные запросы требуют аутентификации
                .and().formLogin().loginPage("/login") // Настройка входа в систему через форму аутентификации, задание URL-адреса страницы входа
                .defaultSuccessUrl("/") // URL-адрес, на который перенаправляется пользователь после успешной аутентификации
                .permitAll() // Разрешение доступа к странице входа всем пользователям
                .and().logout().permitAll() // Разрешение выхода из системы всем пользователям
                .and().csrf().disable().cors().disable(); // Отключение защиты CSRF и настройка CORS
    }
}