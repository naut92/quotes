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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "quotes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quote extends AbstractPersistable<Long> {

    @Column
    String text;

    @Column
    @Enumerated(EnumType.STRING)
    Topic topic;

    @Column(name = "like_q")
    Long like;

    @Column
    Long dislike;

    Long rating;

    @Column
    Instant timestamp;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;
}
