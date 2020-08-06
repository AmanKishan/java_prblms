package testingpurpose;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	

	public static void main(String[] args) throws IOException {

	
		System.out.println("insert into stage_country_zip (country_id ,country_code ,zip_code ,place_name ,admin_name_1 ,admin_code_1 ,admin_name_2 ,admin_code_2 ,admin_name_3 ,admin_code_3 ,latitude ,longitude ,accuracy ) values ");
		String insert_query = "insert into stage_country_zip (country_id ,country_code ,zip_code ,place_name ,admin_name_1 ,admin_code_1 ,admin_name_2 ,admin_code_2 ,admin_name_3 ,admin_code_3 ,latitude ,longitude ,accuracy ) values ";
		Stream<String> rows = Files.lines(Paths.get("C:\\Users\\aman_rastogi\\Downloads\\allCountries\\allCountries2 - Copy.txt"),Charset.forName("ISO-8859-1"));
		AtomicInteger atomicInteger = new AtomicInteger(599999);
		
		List<String> list  =rows.
		map(x -> x.split(","))
		.map(x ->  insert_query + "( "  + atomicInteger.getAndIncrement() + ",'" + x[0]  +"','"+ x [1] +
				"','" + x[2] +"','"+ x [3] +
				"','" + x[4] +"','"+ x [5] +
				"','" + x[6] +"','"+ x [7] +
				"','" + x[8] +"',"+ x [9] +
				"," + x[10] +","+ x [11] +
				
				" );" ).collect(Collectors.toList());
		 
		rows.close();
		// list.forEach(System.out::println);
		 
		 Path file = Paths.get("C:\\Users\\aman_rastogi\\Downloads\\allCountries\\insert_script2.txt");
		 
		 Files.write(file, list, Charset.forName("UTF-8"));
		 /*
		FileWriter writer = new FileWriter(file.toFile());

		 try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\aman_rastogi\\Downloads\\allCountries\\allCountries - Copy (2).txt"))) {
		     lines.forEach(new Consumer<String>() {
		         int i = 0;
		         public void accept(String line) {
		             try {
		                 writer.write((i++) + "," + line + System.lineSeparator());
		             } catch (Exception e) {
		                 e.printStackTrace();
		             }
		         }
		     });
		     writer.close();
		 }
		 */
	/*	.forEach(x ->
		System.out.println(
			 x[0] + "---" + x[1] + "---" + x[2]
			+ "---" + x[0] + "---" + x[1] + "---" + x[2]
			+ "---" + x[3] + "---" + x[4] + "---" + x[5]
			+ "---" + x[6] + "---" + x[7] + "---" + x[8]
			+ "---" + x[9] + "---" + x[10] + "---" + x[11]
			
				)
		
		
		
				);*/
	}

}
