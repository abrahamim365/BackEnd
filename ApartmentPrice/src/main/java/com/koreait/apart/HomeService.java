package com.koreait.apart;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.koreait.apart.model.ApartmentInfoEntity;
import com.koreait.apart.model.ResponseDomain;

@Service
public class HomeService {
	
	public void getData(ApartmentInfoEntity p) {
		final String serviceKey = "Y2UOCkD8Ilv2gViPGV33ddNTTQfRi92i8mRzUeQX%2BNgSiNTO3gp9hJZX4J6u8uXucMM6RdRBoGxMn6XHfsEzNA%3D%3D";
		final String url = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
		String decodeServiceKey = null;
		
		final String lawd_cd = p.getRegional_code();
		final String deal_ym = p.getDeal_year() + p.getDeal_month();
		
		try {
			decodeServiceKey = URLDecoder.decode(serviceKey,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		final HttpHeaders headers = new HttpHeaders(); //응답과 요청은 header와 body로 나누어졌다.
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		final HttpEntity entity = new HttpEntity(headers);
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
								.queryParam("LAWD_CD",lawd_cd)
								.queryParam("DEAL_YMD",deal_ym)
								.queryParam("serviceKey",decodeServiceKey)
								.build(false);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters()
		.add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		
		System.out.println("uri : "+builder.toUriString());
		
		ResponseEntity respEntity =
				restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
		
		String result = (String)respEntity.getBody(); 
		
		ObjectMapper om = new XmlMapper()
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		ResponseDomain domain = null;
		try {
			domain = om.readValue(result, ResponseDomain.class);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		List<ApartmentInfoEntity> list = domain.getBody().getItems();
		
	}
}







