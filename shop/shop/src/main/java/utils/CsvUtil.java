package utils;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CsvUtil<T> {
    public List<T> fromCSV() {
//        CsvMapper csvMapper=new CsvMapper();
//        CsvSchema schema = CsvSchema.emptySchema().withHeader();
//
//        ObjectReader oReader = csvMapper.reader(T.class).with(schema);
//        List<T> courses = new ArrayList<>();
//
//        try (Reader reader = new FileReader("file.txt")) {
//            MappingIterator<T> mi = oReader.readValues(reader);
//            while (mi.hasNext()) {
//                T current = mi.next();
//                courses.add(current);
//                System.out.println(current);
//            }


        return null;
    }

}
