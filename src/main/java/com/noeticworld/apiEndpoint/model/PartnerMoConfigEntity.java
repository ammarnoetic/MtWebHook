package com.noeticworld.apiEndpoint.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "partner_mo_config", schema = "public", catalog = "ucip_db")
public class PartnerMoConfigEntity {
    private int id;
    private String url;
    private Integer okHttImp;
    private Integer partnerId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "ok_htt_imp")
    public Integer getOkHttImp() {
        return okHttImp;
    }

    public void setOkHttImp(Integer okHttImp) {
        this.okHttImp = okHttImp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartnerMoConfigEntity that = (PartnerMoConfigEntity) o;
        return id == that.id &&
                Objects.equals(url, that.url) &&
                Objects.equals(okHttImp, that.okHttImp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, okHttImp);
    }

    @Basic
    @Column(name = "partner_id")
    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }
}
