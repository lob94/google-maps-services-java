package com.google.maps.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.Currency;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.google.gson.stream.JsonReader;
import com.google.maps.SmallTests;
import com.google.maps.model.Fare;

@Category(SmallTests.class)
public class FareAdapterTest {

	// AIzaSyCRV1j4tMHwypEf35LuPX2Zt0qHkqvOnpo
	// "../../resources/fare.json"
	@Test
	public void testFareAdapterRead() throws IOException {
		FareAdapter x = new FareAdapter();
		String path = Paths.get(".").toAbsolutePath().normalize().toString();
		File initialFile = new File(path + "/src/test/resources/com/google/maps/fare.json");
		InputStream in = new FileInputStream(initialFile);
		JsonReader jsonReader = new JsonReader(new InputStreamReader(in, "UTF-8"));
		Fare fare = x.read(jsonReader);
		Assert.assertEquals(fare.currency, Currency.getInstance("EUR"));
		Assert.assertEquals(fare.value, new BigDecimal(10));
	}

}
