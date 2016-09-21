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
@Table(name = "transportador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportador.findAll", query = "SELECT t FROM Transportador t"),
    @NamedQuery(name = "Transportador.findByIdTransportador", query = "SELECT t FROM Transportador t WHERE t.idTransportador = :idTransportador"),
    @NamedQuery(name = "Transportador.findByMotorista", query = "SELECT t FROM Transportador t WHERE t.motorista = :motorista"),
    @NamedQuery(name = "Transportador.findByAjudante", query = "SELECT t FROM Transportador t WHERE t.ajudante = :ajudante"),
    @NamedQuery(name = "Transportador.findByDtSaida", query = "SELECT t FROM Transportador t WHERE t.dtSaida = :dtSaida"),
    @NamedQuery(name = "Transportador.findByDtChegada", query = "SELECT t FROM Transportador t WHERE t.dtChegada = :dtChegada"),
    @NamedQuery(name = "Transportador.findByVeiculo", query = "SELECT t FROM Transportador t WHERE t.veiculo = :veiculo"),
    @NamedQuery(name = "Transportador.findByDescricao", query = "SELECT t FROM Transportador t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "Transportador.findByNomeTransp", query = "SELECT t FROM Transportador t WHERE t.nomeTransp = :nomeTransp")})
public class Transportador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transportador")
    private Integer idTransportador;
    @Size(max = 255)
    @Column(name = "motorista")
    private String motorista;
    @Size(max = 255)
    @Column(name = "ajudante")
    private String ajudante;
    @Column(name = "dt_saida")
    private Date dtSaida;
    @Column(name = "dt_chegada")
    private Date dtChegada;
    @Size(max = 7)
    @Column(name = "veiculo")
    private String veiculo;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 255)
    @Column(name = "nome_transp")
    private String nomeTransp;
   
    public Transportador() {
    }

    public Transportador(Integer idTransportador) {
        this.idTransportador = idTransportador;
    }

    public Integer getIdTransportador() {
        return idTransportador;
    }

    public void setIdTransportador(Integer idTransportador) {
        this.idTransportador = idTransportador;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public String getAjudante() {
        return ajudante;
    }

    public void setAjudante(String ajudante) {
        this.ajudante = ajudante;
    }

    public Date getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(Date dtSaida) {
        this.dtSaida = dtSaida;
    }

    public Date getDtChegada() {
        return dtChegada;
    }

    public void setDtChegada(Date dtChegada) {
        this.dtChegada = dtChegada;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeTransp() {
        return nomeTransp;
    }

    public void setNomeTransp(String nomeTransp) {
        this.nomeTransp = nomeTransp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransportador != null ? idTransportador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transportador)) {
            return false;
        }
        Transportador other = (Transportador) object;
        if ((this.idTransportador == null && other.idTransportador != null) || (this.idTransportador != null && !this.idTransportador.equals(other.idTransportador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.g_logistica.modelo.Transportador[ idTransportador=" + idTransportador + " ]";
    }
    
}
