package testingpurpose;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jdk.internal.vm.annotation.Stable;

public class TestAman {
	
	private static final Consumer<String> aman = s -> new String();
	
	

	private static final String PRICE_API = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing";

	private static final String HOLDING_API = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding";
	

	private static final Pattern pattern = Pattern.compile(":(.*?),");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

		System.out.println(calculateNAV("20190725"));
	}

	public static double calculateNAV(String date) {

		if (Objects.isNull(date) && "".equals(date)) {
			return 0.0;
		}
		Map<String, PriceApi> pricingMap = getPriceApiData(date);
		List<HoldingApi> holdings = getHoldingApiData(date);
		return holdings.stream()
				.map(holding -> {
					//System.out.println( holding.getSecurity() + " " + pricingMap.get(holding.getSecurity()).getPrice() + " * " + holding.getQuantity());
					return pricingMap.get(holding.getSecurity()).getPrice() * holding.getQuantity();
				})
				.mapToDouble(Double::doubleValue).sum();
	}

	private static Map<String, PriceApi> getPriceApiData(String date) {

		Stream<String> response = getHttpResponse(PRICE_API);
		return response.map(TestAman::parsePriceApiData)
				.filter(priceApi -> Objects.nonNull(priceApi) && date.equals(priceApi.getDate().trim()))
				.collect(Collectors.toMap(PriceApi::getSecurity, Function.identity()));
	}

	private static PriceApi parsePriceApiData(String str) {

		if (str.equals("[") || str.equals("]")) {
			return null;
		}

		Matcher matcher = pattern.matcher(str);
		int i = 0;
		String date = "";
		String security = "";
		Double price = 0.0;

		while (matcher.find()) {
			String data = matcher.group(1);
			i++;
			if (i == 1) {
				date = data.replace("\"", "").trim();
			} else if (i == 2) {
				security = data.replace("\"", "").trim();
			} else if (i == 3) {
				price = Double.valueOf(data.replace("}", "").trim());
			}
		}

		return new PriceApi(security, date, price);
	}

	private static List<HoldingApi> getHoldingApiData(String date) {
		Stream<String> response = getHttpResponse(HOLDING_API);
		return response.map(TestAman::parseHoldingApiData)
				.filter(holdingApi -> Objects.nonNull(holdingApi) && date.equals(holdingApi.getDate()))
				.collect(Collectors.toList());
	}

	private static HoldingApi parseHoldingApiData(String str) {

		if (str.equals("[") || str.equals("]")) {
			return null;
		}

		Matcher matcher = pattern.matcher(str);
		int i = 0;
		String date = "";
		String security = "";
		Integer quantity = 0;
		String portfolio = "";

		while (matcher.find()) {
			String data = matcher.group(1);
			i++;
			if (i == 1) {
				date = data.replace("\"", "").trim();
			} else if (i == 2) {
				security = data.replace("\"", "").trim();
			} else if (i == 3) {
				quantity = Integer.valueOf(data.trim());
			} else if (i == 4) {
				portfolio = data.replace("}", "").trim();
			}
		}
		if(date.equals("20190725")) {
			
			System.out.println(security + " "  + date  + " " + " " +  quantity + " " + portfolio);
		}

		return new HoldingApi(security, date, quantity, portfolio);
	}

	private static Stream<String> getHttpResponse(String apiUrl) {
		Stream<String> response = Stream.empty();
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
			InputStream inputStream = connection.getInputStream();
			response = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines();
		} catch (IOException ex) {
			System.err.println(ex);
		}
		return response;
	}

	public static class PriceApi {

		private String security;
		private String date;
		private Double price;

		public PriceApi(String security, String date, Double price) {
			this.security = security;
			this.date = date;
			this.price = price;
		}

		public String getSecurity() {
			return security;
		}

		public String getDate() {
			return date;
		}

		public Double getPrice() {
			return price;
		}

	}

	public static class HoldingApi {

		private String security;
		private String date;
		private Integer quantity;
		private String portfolio;
		private Float marketPrice;

		public HoldingApi(String security, String date, Integer quantity, String portfolio) {
			this.security = security;
			this.date = date;
			this.quantity = quantity;
			this.portfolio = portfolio;
		}

		public String getSecurity() {
			return security;
		}

		public String getDate() {
			return date;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public String getPortfolio() {
			return portfolio;
		}

		public Float getMarketPrice() {
			return this.marketPrice;
		}

		public void setmarketPrice(Float marketPrice) {
			this.marketPrice = marketPrice;
		}
	}
}
