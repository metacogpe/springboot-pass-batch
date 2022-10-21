package com.pass.passbatch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // DB테이블에 생성일시를 자동으로 입력 (created_at, modified_at)
@Configuration
public class JpaConfig {
}
