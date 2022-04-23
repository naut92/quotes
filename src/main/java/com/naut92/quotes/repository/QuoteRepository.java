package com.naut92.quotes.repository;

import com.naut92.quotes.model.Quote;
import com.naut92.quotes.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    Collection<Quote> findAllByUserId(Long userId);
    @Query("select q, (q.like-q.dislike) from Quote q where q.topic = (:topic) group by q.id order by q.like desc")
    Collection<Quote> findAllByTopicAndRating(@Param("topic") Topic topic);
}
