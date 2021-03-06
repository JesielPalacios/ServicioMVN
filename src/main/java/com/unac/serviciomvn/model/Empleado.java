package com.unac.serviciomvn.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unac.serviciomvn.security.model.Usuario;

import lombok.Data;


@Entity
@Data
@Table(name = "Empleado")
public class Empleado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private int idEmpleado;
 
    public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Basic(optional = false)
    @NotNull
    @Column(name = "nombre")    
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "apellidos")       
    private String apellidos;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")       
    private String telefono;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "email")       
    private String email;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")       
    private String cedula;
    
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @OneToOne(optional = false)
    private Usuario idUsuario;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioCreacion")
    @JsonIgnore
    private Collection<Propietario> propietarioCreateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioActualizacion")
    @JsonIgnore
    private Collection<Propietario> propietarioUpdateCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioCreacion")
    @JsonIgnore
    private Collection<Vehiculo> vehiculoCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleadoFactura")
    @JsonIgnore
    private Collection<VehiculoReparacion> VehiculoReparacionCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleadoDetalle")
    @JsonIgnore
    private Collection<DetallesReparacion> EmpleadoDetallesReparacionCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleadoServicio")
    @JsonIgnore
    private Collection<ServicioReparacion> ServicioReparacionCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleadoReporte")
    @JsonIgnore
    private Collection<Reportes> ServicioReporteCollection;
    
    public Empleado(@NotNull String nombre, @NotNull String apellidos, @NotNull String telefono, @NotNull String cedula,
    		@NotNull Usuario idUsuario,@NotNull String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.email = email;
		this.telefono = telefono;
		this.idUsuario = idUsuario;
	}
    public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Empleado() {
	}
	public String getNombre() {
		return nombre;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	
}
