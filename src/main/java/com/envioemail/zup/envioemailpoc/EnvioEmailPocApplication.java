package com.envioemail.zup.envioemailpoc;

import com.envioemail.zup.envioemailpoc.input.OrderData;
import com.envioemail.zup.envioemailpoc.input.ProductData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EnvioEmailPocApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(EnvioEmailPocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ProductData prod = new ProductData("Ração", 2, 100.);
		ProductData prod1 = new ProductData("Pé de pato", 10, 150.);
		ProductData prod2 = new ProductData("Televisão", 3, 10002.);

		List<ProductData> products = new ArrayList<ProductData>();

		products.addAll(Arrays.asList(prod,prod1,prod2));

		OrderData.OrderDataBuilder orderData = OrderData.builder()
				.orderNumber(17117156)
				.prods(products);

		System.out.println("Saída = " +orderData.toString());
	}


}
