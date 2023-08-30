package com.qkrtprjs.springbootproject.domain.posts;

import com.qkrtprjs.springbootproject.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

//해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확하게 구분할 수가 없어, 차후 기능 변경 시 정말 복잡해진다.
//따라서 Entity클래스에는 절대로 Setter메소드를 만들지 않습니다. 값 변경이 필요하다면 명확한 목적과 의도를 갖는 메소드를 추가한다

@Getter
@NoArgsConstructor
@Entity
@ToString
public class Posts extends BaseTimeEntity {
    @Id //해당 필드가 PK임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙을 나타낸다.
    private Long id;    //Long 타입에 Auto_increment 추천

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
