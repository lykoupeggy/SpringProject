package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Quote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
public class Controller {

    @GetMapping(value = "/quote")
    public String getQuote() {
        String url = "https://zenquotes.io/api/quotes";
        RestTemplate restTemplate = new RestTemplate();

        Quote[] quotes = restTemplate.getForObject(url, Quote[].class);

        //Create a Quote List with the quotes
        List<Quote> q = Arrays.asList(quotes);

        //Create instance of Random class
        Random rand_int = new Random();

        //Generate random integers in range 0 to 49
        int rand = rand_int.nextInt(50);

        log.info("Received the request to get the quote");
        //Return random quote
        return q.get(rand).getH();
    }

}
