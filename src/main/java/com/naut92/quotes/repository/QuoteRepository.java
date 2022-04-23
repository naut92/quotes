package com.naut92.quotes.repository;

import com.naut92.quotes.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    Collection<Quote> findAllByUserId(Long userId);
    //Collection<Quote> findAllByTopicAndRating();
}
