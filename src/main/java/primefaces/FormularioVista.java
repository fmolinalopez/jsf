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
@ManagedBean(name = "formularioVista")
public class FormularioVista {

	private String inputText;
	
	private String lazySelection;
	
	private List<String> options;
	
	private final List<String> lazyLista = Arrays.asList("Opcion 1", "Opcion 2", "Opcion 3");

	public void validarForm() {
		if (this.isBlank(this.getInputText()) || this.isBlank(this.lazySelection)) {
			this.showError("Faltan datos obligatorios");
		} else {
			this.showInfo("Formulario validado con exito!!");
		}
	}
	
	public void addOption() {
		if (!this.isBlank(this.lazySelection)) {
			if (Objects.isNull(options)) {
				this.options = new ArrayList<>();
			}
			this.options.add(this.lazySelection);
			this.showInfo("Opcion añadida");
		} else {
			this.showError("No se ha seleccionado opcion");
		}
	}
	
	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}
	
	public String getLazySelection() {
		return this.lazySelection;
	}
	
	public void setLazySelection(String value) {
		this.lazySelection = value;
	}
	
	public List<String> getLazyLista() {
		return this.lazyLista;
	}
	
	public List<String> getOptions() {
		return this.options;
	}
	
	protected Boolean isBlank(String string) {
		return Objects.isNull(string) || string.isEmpty();
	}
	
	private void showError(String error) {
		FacesContext.getCurrentInstance()
		 .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", error));
	}
	
	private void showInfo(String info) {
		FacesContext.getCurrentInstance()
		.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", info));
	}
}
