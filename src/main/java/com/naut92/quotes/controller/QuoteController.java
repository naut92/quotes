package com.naut92.quotes.controller;

import com.naut92.quotes.model.Quote;
import com.naut92.quotes.model.Topic;
import com.naut92.quotes.service.intf.QuoteService;
import io.swagger.annotations.Api;
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

@RestController
@Api(value="Quote Management System")
@Description("Quotes")
public class QuoteController {
    private final QuoteService service;

    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get quotes by rating(Likes minus Dislike. Best 10")
    @GetMapping("/{topic}/quotes")
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

    @ApiOperation(value = "Create quote")
    @PostMapping("/topic/{userId}")
    public ResponseEntity<?> createQuote(@PathVariable Long userId, @RequestBody Quote quote) {
        return ResponseEntity.ok().body(service.createQuote(userId, quote));
    }
    @ApiOperation(value = "Update quote")
    @PutMapping("/topic/{quoteId}")
    public ResponseEntity<?> updateQuote(@PathVariable Long quoteId, @RequestBody Quote quote) {
        return ResponseEntity.ok().body(service.updateQuote(quoteId, quote));
    }

    @ApiOperation(value = "Delete quote by Id")
    @DeleteMapping("/delete/{quoteId}")
    public void deleteQuote( @PathVariable Long userId, @PathVariable Long quoteId) {
        service.deleteQuote(userId, quoteId);
    }
}
