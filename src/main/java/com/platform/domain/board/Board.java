package com.platform.domain.board;

import com.platform.domain.user.User;
import io.leangen.graphql.annotations.types.GraphQLType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@GraphQLType
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Board(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

}
