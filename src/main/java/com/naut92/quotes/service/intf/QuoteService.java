package com.naut92.quotes.service.intf;

import com.naut92.quotes.model.Quote;

import java.util.Collection;

public interface QuoteService {
    Collection<Quote> getAllQuotesByTopicAndRating();
    Collection<Quote> getAllQuotesByUserId(Long id);
    Collection<Quote> getAllQuotesByTopic(String topic);
    Quote createQuote(String topic, Long userId);
    Quote updateQuote(String topic, Long userId, Long quoteId);
    void deleteQuote(Long userId, Long quoteId);
}
