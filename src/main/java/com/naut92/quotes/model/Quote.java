package com.naut92.quotes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "quote")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quote extends AbstractPersistable<Long> {

    @Column(name = "text")
    String text;

    @Column(name = "topic")
    Topic topic;

    @Column(name = "like_q")
    Long like;

    @Column(name = "dislike")
    Long dislike;

    @Column(name = "timestamp")
    Instant timestamp;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User userById;
}
