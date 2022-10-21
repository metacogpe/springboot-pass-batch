package com.pass.passbatch.repository.packaze;

import com.pass.passbatch.repository.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity   // package 를 엔터티로 선언, 아래에서 BaseEntity 를 상속 받음
@Table(name = "package")
public class PackageEntity extends BaseEntity {
    @Id  //pk 정의
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // pk 값을 위한 자동 생성 전략 : DB에 위임 설정
    private Integer packageSeq;

    private String packageName;
    private Integer count;
    private Integer period;

}
