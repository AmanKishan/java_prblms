package testingpurpose;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Arcesium {

	private final static String pricingApi = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing";
	private final static String holdingApi = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding";

	public static void main(String[] args) {
		doManipulation();
	}

	
	public static void doManipulation() {
		
		
	
		Map<String , List<HoldingApi>> holdingMap = new HashMap<>();
		
		Map<String , List<PricingApi>> priceMap =  getPriceApiDetailsCase2();
		
	
		List<PricingApi> priceApiList = new ArrayList<Arcesium.PricingApi>();
		
		List<HoldingApi> holdingList = new ArrayList<Arcesium.HoldingApi>();
		
		Map<String,PricingApi> pricingMap = new HashMap<String, Arcesium.PricingApi>();
		
        List<HoldingApi> holdings = new ArrayList<Arcesium.HoldingApi>();
        
        holdings.stream().map(holding -> 
        pricingMap.get(holding.getSecurity()).getPrice() * holding.getQuantity()
        ).mapToDouble(Double::doubleValue).sum(); 
		
	}
	
	
	
	private static List<PricingApi> getPriceApiDetails() {
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest httpRequest =HttpRequest.newBuilder(URI.create(pricingApi)).build();
		CompletableFuture<HttpResponse<Stream<String>>> completableFuture = client.sendAsync(httpRequest, BodyHandlers.ofLines());
		Stream<String> res = completableFuture.join().body();
		return res.map(Arcesium::covertJsonToObject).collect(Collectors.toList());
	
	}
	
		private static Map<String, PricingApi> getPriceApiDetailsCase2(String date) {
		
			Stream<String> text =null;
			try {
				URL url = new URL(pricingApi);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestProperty("accept", "application/json");
				InputStream responseStream = connection.getInputStream();
				 text = new BufferedReader(
					      new InputStreamReader(responseStream, StandardCharsets.UTF_8))
					        .lines();
					       
			    
			} catch ( IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return text.map(Arcesium::covertJsonToObject).filter(pricingApi -> Objects.nonNull(pricingApi) && date.equals(pricingApi.getDate()))
					.collect(Collectors.toMap(PricingApi::getSecurity,Function.identity()));
	
	}
	
	private static PricingApi covertJsonToObject(String str) {
		
		if(str.equals("[") || str.equals("]")) {
			return null;
		}
		
		Pattern pattern = Pattern.compile(":(.*?),");
		Matcher matcher = pattern.matcher(str);
		int i = 0;
		String date = null;
		String security = null;
		Float price = null;
		while (matcher.find()) {
			String data = matcher.group(1);
			i++;
			if(i ==1) {
				date = data.replace("\"", "");
			}else if (i == 2) {
				security = data.replace("\"", "");
			}else if ( i == 3) {
				price = Float.valueOf(data.replace("}", ""));
			}
			
		}
		return new PricingApi(security,date,price);
	}
	
	
private static HoldingApi covertHoldingApiJsonToObject(String str) {
		
		if(str.equals("[") || str.equals("]")) {
			return null;
		}
		
		Pattern pattern = Pattern.compile(":(.*?),");
		Matcher matcher = pattern.matcher(str);
		int i = 0;
		String date = null;
		String security = null;
		Double price = null;
		while (matcher.find()) {
			String data = matcher.group(1);
			i++;
			if(i ==1) {
				date = data.replace("\"", "");
			}else if (i == 2) {
				security = data.replace("\"", "");
			}else if ( i == 3) {
				price = Double.valueOf(data.replace("}", ""));
			}
			
		}
		return new PricingApi(security,date,price);
	}
	
	public static class PricingApi {

		private String security;
		private String date;
		private Double price;
		
		
		public PricingApi(String security, String date, Double price) {
			super();
			this.security = security;
			this.date = date;
			this.price = price;
		}
		public String getSecurity() {
			return security;
		}
		public void setSecurity(String security) {
			this.security = security;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		
		
	}

	public static class HoldingApi {
		
		private String security;
		private String date;
		private Integer quantity;
		private String portfolio;
		
		
		public HoldingApi(String security, String date, Integer quantity, String portfolio) {
			super();
			this.security = security;
			this.date = date;
			this.quantity = quantity;
			this.portfolio = portfolio;
		}
		public String getSecurity() {
			return security;
		}
		public void setSecurity(String security) {
			this.security = security;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public String getPortfolio() {
			return portfolio;
		}
		public void setPortfolio(String portfolio) {
			this.portfolio = portfolio;
		}
		
		
	}

}
