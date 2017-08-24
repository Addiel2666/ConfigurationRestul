package com.tesis.conf.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TMI_CONFIGURACION_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfiguracionProducto.findAll", query = "SELECT c FROM ConfiguracionProducto c")
    , @NamedQuery(name = "ConfiguracionProducto.findById", query = "SELECT c FROM ConfiguracionProducto c WHERE c.id = :id")
    , @NamedQuery(name = "ConfiguracionProducto.findByNombreCarga", query = "SELECT c FROM ConfiguracionProducto c WHERE c.nombreCarga = :nombreCarga")
    , @NamedQuery(name = "ConfiguracionProducto.findByIdProceso", query = "SELECT c FROM ConfiguracionProducto c WHERE c.idProceso = :idProceso")
    , @NamedQuery(name = "ConfiguracionProducto.findBySeparador", query = "SELECT c FROM ConfiguracionProducto c WHERE c.separador = :separador")
    , @NamedQuery(name = "ConfiguracionProducto.findByNombreNegocio", query = "SELECT c FROM ConfiguracionProducto c WHERE c.nombreNegocio = :nombreNegocio")
    , @NamedQuery(name = "ConfiguracionProducto.findByFechaAlta", query = "SELECT c FROM ConfiguracionProducto c WHERE c.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "ConfiguracionProducto.findByFechaActualizacion", query = "SELECT c FROM ConfiguracionProducto c WHERE c.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "ConfiguracionProducto.findByFechaEliminacion", query = "SELECT c FROM ConfiguracionProducto c WHERE c.fechaEliminacion = :fechaEliminacion")
    , @NamedQuery(name = "ConfiguracionProducto.findBySerie", query = "SELECT c FROM ConfiguracionProducto c WHERE c.serie = :serie")})
public class ConfiguracionProducto implements Serializable {

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 521529262252204836L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQUENCETMICONFPROD")
    @SequenceGenerator(name="SEQUENCETMICONFPROD", sequenceName = "SEQUENCE_TMI_CONF_PROD", allocationSize=1)
    private Long id;
	 @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 20)
	    @Column(name = "NOMBRE_CARGA")
	    private String nombreCarga;
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "ID_PROCESO")
	    private short idProceso;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 1)
	    @Column(name = "SEPARADOR")
	    private String separador;
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 50)
	    @Column(name = "NOMBRE_NEGOCIO")
	    private String nombreNegocio;
	    @Column(name = "FECHA_ALTA")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date fechaAlta;
	    @Column(name = "FECHA_ACTUALIZACION")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date fechaActualizacion;
	    @Column(name = "FECHA_ELIMINACION")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date fechaEliminacion;
	    @Size(max = 20)
	    @Column(name = "SERIE")
	    private String serie;
	    @JoinColumn(name = "ID_SOCIO", referencedColumnName = "ID")
	    @ManyToOne
	    private AltaSocio idSocio;
	    @JoinColumn(name = "ID_ENTRADA", referencedColumnName = "ID")
	    @ManyToOne
	    private TipoEntrada idEntrada;
	    @JoinColumn(name = "ACTIVO", referencedColumnName = "ID")
	    @ManyToOne
	    private TipoEstatus activo;

	    public ConfiguracionProducto() {
	    }

	    public ConfiguracionProducto(Long id) {
	        this.id = id;
	    }

	    public ConfiguracionProducto(Long id, String nombreCarga, short idProceso, String separador, String nombreNegocio) {
	        this.id = id;
	        this.nombreCarga = nombreCarga;
	        this.idProceso = idProceso;
	        this.separador = separador;
	        this.nombreNegocio = nombreNegocio;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNombreCarga() {
	        return nombreCarga;
	    }

	    public void setNombreCarga(String nombreCarga) {
	        this.nombreCarga = nombreCarga;
	    }

	    public short getIdProceso() {
	        return idProceso;
	    }

	    public void setIdProceso(short idProceso) {
	        this.idProceso = idProceso;
	    }

	    public String getSeparador() {
	        return separador;
	    }

	    public void setSeparador(String separador) {
	        this.separador = separador;
	    }

	    public String getNombreNegocio() {
	        return nombreNegocio;
	    }

	    public void setNombreNegocio(String nombreNegocio) {
	        this.nombreNegocio = nombreNegocio;
	    }

	    public Date getFechaAlta() {
	        return fechaAlta;
	    }

	    public void setFechaAlta(Date fechaAlta) {
	        this.fechaAlta = fechaAlta;
	    }

	    public Date getFechaActualizacion() {
	        return fechaActualizacion;
	    }

	    public void setFechaActualizacion(Date fechaActualizacion) {
	        this.fechaActualizacion = fechaActualizacion;
	    }

	    public Date getFechaEliminacion() {
	        return fechaEliminacion;
	    }

	    public void setFechaEliminacion(Date fechaEliminacion) {
	        this.fechaEliminacion = fechaEliminacion;
	    }

	    public String getSerie() {
	        return serie;
	    }

	    public void setSerie(String serie) {
	        this.serie = serie;
	    }

	    public AltaSocio getIdSocio() {
	        return idSocio;
	    }

	    public void setIdSocio(AltaSocio idSocio) {
	        this.idSocio = idSocio;
	    }

	    public TipoEntrada getIdEntrada() {
	        return idEntrada;
	    }

	    public void setIdEntrada(TipoEntrada idEntrada) {
	        this.idEntrada = idEntrada;
	    }

	    public TipoEstatus getActivo() {
	        return activo;
	    }

	    public void setActivo(TipoEstatus activo) {
	        this.activo = activo;
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
	        if (!(object instanceof ConfiguracionProducto)) {
	            return false;
	        }
	        ConfiguracionProducto other = (ConfiguracionProducto) object;
	        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "com.mycompany.mavenproject2.ConfiguracionProducto[ id=" + id + " ]";
	    }
	    
	}
