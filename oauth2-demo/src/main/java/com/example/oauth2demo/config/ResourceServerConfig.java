package com.example.oauth2demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

// 서버 rest api 인증을 처리해주는 역할
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .resourceId("resource_id") // 내 클라이언트에서 처리하는 리소스 id
                .stateless(false); // 토큰 기반 인증만 허용할거면 true, 이외의 것도 허용할거면 false
    }

    // 인증관련 설정하는 곳
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .anonymous().disable() // todo 뭐하는건데 disable인지 알아보기.
                .authorizeRequests() // ??? 알아보기
                .antMatchers("/users/**").authenticated() // 이 uri는 인증이 되야한다.
                .and()
                .exceptionHandling() // 에러발생시
                .accessDeniedHandler(new OAuth2AccessDeniedHandler());//OAuth2AccessDeniedHandler 요걸 사용하도록 설정,
                                                                        // 원래는 브라우저 제공 팝업??
                                                                        // 폼로그인 활성되어있으면 폼로그인쪽으로 리다이렉트 해버린다.
    }

}
