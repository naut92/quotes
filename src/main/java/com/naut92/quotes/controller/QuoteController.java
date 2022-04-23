package com.naut92.quotes.controller;

import com.naut92.quotes.model.Quote;
import com.naut92.quotes.service.intf.QuoteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
//quotes

@Description("География присутствия")
public class QuoteController {
    private final QuoteService service;

    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get quotes by rating")
    @GetMapping("/rating")
    public ResponseEntity<?> getQuotesByRating() {
        Collection<Quote> quotes = service.getAllQuotesByRating();
        return ResponseEntity.ok().body(quotes);
    }

    @ApiOperation(value = "Get quotes by user Id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getQuotesByUserId(@PathVariable Long id) {
        Collection<Quote> quotes = service.getAllQuotesByUserId(id);
        return ResponseEntity.ok().body(quotes);
    }

    @ApiOperation(value = "Get all quotes by Topic")
    @GetMapping("/{topic}")
    public ResponseEntity<?> getQuotesByUserId(@PathVariable String topic) {
        Collection<Quote> quotes = service.getAllQuotesByTopic(topic);
        return ResponseEntity.ok().body(quotes);
    }

    @ApiOperation(value = "Get all quotes by Topic")
    @PostMapping("/{topic}/{userId}")
    public ResponseEntity<?> createQuote(@PathVariable String topic, @PathVariable Long userId) {
        Quote quote = service.createQuote(topic, userId);
        return ResponseEntity.ok().body(quote);
    }
    @ApiOperation(value = "Get all quotes by Topic")
    @PutMapping("/{topic}/{userId}/{quoteId}")
    public ResponseEntity<?> updateQuote(@PathVariable String topic, @PathVariable Long userId, @PathVariable Long quoteId) {
        Quote quote = service.updateQuote(topic, userId, quoteId);
        return ResponseEntity.ok().body(quote);
    }

    @ApiOperation(value = "Get all quotes by Topic")
    @DeleteMapping("/{userId}/{quoteId}")
    public void deleteQuote( @PathVariable Long userId, @PathVariable Long quoteId) {
        service.deleteQuote(userId, quoteId);
    }
}
