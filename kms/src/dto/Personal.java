/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alsarmiento
 */
@Entity
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p"),
    @NamedQuery(name = "Personal.findById", query = "SELECT p FROM Personal p WHERE p.id = :id"),
    @NamedQuery(name = "Personal.findByNombre", query = "SELECT p FROM Personal p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Personal.findByApellido", query = "SELECT p FROM Personal p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Personal.findByGenero", query = "SELECT p FROM Personal p WHERE p.genero = :genero"),
    @NamedQuery(name = "Personal.findByFechaNac", query = "SELECT p FROM Personal p WHERE p.fechaNac = :fechaNac"),
    @NamedQuery(name = "Personal.findByLibreta", query = "SELECT p FROM Personal p WHERE p.libreta = :libreta"),
    @NamedQuery(name = "Personal.findByDireccion", query = "SELECT p FROM Personal p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Personal.findByTelefono", query = "SELECT p FROM Personal p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Personal.findByCelular", query = "SELECT p FROM Personal p WHERE p.celular = :celular"),
    @NamedQuery(name = "Personal.findByEmail", query = "SELECT p FROM Personal p WHERE p.email = :email"),
    @NamedQuery(name = "Personal.findByFechaIng", query = "SELECT p FROM Personal p WHERE p.fechaIng = :fechaIng"),
    @NamedQuery(name = "Personal.findByFechaReti", query = "SELECT p FROM Personal p WHERE p.fechaReti = :fechaReti"),
    @NamedQuery(name = "Personal.findByTipoContr", query = "SELECT p FROM Personal p WHERE p.tipoContr = :tipoContr"),
    @NamedQuery(name = "Personal.findByCertificado", query = "SELECT p FROM Personal p WHERE p.certificado = :certificado"),
    @NamedQuery(name = "Personal.findByEstado", query = "SELECT p FROM Personal p WHERE p.estado = :estado"),
    @NamedQuery(name = "Personal.findByObs", query = "SELECT p FROM Personal p WHERE p.obs = :obs"),
    @NamedQuery(name = "Personal.findByTimestamp", query = "SELECT p FROM Personal p WHERE p.timestamp = :timestamp"),
    @NamedQuery(name = "Personal.findByEstadocivil", query = "SELECT p FROM Personal p WHERE p.estadocivil = :estadocivil"),
    @NamedQuery(name = "Personal.findByEstadoreg", query = "SELECT p FROM Personal p WHERE p.estadoreg = :estadoreg")})
public class Personal implements Serializable {
    @Lob
    @Column(name = "FOTO")
    private byte[] foto;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "GENERO")
    private Character genero;
    @Column(name = "FECHA_NAC")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Column(name = "LIBRETA")
    private String libreta;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "CELULAR")
    private String celular;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FECHA_ING")
    @Temporal(TemporalType.DATE)
    private Date fechaIng;
    @Column(name = "FECHA_RETI")
    @Temporal(TemporalType.DATE)
    private Date fechaReti;
    @Column(name = "TIPO_CONTR")
    private String tipoContr;
    @Column(name = "CERTIFICADO")
    private String certificado;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "OBS")
    private String obs;
    @Basic(optional = false)
    @Column(name = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Column(name = "ESTADOCIVIL")
    private String estadocivil;
    @Column(name = "ESTADOREG")
    private Integer estadoreg;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personal")
    private Usuario usuario;
    @OneToMany(mappedBy = "perId")
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajero")
    private List<HistorialCaja> historialCajaList;
    @JoinColumn(name = "CARGO", referencedColumnName = "ID")
    @ManyToOne
    private Cargos cargo;
    @JoinColumn(name = "CIUDAD_NAC", referencedColumnName = "ID")
    @ManyToOne
    private Ciudad ciudadNac;
    @JoinColumn(name = "CIUDAD", referencedColumnName = "ID")
    @ManyToOne
    private Ciudad ciudad;

    public Personal() {
    }

    public Personal(String id) {
        this.id = id;
    }

    public Personal(String id, Date timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getLibreta() {
        return libreta;
    }

    public void setLibreta(String libreta) {
        this.libreta = libreta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public Date getFechaReti() {
        return fechaReti;
    }

    public void setFechaReti(Date fechaReti) {
        this.fechaReti = fechaReti;
    }

    public String getTipoContr() {
        return tipoContr;
    }

    public void setTipoContr(String tipoContr) {
        this.tipoContr = tipoContr;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public Integer getEstadoreg() {
        return estadoreg;
    }

    public void setEstadoreg(Integer estadoreg) {
        this.estadoreg = estadoreg;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<HistorialCaja> getHistorialCajaList() {
        return historialCajaList;
    }

    public void setHistorialCajaList(List<HistorialCaja> historialCajaList) {
        this.historialCajaList = historialCajaList;
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    public Ciudad getCiudadNac() {
        return ciudadNac;
    }

    public void setCiudadNac(Ciudad ciudadNac) {
        this.ciudadNac = ciudadNac;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
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
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Personal[ id=" + id + " ]";
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
}
