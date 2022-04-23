package com.naut92.quotes.service;

import com.naut92.quotes.model.Quote;
import com.naut92.quotes.model.Topic;
import com.naut92.quotes.model.User;
import com.naut92.quotes.repository.QuoteRepository;
import com.naut92.quotes.repository.UserRepository;
import com.naut92.quotes.service.intf.QuoteService;
import com.naut92.quotes.service.intf.Rating;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class QuoteServiceImpl implements QuoteService {
    private final QuoteRepository repository;
    private final UserRepository userRepository;

    public QuoteServiceImpl(QuoteRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public Collection<Quote> getAllQuotesByTopicAndRatingBest10(Topic topic) {
        Collection<Quote> allByTopicAndRating = repository.findAllByTopicAndRating(topic);
        allByTopicAndRating.forEach(q -> q.setRating(q.getLike() - q.getDislike()));

        List<Quote> sortedTopicByRating = allByTopicAndRating.stream()
                .sorted((f1, f2) -> Long.compare(f2.getRating(), f1.getRating()))
                .collect(Collectors.toList());
        return IntStream.range(0, 9).mapToObj(sortedTopicByRating::get).collect(Collectors.toList());
    }
    @Override
    public Collection<Quote> getAllQuotesByUserId(Long id) {
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
