package com.nighthawk.spring_portfolio.mvc.cities; // Adjust the package name as per your project structure

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
@CrossOrigin(origins = "http://127.0.0.1:8085")
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
        return sortAndMeasureTime(SortingAlgorithms::bubbleSort, loadCityNames());
    }

    @GetMapping("/insertion")
    public ResponseEntity<?> insertionSortCities() {
        return sortAndMeasureTime(SortingAlgorithms::insertionSort, loadCityNames());
    }

    @GetMapping("/merge")
    public ResponseEntity<?> mergeSortCities() {
        return sortAndMeasureTime(SortingAlgorithms::mergeSort, loadCityNames());
    }

    @GetMapping("/selection")
    public ResponseEntity<?> selectionSortCities() {
        return sortAndMeasureTime(SortingAlgorithms::selectionSort, loadCityNames());
    }
}
