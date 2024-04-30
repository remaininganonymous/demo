package com.thesis.demo.util.processing;


import com.opencsv.CSVWriter;
import com.thesis.demo.models.ChartData;
import com.thesis.demo.models.enums.Leg;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ListToCSVConverter {
    public String ListToCSV(List<ChartData> accel, List<ChartData> gyro, Leg leg, Boolean isFiltered) {
        String path = "src/main/java/com/thesis/demo/samples/";
        if (leg == Leg.LEFT) path = path.concat("left/");
        else if (leg == Leg.RIGHT) path = path.concat("right/");
        if (isFiltered) path = path.concat("filtered.csv");
        else path = path.concat("unfiltered.csv");
        try (CSVWriter writer = new CSVWriter(new FileWriter(path))) {
            String[] header = {"Time", "Accel", "Gyro"};
            writer.writeNext(header);

            String[] content = {"row", "row", "row"};
            for (int i = 0; i < accel.size(); i++) {
                content[0] = accel.get(i).getLabel();
                //if (i<=20) System.out.println("content[0] равен " + content[0]);
                if (content[0].equals(gyro.get(i).getLabel())) {
                    content[1] = accel.get(i).getValue().toString();
                    content[2] = gyro.get(i).getValue().toString();
                    if (i<=20) System.out.println("условие срабатыает");
                    else if (i == 21)System.out.println("...");
                } else {
                    content[0] = null;
                }

                writer.writeNext(content);
            }
            System.out.println("Файл сохранен в " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
