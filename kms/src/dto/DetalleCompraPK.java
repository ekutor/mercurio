/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author alsarmiento
 */
@Embeddable
public class DetalleCompraPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "NUM_ORD")
    private String numOrd;
    @Basic(optional = false)
    @Column(name = "PRODUCTO")
    private String producto;

    public DetalleCompraPK() {
    }

    public DetalleCompraPK(String numOrd, String producto) {
        this.numOrd = numOrd;
        this.producto = producto;
    }

    public String getNumOrd() {
        return numOrd;
    }

    public void setNumOrd(String numOrd) {
        this.numOrd = numOrd;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numOrd != null ? numOrd.hashCode() : 0);
        hash += (producto != null ? producto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCompraPK)) {
            return false;
        }
        DetalleCompraPK other = (DetalleCompraPK) object;
        if ((this.numOrd == null && other.numOrd != null) || (this.numOrd != null && !this.numOrd.equals(other.numOrd))) {
            return false;
        }
        if ((this.producto == null && other.producto != null) || (this.producto != null && !this.producto.equals(other.producto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.DetalleCompraPK[ numOrd=" + numOrd + ", producto=" + producto + " ]";
    }
    
}
