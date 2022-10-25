package com.noeticworld.apiEndpoint.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "partner_service_config", schema = "public", catalog = "ucip_db")
public class PartnerServiceConfigEntity {
    private String shortcode;
    private Integer operatorid;
    private String serviceid;
    private String mt_serviceid;
    private Integer partnerid;
    private String username;
    private String password;
    private BigInteger id;

    @Id
    @Column(name = "id")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Basic
    @Column(name = "shortcode")
    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }
    @Basic
    @Column(name = "operatorid")
    public Integer getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Integer operatorid) {
        this.operatorid = operatorid;
    }
    @Basic
    @Column(name = "serviceid")
    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }
    @Basic
    @Column(name = "mt_serviceid")
    public String getMt_serviceid() {
        return mt_serviceid;
    }

    public void setMt_serviceid(String mt_serviceid) {
        this.mt_serviceid = mt_serviceid;
    }
    @Basic
    @Column(name = "partnerid")
    public Integer getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(Integer partnerid) {
        this.partnerid = partnerid;
    }
    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Basic
    @Column(name = "password_")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PartnerServiceConfigEntity{" +
                "shortcode='" + shortcode + '\'' +
                ", operatorid=" + operatorid +
                ", serviceid='" + serviceid + '\'' +
                ", mt_serviceid='" + mt_serviceid + '\'' +
                ", partnerid=" + partnerid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
