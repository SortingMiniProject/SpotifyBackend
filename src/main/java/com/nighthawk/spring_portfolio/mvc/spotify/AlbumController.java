package com.nighthawk.spring_portfolio.mvc.spotify;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    @GetMapping("/list")
    public ResponseEntity<List<String>> getAllAlbumNames() {
        List<String> albumNames = new ArrayList<>();
        String line = "";
        String delimiter = ","; // CSV delimiter, usually a comma

        // Path to the dataset.csv file in the current directory
        String csvFile = Paths.get("dataset.csv").toAbsolutePath().toString();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header row if your CSV has one
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                albumNames.add(data[0]); // Assuming album_name is the first column
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }

        return ResponseEntity.ok(albumNames);
    }
}
