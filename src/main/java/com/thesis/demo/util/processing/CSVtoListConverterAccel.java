package com.thesis.demo.util.processing;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.thesis.demo.models.ChartData;
import com.thesis.demo.services.ExperimentDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVtoListConverterAccel implements CSVtoListConverter{

    public List<ChartData> CSVtoList(String path) {
        List<ChartData> result = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] line;
            Boolean titleLine = true;
            while ((line = reader.readNext()) != null) {
                if (titleLine) {
                    titleLine = false;
                    continue;
                }
                if (line.length >= 3) {
                    result.add(new ChartData(line[0], Double.parseDouble(line[1])));
                } else {
                    System.err.println("Строка не содержит нужного столбца");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
