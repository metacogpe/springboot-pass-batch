package com.pass.passbatch.repository;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass  // 하위 클래스가 상속받으면 createdAt과 modifiedAt을 컬럼으로 인식
// JPA엔터티의 이벤트(생성/변경) 시 콜백처리로 시간 만들어 줌, AuditingEntityLister 클래스를 arg 로 넘겨 처리
// 이러한 설정을 enable 해주는 곳이 JpaConfig
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate   // 생성시 시간 자동 저장
    @Column(updatable = false, nullable = false)  // 업데이트시는 동작하지 않고, null 은  미허용
    private LocalDateTime createdAt;
    @LastModifiedDate  // 변경시 시간 자동 업데이트
    private LocalDateTime modifiedAt;
}
