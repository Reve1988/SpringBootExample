package org.geniurd.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		// static 자료들은 여기서 처리해주는게 좋다.
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/simple/private").authenticated()
				.antMatchers("/**").permitAll();

		http.formLogin()
				// 로그인 페이지 : 컨트롤러 매핑을 하지 않으면 기본 제공되는 로그인 페이지가 뜬다.
				.loginProcessingUrl("/login");

		http.logout()
				// /logout 을 호출할 경우 로그아웃
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				// 로그아웃이 성공했을 경우 이동할 페이지
				.logoutSuccessUrl("/");
	}
}
