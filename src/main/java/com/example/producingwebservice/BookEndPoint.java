package com.example.producingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetBookRequest;
import io.spring.guides.gs_producing_web_service.GetBookResponse;

@Endpoint
public class BookEndPoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private BookRepository bookRepository;

    @Autowired      // artinya bookendpoint meng injecting data dari  bookrepository (mengambil objeknya)
    public BookEndPoint(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
    @ResponsePayload        // payload artinya request yg dikirim dari depan (dari user)
    public GetBookResponse getBook(@RequestPayload GetBookRequest request) { // request isinya title
        GetBookResponse response = new GetBookResponse();
        response.setBook(bookRepository.findBook(request.getTitle()));

        return response;
    }
}