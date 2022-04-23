package com.naut92.quotes.service;

import com.naut92.quotes.model.Quote;
import com.naut92.quotes.model.User;
import com.naut92.quotes.repository.QuoteRepository;
import com.naut92.quotes.repository.UserRepository;
import com.naut92.quotes.service.intf.QuoteService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class QuoteServiceImpl implements QuoteService {
    private final QuoteRepository repository;
    private final UserRepository userRepository;


    public QuoteServiceImpl(QuoteRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public Collection<Quote> getAllQuotesByTopicAndRating() {
        //return repository.findAllByTopicAndRating();
        return null;
    }

    @Override
    public Collection<Quote> getAllQuotesByUserId(Long id) {
        //User user = userRepository.getById(id);
        return repository.findAllByUserId(id);
    }

    @Override
    public Collection<Quote> getAllQuotesByTopic(String topic) {
        return null;
    }

    @Override
    public Quote createQuote(String topic, Long userId) {
        return null;
    }

    @Override
    public Quote updateQuote(String topic, Long userId, Long quoteId) {
        return null;
    }

    @Override
    public void deleteQuote(Long userId, Long quoteId) {

    }
}
