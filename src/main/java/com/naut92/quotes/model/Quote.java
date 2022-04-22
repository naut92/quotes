package com.naut92.quotes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class Quote extends AbstractPersistable<Long> {

    @Column(name = "text")
    private String text;

    @Column(name = "like")
    private Long like;

    @Column(name = "dislike")
    private Long dislike;

    @Column(name = "timestamp")
    private Instant timestamp;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User quoteById;
}
