package com.noeticworld.apiEndpoint.repositories;

import com.noeticworld.apiEndpoint.model.HTTPRequestHandler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HttpRequestHandlerRepo extends JpaRepository<HTTPRequestHandler,String> {
//    void saveAll(HTTPRequestHandler httpRequestHandler);
}
