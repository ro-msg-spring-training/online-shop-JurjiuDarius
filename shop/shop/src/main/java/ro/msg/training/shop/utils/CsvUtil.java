package ro.msg.training.shop.utils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvUtil<T> {
	
	public List<T> fromCSV(Class<T> tClass, String inputFile) throws IOException {
		CsvMapper mapper = new CsvMapper();
		MappingIterator<T> it = mapper.readerFor(tClass).readValues(inputFile);
		List<T> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		
		return list;
	}
	
	public void toCSV(List<T> list, Class<T> tClass, String outputFile) throws IOException {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(tClass.getClass());
		ObjectWriter myObjectWriter = mapper.writer(schema);
		File tempFile = new File(outputFile);
		FileOutputStream tempFileOutputStream = new FileOutputStream(tempFile);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
		OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
		myObjectWriter.writeValue(writerOutputStream, list);
	}
	
}
