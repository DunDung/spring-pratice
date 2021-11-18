package com.example.oauth2demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.annotation.Resource;

// access 토큰 발급, 토큰 refresh, oauth 인증 처리, 모든 요청 처리 커스터마이징, 서버 설정
// 제일 먼저 바꿔야하는건 token store를 in memory아닌 db로 바꾸고 token store에 여러가지 app을 등록할 수 있는 방법을 제공해줘야한다.
@RequiredArgsConstructor
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    // 발급하는 토큰 저장하는 저장소, 기본적으로 in memory
    private final TokenStore tokenStore;

    // 시큐리티 핵심 인터페이스, 실제로 인증하는 주체, 인증 시 많은 개입을 함.
    private final AuthenticationManager authenticationManager;

    @Resource(name = "userService")
    private UserDetailsService userDetailsService;

    // 다른 config에서 authenticationManagerBuilder를 passwordEncoder쓰게 커스터마이징해서, secret 키 값을 디코딩해볼거라서 인코딩해주는 로직을 위함.
    private final PasswordEncoder passwordEncoder;


    // oauth 토큰을 받으려면 여기 등록되어있는 클라이언트로 인증이되야한다. 이 정보로 인증을 처리하는 애가 AuthenticationManager
    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
        configurer
                .inMemory()
                .withClient("dundung-client") // app-name
                .secret(passwordEncoder.encode("dundung-password")) // app-secret-key
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implict")
                .scopes("read", "write", "trust")
                .accessTokenValiditySeconds(1 * 60 * 60) // 1시간
                .refreshTokenValiditySeconds(6 * 60 * 60); // 6시간
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }

}
