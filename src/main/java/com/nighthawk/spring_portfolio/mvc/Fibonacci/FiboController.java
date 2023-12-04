package com.nighthawk.spring_portfolio.mvc.Fibonacci;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nighthawk.spring_portfolio.mvc.cities.SortingAlgorithms;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:4100")
public class FiboController {
    @GetMapping("/fibofor")
    public ResponseEntity<?> getFor(int n) {
        long startTime = System.nanoTime();
        long[] fiboFor = FibonacciFor.calculateFibonacci(n);
        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        var response = new Object() {
            public final long[] fiboForRes = fiboFor;
            public final double timeInSeconds = durationInSeconds;
        };
        HttpHeaders responseHeaders = new HttpHeaders();
        // responseHeaders.set("Access-Control-Allow-Origin", "http://127.0.0.1:4100");
        // return ResponseEntity.ok().headers(responseHeaders).body(response);
        return ResponseEntity.ok(response);

    }
    @GetMapping("/fibowhile")
    public ResponseEntity<?> getWhile(int n) {
        long startTime = System.nanoTime();
        long[] fiboWhile = FibonacciWhile.calculateFibonacci(n);
        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        var response = new Object() {
            public final long[] fiboWhileRes = fiboWhile;
            public final double timeInSeconds = durationInSeconds;
        };
        HttpHeaders responseHeaders = new HttpHeaders();
        // responseHeaders.set("Access-Control-Allow-Origin", "*");
        // return ResponseEntity.ok().headers(responseHeaders).body(response);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/fiborecursive")
    public ResponseEntity<?> getRecursive(int n) {
        long startTime = System.nanoTime();
        long[] fiboRecursive = FibonacciRecursive.calculateFibonacci(n);
        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        var response = new Object() {
            public final long[] fiboRecursiveRes = fiboRecursive;
            public final double timeInSeconds = durationInSeconds;
        };
        HttpHeaders responseHeaders = new HttpHeaders();
        // responseHeaders.set("Access-Control-Allow-Origin", "*");
        // return ResponseEntity.ok().headers(responseHeaders).body(response);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/fibostream")
    public ResponseEntity<?> getStream(int n) {
        long startTime = System.nanoTime();
        long[] fiboStream = FibonacciStream.calculateFibonacci(n);
        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        var response = new Object() {
            public final long[] fiboStreamRes = fiboStream;
            public final double timeInSeconds = durationInSeconds;
        };
                HttpHeaders responseHeaders = new HttpHeaders();
        // responseHeaders.set("Access-Control-Allow-Origin", "*");
        // return ResponseEntity.ok().headers(responseHeaders).body(response);
        return ResponseEntity.ok(response);
    }
}
