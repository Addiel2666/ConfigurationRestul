package com.tesis.conf.dto;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "C##TESIS.TMI_ALTA_SOCIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AltaSocio.findAll", query = "SELECT a FROM AltaSocio a WHERE a.estatus<>0")
    , @NamedQuery(name = "AltaSocio.findRegistro", query = "SELECT a.id FROM AltaSocio a WHERE a.claveSocio=:claveSocio")
    , @NamedQuery(name = "AltaSocio.findById", query = "SELECT a FROM AltaSocio a WHERE a.id = :id")
    , @NamedQuery(name = "AltaSocio.findByNombreSocio", query = "SELECT a FROM AltaSocio a WHERE a.nombreSocio = :nombreSocio")
    , @NamedQuery(name = "AltaSocio.findByDescripcionSocio", query = "SELECT a FROM AltaSocio a WHERE a.descripcionSocio = :descripcionSocio")
    , @NamedQuery(name = "AltaSocio.findByFechaCreacion", query = "SELECT a FROM AltaSocio a WHERE a.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "AltaSocio.findByFechaVigenciaInicio", query = "SELECT a FROM AltaSocio a WHERE a.fechaVigenciaInicio = :fechaVigenciaInicio")
    , @NamedQuery(name = "AltaSocio.findByFechaVigenciaFinal", query = "SELECT a FROM AltaSocio a WHERE a.fechaVigenciaFinal = :fechaVigenciaFinal")
    , @NamedQuery(name = "AltaSocio.findByClaveSocio", query = "SELECT a FROM AltaSocio a WHERE a.claveSocio = :claveSocio")})
public class AltaSocio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2725016724235672499L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQUENCETMIALTASOCIO")
    @SequenceGenerator(name="SEQUENCETMIALTASOCIO", sequenceName = "SEQUENCE_TMI_ALTA_SOCIO", allocationSize=1)
    @Column(name = "ID")
    private Long id;
    @Size(max = 100)
    @Column(name = "NOMBRE_SOCIO")
    private String nombreSocio;
    @Size(max = 150)
    @Column(name = "DESCRIPCION_SOCIO")
    private String descripcionSocio;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "FECHA_VIGENCIA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVigenciaInicio;
    @Column(name = "FECHA_VIGENCIA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVigenciaFinal;
    @Size(max = 20)
    @Column(name = "CLAVE_SOCIO")
    private String claveSocio;
    @JoinColumn(name = "ESTATUS", referencedColumnName = "ID")
    @ManyToOne
    private TipoEstatus estatus;

    @OneToMany(mappedBy = "idSocio", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ConfiguracionProducto> configuracionProductoCollection;
    
    public AltaSocio() {
    }

    public AltaSocio(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public String getDescripcionSocio() {
        return descripcionSocio;
    }

    public void setDescripcionSocio(String descripcionSocio) {
        this.descripcionSocio = descripcionSocio;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaVigenciaInicio() {
        return fechaVigenciaInicio;
    }

    public void setFechaVigenciaInicio(Date fechaVigenciaInicio) {
        this.fechaVigenciaInicio = fechaVigenciaInicio;
    }

    public Date getFechaVigenciaFinal() {
        return fechaVigenciaFinal;
    }

    public void setFechaVigenciaFinal(Date fechaVigenciaFinal) {
        this.fechaVigenciaFinal = fechaVigenciaFinal;
    }

    public String getClaveSocio() {
        return claveSocio;
    }

    public void setClaveSocio(String claveSocio) {
        this.claveSocio = claveSocio;
    }

    public TipoEstatus getEstatus() {
        return estatus;
    }

    public void setEstatus(TipoEstatus estatus) {
        this.estatus = estatus;
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
        if (!(object instanceof AltaSocio)) {
            return false;
        }
        AltaSocio other = (AltaSocio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.AltaSocio[ id=" + id + " ]";
    }
}
