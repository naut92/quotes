package com.naut92.quotes.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.domain.AbstractPersistable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends AbstractPersistable<Long> {

    @Column(name = "firstname")
    String firstname;

    @Column(name = "lastname")
    String lastname;

    @Column(name = "email")
    @UniqueElements(message = "*This email is used")
    String email;

    @JsonManagedReference
    @JoinColumn(name = "user_id")
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            //mappedBy = "user",
            orphanRemoval = true)
    List<Quote> quotes;
}
