package com.helmihealthcare.login_logout;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${spring.security.oauth2.client.registration.oauth2-client-credentials.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.oauth2-client-credentials.client-secret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.client.registration.oauth2-client-credentials.authorization-grant-type}")
    private String grantType;


    public ResponseEntity<LoginResponse> login(LoginRequest loginrequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String ,String> map = new LinkedMultiValueMap<>();
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("grant_type", grantType);
        map.add("username", loginrequest.geUsername());
        map.add("password", loginrequest.getPassword());

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, headers);

        ResponseEntity<LoginResponse> response = restTemplate.postForEntity("http://localhost:8081/realms/keycloak/protocol/openid-connect/token", httpEntity, LoginResponse.class);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());

    }


    public ResponseEntity<IntrospectResponse> introspect(Token token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String ,String> map = new LinkedMultiValueMap<>();
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("token", token.getToken());

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, headers);

        ResponseEntity<IntrospectResponse> response = restTemplate.postForEntity("http://localhost:8081/realms/keycloak/protocol/openid-connect/token/introspect", httpEntity, IntrospectResponse.class);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }


    public ResponseEntity<Response> logout(Token token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String ,String> map = new LinkedMultiValueMap<>();
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("refresh_token", token.getToken());

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, headers);

        ResponseEntity<Response> response = restTemplate.postForEntity("http://localhost:8081/realms/keycloak/protocol/openid-connect/logout", httpEntity, Response.class);

        Response res = new Response();
        if(response.getStatusCode().is2xxSuccessful()){
            res.setMessage("Logged out successfully");
        }
        System.out.println(res.getMessage());
        return new ResponseEntity<>(res, org.springframework.http.HttpStatus.OK);
    }

}
