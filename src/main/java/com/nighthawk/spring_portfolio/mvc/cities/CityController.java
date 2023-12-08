package com.nighthawk.spring_portfolio.mvc.cities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = {"http://127.0.0.1:4100", "https://sortingminiproject.github.io"})
public class CityController {

    private final String jsonFilePath = "cities.json"; // Adjust the path if necessary

    private List<String> loadCityNames() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(jsonFilePath);
        List<String> cityNames = new ArrayList<>();

        try {
            JsonNode rootNode = mapper.readTree(file);
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    JsonNode nameNode = node.get("name");
                    if (nameNode != null) {
                        cityNames.add(nameNode.asText());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cityNames;
    }

    private ResponseEntity<?> sortAndMeasureTime(Function<List<String>, List<String>> sortFunction, List<String> data) {
        long startTime = System.nanoTime();
        List<String> sortedData = sortFunction.apply(data);
        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0; // Convert nanoseconds to seconds

        System.out.println("Time taken (seconds): " + durationInSeconds);

        // Create a response object with sorted data and time taken
        var response = new Object() {
            public final List<String> sortedCities = sortedData;
            public final double timeInSeconds = durationInSeconds;
        };

        return ResponseEntity.ok(response);
    }

    @GetMapping("/bubble")
    public ResponseEntity<?> bubbleSortCities() {
        BubbleSort bubbleSort = new BubbleSort();
        return sortAndMeasureTime(bubbleSort::sort, loadCityNames());
    }

    @GetMapping("/insertion")
    public ResponseEntity<?> insertionSortCities() {
        InsertionSort insertionSort = new InsertionSort();
        return sortAndMeasureTime(insertionSort::sort, loadCityNames());
    }

    @GetMapping("/merge")
    public ResponseEntity<?> mergeSortCities() {
        MergeSort mergeSort = new MergeSort();
        return sortAndMeasureTime(mergeSort::sort, loadCityNames());
    }

    @GetMapping("/selection")
    public ResponseEntity<?> selectionSortCities() {
        SelectionSort selectionSort = new SelectionSort();
        return sortAndMeasureTime(selectionSort::sort, loadCityNames());
    }
}
