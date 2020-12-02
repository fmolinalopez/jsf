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
@ManagedBean(name = "vista5")
public class FormEjercicioVista5 {
	
	private static final String INPUT_NOMBRE = "nombre";
	private static final String INPUT_APE1 = "apellido1";
	private static final String INPUT_APE2 = "apellido2";
	private static final String EDAD = "edad";
	private static final String FIRMA = "firma";
	
	private final List<String> componentes = Arrays.asList(INPUT_NOMBRE, INPUT_APE1, INPUT_APE2, EDAD, FIRMA);
	
	private String nombre;
	
	private String ape1;
	
	private String ape2;
	
	private Integer edad;
	
	private String firma;
	
	private List<String> componentesSeleccionados = new ArrayList<>();

	public boolean mostrarNombre() {
		return !this.componentesSeleccionados.isEmpty() && this.componentesSeleccionados.contains(INPUT_NOMBRE);
	}
	
	public boolean mostrarApe1() {
		return !this.componentesSeleccionados.isEmpty() && this.componentesSeleccionados.contains(INPUT_APE1);
	}
	
	public boolean mostrarApe2() {
		return !this.componentesSeleccionados.isEmpty() && this.componentesSeleccionados.contains(INPUT_APE2);
	}
	
	public boolean mostrarEdad() {
		return !this.componentesSeleccionados.isEmpty() && this.componentesSeleccionados.contains(EDAD);
	}
	
	public boolean mostrarFirma() {
		return !this.componentesSeleccionados.isEmpty() && this.componentesSeleccionados.contains(FIRMA);
	}
	
	public void limpiarPanel() {
		this.componentesSeleccionados = new ArrayList<>();
	}
	
	public void validar() {
		
		List<String> camposConError = new ArrayList<>();
		
		if (this.componentesSeleccionados.isEmpty()) {
			this.mostrarError("No se ha seleccionado ningun componente");
			return;
		}
		
		if (this.mostrarNombre() && this.isBlank(this.nombre)) {
			camposConError.add(INPUT_NOMBRE);
		}
		
		if (this.mostrarApe1() && this.isBlank(this.ape1)) {
			camposConError.add(INPUT_APE1);
		}
		
		if (this.mostrarApe2() && this.isBlank(this.nombre)) {
			camposConError.add(INPUT_APE2);
		}
		
		if (this.mostrarEdad() && Objects.nonNull(this.edad) && this.edad < 1) {
			camposConError.add(EDAD);
		}
		
		if (camposConError.isEmpty()) {
			this.mostrarInfo("Formulario correcto");
		} else {
			StringBuilder sb = new StringBuilder();
			camposConError.forEach(c -> sb.append(c + ", "));
			this.mostrarError("Faltan los siguientes campos por rellenar: " + sb.toString());
		}
	}
	
	public List<String> getComponentesSeleccionados() {
		return componentesSeleccionados;
	}

	public void setComponentesSeleccionados(List<String> componentesSeleccionados) {
		this.componentesSeleccionados = componentesSeleccionados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public List<String> getComponentes() {
		return componentes;
	}
	
	protected Boolean isBlank(String string) {
		return Objects.isNull(string) || string.isEmpty();
	}
	
	private void mostrarError(String error) {
		FacesContext.getCurrentInstance()
		 .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", error));
	}
	
	private void mostrarInfo(String info) {
		FacesContext.getCurrentInstance()
		.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", info));
	}
}