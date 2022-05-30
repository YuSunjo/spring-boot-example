package com.platform.domain.user;

import com.platform.domain.BaseTimeEntity;
import com.platform.domain.board.Board;
import io.leangen.graphql.annotations.types.GraphQLType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@GraphQLType
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Board> boardList = new ArrayList<>();

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

}
