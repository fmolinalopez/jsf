package primefaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean(name = "formularioFPDualVista")
public class FormularioFPDualVista {

	private String campoTexto;
	
	private String campoTextoAjax;
	
	private String campoSelectOne;
	
	private String campoRadio;
	
	private final List<String> datos = Arrays.asList("Dato 1", "Dato 2", "Dato 3");
	
	private final List<String> consolas = Arrays.asList("PS4", "XBOX ONE", "WII");
	
	private List<String> datosTablaOpciones;

	public void validarFormulario() {
		if (this.isBlank(this.campoTexto) 
				|| this.isBlank(this.campoSelectOne)) {
			this.mostrarError("Falta algun campo obligatorio");
		} else {
			this.mostrarInfo("Formulario validado correctamente");
		}
	}
	
	public void anadirOpcionATabla() {
		if (!this.isBlank(this.campoSelectOne)) {
			if (Objects.isNull(datosTablaOpciones)) {
				this.datosTablaOpciones = new ArrayList<>();
			}
			
			if (!estaCampoEnListaOpciones()) {
				this.datosTablaOpciones.add(this.campoSelectOne);
				this.mostrarInfo("Opcion anadida");
			} else {
				this.mostrarError("La opcion ya esta en la lista");
			}
		} else {
			this.mostrarError("Debe seleccionar una opcion");
		}
	}
	
	protected boolean estaCampoEnListaOpciones() {
		return Objects.nonNull(this.datosTablaOpciones) ? this.datosTablaOpciones.contains(this.campoSelectOne) : false;
	}
	
	public String getCampoRadio() {
		return campoRadio;
	}

	public void setCampoRadio(String campoRadio) {
		this.campoRadio = campoRadio;
	}

	public List<String> getConsolas() {
		return this.consolas;
	}
	
	public List<String> getDatos() {
		return datos;
	}
	
	public List<String> getDatosTablaOpciones() {
		return datosTablaOpciones;
	}

	public String getCampoTexto() {
		return campoTexto;
	}

	public void setCampoTexto(String campoTexto) {
		this.campoTexto = campoTexto;
	}
	
	public String getCampoTextoAjax() {
		return campoTextoAjax;
	}

	public void setCampoTextoAjax(String campoTextoAjax) {
		this.campoTextoAjax = campoTextoAjax;
	}
	
	public String getCampoSelectOne() {
		return campoSelectOne;
	}

	public void setCampoSelectOne(String campoSelectOne) {
		this.campoSelectOne = campoSelectOne;
	}
	
	protected boolean isBlank(String texto) {
		return Objects.isNull(texto) || texto == "";
	}
	
	protected void mostrarError(String error) {
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", error));
	}
	
	protected void mostrarInfo(String info) {
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", info));
	}
}
