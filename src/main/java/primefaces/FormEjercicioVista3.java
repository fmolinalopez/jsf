package primefaces;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ViewScoped
@ManagedBean(name = "vista3")
public class FormEjercicioVista3 {

	private static final String DATATABLE = "datatable";
	
	private static final String KNOB = "knob";
	
	private static final String RADIO = "radio";
	
	private static final String DATEPICKER = "datepicker";
	
	private final List<String> componentes = Arrays.asList(DATATABLE, KNOB, RADIO, DATEPICKER);
	
	private final List<String> datosTabla = Arrays.asList("DATO 1", "DATO 2", "DATO 3");
	
	private String componenteSeleccionado;

	private Integer knobValue;
	
	private Date date;
	
	private String radio;
	
	public boolean mostrarTabla() {
		return !this.isBlank(this.componenteSeleccionado) && componenteSeleccionado.equals(DATATABLE);
	}
	
	public boolean mostrarKnob() {
		return !this.isBlank(this.componenteSeleccionado) && componenteSeleccionado.equals(KNOB);
	}
	
	public boolean mostrarRadio() {
		return !this.isBlank(this.componenteSeleccionado) && componenteSeleccionado.equals(RADIO);
	}
	
	public boolean mostrarDate() {
		return !this.isBlank(this.componenteSeleccionado) && componenteSeleccionado.equals(DATEPICKER);
	}
	
	public void validar() {
		
		if (this.isBlank(this.componenteSeleccionado)) {
			this.mostrarError("No se ha seleccionado ningun componente");
			return;
		}
		
		if (this.mostrarTabla()) {
			this.mostrarInfo("No hay nada que validar en el componente datatable");
		}
		
		if (this.mostrarKnob()) {
			if (Objects.nonNull(this.knobValue) && this.knobValue != 0 ) {
				this.mostrarInfo("Se ha seleccionado un valor para knob correctamente");
			} else {
				this.mostrarError("Componente knob no relleno");
			}
		}
		
		if (this.mostrarRadio()) {
			this.mostrarInfo("Validando radio");
		}
		
		if (this.mostrarDate()) {
			this.mostrarInfo("Validando date");
		}
	}
	
	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getKnob() {
		return knobValue;
	}

	public void setKnob(Integer knob) {
		this.knobValue = knob;
	}

	public String getComponenteSeleccionado() {
		return componenteSeleccionado;
	}

	public void setComponenteSeleccionado(String componenteSeleccionado) {
		this.componenteSeleccionado = componenteSeleccionado;
	}

	public List<String> getComponentes() {
		return componentes;
	}
	
	public List<String> getDatosTabla() {
		return datosTabla;
	}
	
	private void mostrarError(String error) {
		FacesContext.getCurrentInstance()
		 .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", error));
	}
	
	private void mostrarInfo(String info) {
		FacesContext.getCurrentInstance()
		.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", info));
	}
	
	protected Boolean isBlank(String string) {
		return Objects.isNull(string) || string.isEmpty();
	}
}
