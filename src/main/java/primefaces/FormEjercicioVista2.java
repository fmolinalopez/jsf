package primefaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean(name = "vista2")
public class FormEjercicioVista2 {

	private Integer numeroInputs;
	
	private List<Integer> listaInputs = new ArrayList<>();
	
	private String input1;
	private String input2;
	private String input3;
	private String input4;
	private String input5;
	private String input6;
	private String input7;
	private String input8;
	private String input9;
	private String input10;
	
	public void anadirInputs() {
		this.listaInputs = new ArrayList<>();
		for (int i = 1; i <= numeroInputs; i++) {
			this.listaInputs.add(i);
		}
	}
	
	public void submit() {
		if (listaInputs.isEmpty()) {
			this.mostrarError("No se ha anadido ningun input");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		boolean algunError = false;
		
		for (int i = 1; i <= listaInputs.size(); i++) {
			if (!this.validarInputCorrespondiente(i)) {
				algunError = true;
				sb.append(" " + i);
			}
		}
		
		if (algunError) {
			this.mostrarError("Faltan por rellenar los inputs" + sb.toString());
		} else {
			this.mostrarInfo("Todos los inputs estan correctamente rellenados");
		}
	}
	
	protected boolean validarInputCorrespondiente(Integer numeroInput) {
		
		switch (numeroInput) {
		case 1:
			return !this.isBlank(this.input1);
		case 2:
			return !this.isBlank(this.input2);
		case 3:
			return !this.isBlank(this.input3);
		case 4:
			return !this.isBlank(this.input4);
		case 5:
			return !this.isBlank(this.input5);
		case 6:
			return !this.isBlank(this.input6);
		case 7:
			return !this.isBlank(this.input7);
		case 8:
			return !this.isBlank(this.input8);
		case 9:
			return !this.isBlank(this.input9);
		case 10:
			return !this.isBlank(this.input10);

		default:
			return true;
		}
	}
	
	public String getInput1() {
		return input1;
	}

	public void setInput1(String input1) {
		this.input1 = input1;
	}

	public String getInput2() {
		return input2;
	}

	public void setInput2(String input2) {
		this.input2 = input2;
	}

	public String getInput3() {
		return input3;
	}

	public void setInput3(String input3) {
		this.input3 = input3;
	}

	public String getInput4() {
		return input4;
	}

	public void setInput4(String input4) {
		this.input4 = input4;
	}

	public String getInput5() {
		return input5;
	}

	public void setInput5(String input5) {
		this.input5 = input5;
	}

	public String getInput6() {
		return input6;
	}

	public void setInput6(String input6) {
		this.input6 = input6;
	}

	public String getInput7() {
		return input7;
	}

	public void setInput7(String input7) {
		this.input7 = input7;
	}

	public String getInput8() {
		return input8;
	}

	public void setInput8(String input8) {
		this.input8 = input8;
	}

	public String getInput9() {
		return input9;
	}

	public void setInput9(String input9) {
		this.input9 = input9;
	}

	public String getInput10() {
		return input10;
	}

	public void setInput10(String input10) {
		this.input10 = input10;
	}

	public Integer getNumeroInputs() {
		return numeroInputs;
	}

	public void setNumeroInputs(Integer numeroInputs) {
		this.numeroInputs = numeroInputs;
	}

	public List<Integer> getListaInputs() {
		return listaInputs;
	}

	public void setListaInputs(List<Integer> listaInputs) {
		this.listaInputs = listaInputs;
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
