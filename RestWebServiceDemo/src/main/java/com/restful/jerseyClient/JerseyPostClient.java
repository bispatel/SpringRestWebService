package com.restful.jerseyClient;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.Client;

public class JerseyPostClient {
	public static void main(String a[]) {

		String url = "http://localhost/RestfulWebserviceDemo/rest/order-inventory/insertOrder";
		String jsonInput = "{\"custmer\":\"Java2novice\",\"address\":\"Bangalore\"," + "\"bill-amount\":\"$2000\"}";
		Client restClient = Client.create();
		WebResource webResource = restClient.resource(url);
		ClientResponse resp = webResource.type("application/json").post(ClientResponse.class, jsonInput);
		if (resp.getStatus() != 200) {
			System.err.println("Unable to connect to the server");
		}
		String output = resp.getEntity(String.class);
		System.out.println("response: " + output);
	}
}
