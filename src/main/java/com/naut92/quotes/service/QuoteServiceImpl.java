package com.naut92.quotes.service;

import com.naut92.quotes.model.Quote;
import com.naut92.quotes.model.Topic;
import com.naut92.quotes.model.User;
import com.naut92.quotes.repository.QuoteRepository;
import com.naut92.quotes.repository.UserRepository;
import com.naut92.quotes.service.intf.QuoteService;
import org.springframework.stereotype.Service;

import java.time.Instant;
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
    public Quote createQuote(Long userId, Quote quote) {
        User user = userRepository.getById(userId);
        quote.setUser(user);
        quote.setTimestamp(Instant.now());
        return repository.save(quote);
    }

    @Override
    public Quote updateQuote(Long quotId, Quote quote) {
        Quote existQuote = repository.getById(quotId);
        existQuote.setText(quote.getText());
        existQuote.setLike(quote.getLike());
        existQuote.setDislike(quote.getDislike());
        existQuote.setTimestamp(Instant.now());
        return repository.save(existQuote);
    }

    @Override
    public void deleteQuote(Long quoteId) {
        repository.deleteById(quoteId);
    }
}
