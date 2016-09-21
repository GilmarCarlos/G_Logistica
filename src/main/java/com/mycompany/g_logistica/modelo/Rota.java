/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.g_logistica.modelo;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hexp_
 */
@Entity
@Table(name = "rota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rota.findAll", query = "SELECT r FROM Rota r"),
    @NamedQuery(name = "Rota.findByIdRota", query = "SELECT r FROM Rota r WHERE r.idRota = :idRota"),
    @NamedQuery(name = "Rota.findByDanfe", query = "SELECT r FROM Rota r WHERE r.danfe = :danfe"),
    @NamedQuery(name = "Rota.findByPedido", query = "SELECT r FROM Rota r WHERE r.pedido = :pedido"),
    @NamedQuery(name = "Rota.findByCliente", query = "SELECT r FROM Rota r WHERE r.cliente = :cliente"),
    @NamedQuery(name = "Rota.findByDtEmi", query = "SELECT r FROM Rota r WHERE r.dtEmi = :dtEmi"),
    @NamedQuery(name = "Rota.findByConferente", query = "SELECT r FROM Rota r WHERE r.conferente = :conferente"),
    @NamedQuery(name = "Rota.findByValor", query = "SELECT r FROM Rota r WHERE r.valor = :valor"),
    @NamedQuery(name = "Rota.findByCidadeUf", query = "SELECT r FROM Rota r WHERE r.cidadeUf = :cidadeUf"),
    @NamedQuery(name = "Rota.findByQtdVol", query = "SELECT r FROM Rota r WHERE r.qtdVol = :qtdVol")})
public class Rota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rota")
    private Integer idRota;
    @Column(name = "danfe")
    private Integer danfe;
    @Column(name = "pedido")
    private Integer pedido;
    @Size(max = 255)
    @Column(name = "cliente")
    private String cliente;
    @Column(name = "dt_emi")
    private Date dtEmi;
    @Size(max = 255)
    @Column(name = "conferente")
    private String conferente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @Size(max = 255)
    @Column(name = "cidade_uf")
    private String cidadeUf;
    @Column(name = "qtd_vol")
    private Integer qtdVol;
    @Column(name = "id_transportador")
    private Integer idTransportador;

    public Rota() {
    }

    public Rota(Integer idRota) {
        this.idRota = idRota;
    }

    public Integer getIdRota() {
        return idRota;
    }

    public void setIdRota(Integer idRota) {
        this.idRota = idRota;
    }

    public Integer getDanfe() {
        return danfe;
    }

    public void setDanfe(Integer danfe) {
        this.danfe = danfe;
    }

    public Integer getPedido() {
        return pedido;
    }

    public void setPedido(Integer pedido) {
        this.pedido = pedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getDtEmi() {
        return dtEmi;
    }

    public void setDtEmi(Date dtEmi) {
        this.dtEmi = dtEmi;
    }

    public String getConferente() {
        return conferente;
    }

    public void setConferente(String conferente) {
        this.conferente = conferente;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getCidadeUf() {
        return cidadeUf;
    }

    public void setCidadeUf(String cidadeUf) {
        this.cidadeUf = cidadeUf;
    }

    public Integer getQtdVol() {
        return qtdVol;
    }

    public void setQtdVol(Integer qtdVol) {
        this.qtdVol = qtdVol;
    }

    public Integer getIdTransportador() {
        return idTransportador;
    }

    public void setIdTransportador(Integer idTransportador) {
        this.idTransportador = idTransportador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRota != null ? idRota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rota)) {
            return false;
        }
        Rota other = (Rota) object;
        if ((this.idRota == null && other.idRota != null) || (this.idRota != null && !this.idRota.equals(other.idRota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.g_logistica.modelo.Rota[ idRota=" + idRota + " ]";
    }
    
}
