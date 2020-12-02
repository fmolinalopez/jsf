package primefaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean(name = "vista")
public class FormEjercicioVista {

	private String nombre;
	
	private String apellido1;
	
	private String apellido2;
	
	private String edad;
	
	private String firma;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	public String getFirma() {
		return firma;
	}
	
	public void setFirma(String firma) {
		this.firma = firma;
	}
	
	public void validarForm() {
		List<String> camposObligatoriosNoEnviados = new ArrayList<>();
		
		if (this.isBlank(this.nombre)) {
			camposObligatoriosNoEnviados.add("Nombre");
		} 
		
		if (this.isBlank(this.apellido1)) {
			camposObligatoriosNoEnviados.add("Primer Apellido");
		}
		
		if (this.isBlank(this.apellido2)) {
			camposObligatoriosNoEnviados.add("Segundo Apellido");
		} 
		
		if (this.isBlank(this.edad) || this.edad.equals("0")) {
			camposObligatoriosNoEnviados.add("Edad");
		}
		
		if (this.isBlank(this.firma)) {
			camposObligatoriosNoEnviados.add("Firma");
		}
		
		if (camposObligatoriosNoEnviados.isEmpty()) {
			this.mostrarInfo("Datos correctos");
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("Faltan los siguientes datos obligatorios: ");
			camposObligatoriosNoEnviados.forEach(co -> sb.append(co + ", "));
			this.mostrarError(sb.toString());
		}
	}
	
	public void resetearFirma() {
		this.firma = "";
	}
	
	protected boolean isBlank(String texto) {
		return Objects.isNull(texto) || texto == "";
	}
	
	protected void mostrarError(String error) {
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", error));
	}
	
	protected void mostrarWarn(String warn) {
		FacesContext.getCurrentInstance()
		.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", warn));
	}
	
	protected void mostrarInfo(String info) {
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", info));
	}
	
	public void noValidar() {
		this.mostrarWarn("No se ha validado el formulario");
	}
}
