package com.naut92.quotes.controller;

import com.naut92.quotes.model.Quote;
import com.naut92.quotes.model.Topic;
import com.naut92.quotes.model.User;
import com.naut92.quotes.repository.UserRepository;
import com.naut92.quotes.service.intf.QuoteService;
import com.naut92.quotes.service.intf.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
//quotes

@Description("Quotes")
public class QuoteController {
    private final QuoteService service;
    private final UserService userService;
    private final UserRepository repository;

    public QuoteController(QuoteService service, UserService userService, UserRepository repository) {
        this.service = service;
        this.userService = userService;
        this.repository = repository;
    }

    @ApiOperation(value = "Get quotes by topic")
    @GetMapping("/{topic}")
    public ResponseEntity<?> getQuotesByRatingBest10(@PathVariable Topic topic) {
        Collection<Quote> quotes = service.getAllQuotesByTopicAndRatingBest10(topic);
        return ResponseEntity.ok().body(quotes);
    }

    @ApiOperation(value = "Get quotes by user Id")
    @GetMapping("/quotes/{userId}")
    public ResponseEntity<?> getQuotesByUserId(@PathVariable Long userId) {
        Collection<Quote> quotes = service.getAllQuotesByUserId(userId);
        return ResponseEntity.ok().body(quotes);
    }

    @ApiOperation(value = "Get all quotes by Topic")
    @GetMapping("/topic/{topic}")
    public ResponseEntity<?> getQuotesByTopic(@PathVariable String topic) {
        Collection<Quote> quotes = service.getAllQuotesByTopic(topic);
        return ResponseEntity.ok().body(quotes);
    }

    @ApiOperation(value = "Get all quotes by Topic")
    @PostMapping("/topic/{userId}")
    public ResponseEntity<?> createQuote(@PathVariable Long userId, @RequestBody Quote quote) {
        return ResponseEntity.ok().body(service.createQuote(userId, quote));
    }
    @ApiOperation(value = "Get all quotes by Topic")
    @PutMapping("/topic/{userId}/{quoteId}")
    public ResponseEntity<?> updateQuote(@PathVariable Long userId, @PathVariable Long quoteId) {
        Quote quote = service.updateQuote(userId, quoteId);
        return ResponseEntity.ok().body(quote);
    }

    @ApiOperation(value = "Get all quotes by Topic")
    @DeleteMapping("/{userId}/{quoteId}")
    public void deleteQuote( @PathVariable Long userId, @PathVariable Long quoteId) {
        service.deleteQuote(userId, quoteId);
    }

    @GetMapping("/users")
    public List<User> all(){
        return repository.findAll();
    }

}
