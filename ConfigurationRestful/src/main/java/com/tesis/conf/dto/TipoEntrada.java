package com.tesis.conf.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author zony_
 */
@Entity
@Table(name = "C##TESIS.TMI_TIPO_ENTRADA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEntrada.findAll", query = "SELECT t FROM TipoEntrada t WHERE t.activo <> 0")
    , @NamedQuery(name = "TipoEntrada.findById", query = "SELECT t FROM TipoEntrada t WHERE t.id = :id")
    , @NamedQuery(name = "TipoEntrada.findByCodigo", query = "SELECT t FROM TipoEntrada t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TipoEntrada.findByExtension", query = "SELECT t FROM TipoEntrada t WHERE t.extension = :extension")
    , @NamedQuery(name = "TipoEntrada.findByDescripcion", query = "SELECT t FROM TipoEntrada t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoEntrada.findByActivo", query = "SELECT t FROM TipoEntrada t WHERE t.activo = :activo")})
public class TipoEntrada implements Serializable {

   
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 4881379114619305058L;
		@Id
	    @Basic(optional = false)
	    @NotNull
	    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "TIPASEQ")
	    @SequenceGenerator(name="TIPASEQ", sequenceName = "TIPA_SEQ", allocationSize=1)
	    @Column(name = "ID")
	    private Long id;
	    @Size(max = 50)
	    @Column(name = "CODIGO")
	    private String codigo;
	    @Size(max = 50)
	    @Column(name = "EXTENSION")
	    private String extension;
	    @Size(max = 50)
	    @Column(name = "DESCRIPCION")
	    private String descripcion;
	    @JoinColumn(name = "ACTIVO", referencedColumnName = "ID")
	    @ManyToOne(optional = false)
	    @JsonIgnore
	    private TipoEstatus activo;
	    
	    @OneToMany(mappedBy = "idEntrada", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    private Set<ConfiguracionProducto> configuracionProductoCollection;

	    public TipoEntrada() {
	    }

	    public TipoEntrada(Long id) {
	        this.id = id;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(String codigo) {
	        this.codigo = codigo;
	    }

	    public String getExtension() {
	        return extension;
	    }

	    public void setExtension(String extension) {
	        this.extension = extension;
	    }

	    public String getDescripcion() {
	        return descripcion;
	    }

	    public void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }

	    public TipoEstatus getActivo() {
	        return activo;
	    }

	    public void setActivo(TipoEstatus activo) {
	        this.activo = activo;
	    }

	    
	    
	    public Set<ConfiguracionProducto> getConfiguracionProductoCollection() {
			return configuracionProductoCollection;
		}

		public void setConfiguracionProductoCollection(Set<ConfiguracionProducto> configuracionProductoCollection) {
			this.configuracionProductoCollection = configuracionProductoCollection;
		}

		@Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (id != null ? id.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof TipoEntrada)) {
	            return false;
	        }
	        TipoEntrada other = (TipoEntrada) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "com.mycompany.mavenproject2.TipoEntrada[ id=" + id + " ]";
	    }
    }
    

