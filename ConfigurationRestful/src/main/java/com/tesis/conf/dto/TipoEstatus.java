package com.tesis.conf.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "C##TESIS.TMI_TIPO_ESTATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstatus.findAllActivo", query = "SELECT t FROM TipoEstatus t WHERE t.id = 1")
    , @NamedQuery(name = "TipoEstatus.findById", query = "SELECT t FROM TipoEstatus t WHERE t.id = :id")
    , @NamedQuery(name = "TipoEstatus.findByDescripcion", query = "SELECT t FROM TipoEstatus t WHERE t.descripcion = :descripcion")})
public class TipoEstatus implements Serializable {

 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1689695086584351476L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DESCRIPCION")
    private String descripcion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activo")
    @OneToMany(mappedBy = "activo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<TipoEntrada> tipoEntradaCollection;

    @OneToMany(mappedBy = "estatus", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<AltaSocio> altaSocioCollection;
    @OneToMany(mappedBy = "activo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ConfiguracionProducto> configuracionProductoCollection;
    
    public TipoEstatus() {
    }

    public TipoEstatus(Long id) {
        this.id = id;
    }

    public TipoEstatus(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

    public Set<TipoEntrada> getTipoEntradaCollection() {
		return tipoEntradaCollection;
	}

	public void setTipoEntradaCollection(Set<TipoEntrada> tipoEntradaCollection) {
		this.tipoEntradaCollection = tipoEntradaCollection;
	}

	
	
	public Set<AltaSocio> getAltaSocioCollection() {
		return altaSocioCollection;
	}

	public void setAltaSocioCollection(Set<AltaSocio> altaSocioCollection) {
		this.altaSocioCollection = altaSocioCollection;
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
        if (!(object instanceof TipoEstatus)) {
            return false;
        }
        TipoEstatus other = (TipoEstatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.TipoEstatus[ id=" + id + " ]";
    }
}
