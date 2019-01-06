/**
 * 
 */
package com.ustc.reed.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.removeAllMappings;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;


public class MockServer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		configureFor(8062);
	//	removeAllMappings();
		stubFor(get(urlPathEqualTo("/order/1")).willReturn(aResponse().withBody("{\"id:\":1}").withStatus(200)));



	//	mock("/dept/findAll", "01");
	//	mock("/order/2", "02");
	}



	private static void mock(String url, String file) throws IOException {
		ClassPathResource resource = new ClassPathResource("mock/response/" + file + ".txt");
		String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(), "\n");

		stubFor(get(urlPathEqualTo(url)).willReturn(aResponse().withBody(content).withStatus(200)));
	}

}
