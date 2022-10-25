package com.noeticworld.apiEndpoint.repositories;


import com.noeticworld.apiEndpoint.model.HTTPRequestHandler;
import com.noeticworld.apiEndpoint.model.PartnerServiceConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface PartnerServiceConfigRepo extends JpaRepository<PartnerServiceConfigEntity, BigInteger> {
    @Query(value = "SELECT * FROM public.partner_service_config WHERE shortcode=:shortcode and username=:username",nativeQuery = true)
    List<PartnerServiceConfigEntity> findByShortcodeAndUsername(@Param("shortcode") String shortcode,
                                                                 @Param("username") String username);

//
//    @Query(value = "UPDATE public.partner_service_config\n" +
//            "SET mt_serviceid='', operatorid=0, partnerid=0, password_='', serviceid='', shortcode='', username=''\n" +
//            "WHERE id=0",nativeQuery = true)
//    List<HTTPRequestHandler>saveAllInfo(HTTPRequestHandler httpRequestHandler);
//
//    List saveAll();
}
