package primefaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "vista4")
public class FormEjercicioVista4 {
	
	private static final String DATATABLE = "datatable";
	
	private static final String KNOB = "knob";
	
	private static final String RADIO = "radio";
	
	private static final String DATEPICKER = "datepicker";
	
	private final List<String> componentes = Arrays.asList(DATATABLE, KNOB, RADIO, DATEPICKER);
	
	private List<String> componentesSeleccionados = new ArrayList<>();
	
	private final List<String> datosTabla = Arrays.asList("DATO 1", "DATO 2", "DATO 3");
	
	private Integer knobValue;
	
	private Date date;
	
	private String radioValue;
	
	public boolean mostrarTabla() {
		return !this.componentesSeleccionados.isEmpty() && componentesSeleccionados.contains(DATATABLE);
	}
	
	public boolean mostrarKnob() {
		return !this.componentesSeleccionados.isEmpty() && componentesSeleccionados.contains(KNOB);
	}
	
	public boolean mostrarRadio() {
		return !this.componentesSeleccionados.isEmpty() && componentesSeleccionados.contains(RADIO);
	}
	
	public boolean mostrarDate() {
		return !this.componentesSeleccionados.isEmpty() && componentesSeleccionados.contains(DATEPICKER);
	}
	
	public void limpiarPanel() {
		this.componentesSeleccionados = new ArrayList<>();
	}
	
	public String getRadio() {
		return radioValue;
	}

	public void setRadio(String radio) {
		this.radioValue = radio;
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

	public List<String> getDatosTabla() {
		return datosTabla;
	}
	

	public List<String> getComponentesSeleccionados() {
		return componentesSeleccionados;
	}

	public void setComponentesSeleccionados(List<String> componentesSeleccionados) {
		this.componentesSeleccionados = componentesSeleccionados;
	}

	public List<String> getComponentes() {
		return componentes;
	}
}