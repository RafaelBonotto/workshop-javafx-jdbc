package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Departamento;
import model.services.DepartamentoService;

public class DepartmentFormController implements Initializable {
	
	private Departamento entity;
	
	private DepartamentoService service;
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Button btSalvar;
	
	@FXML
	private Button btCancelar;
	
	public void setDepartamento(Departamento entity) {
		this.entity = entity;
	}
	
	public void setDepartamentoService(DepartamentoService service) {
		this.service = service;
	}
	
	@FXML
	public void onBtSalvarAction(ActionEvent event) {
		if(entity == null) {
			throw new IllegalStateException("Entity was null!");
		}
		if(service == null) {
			throw new IllegalStateException("Service was null!");
		}
		try{
			entity = getFormData();
			service.salvarOuAtualizar(entity);
			Utils.stageAtual(event).close();
		}
		catch(DbException e) {
			Alerts.showAlert("ERRO ao salvar o objeto", null, e.getMessage(),AlertType.ERROR);
		}
		
	}
	
	private Departamento getFormData() {
		Departamento obj = new Departamento();
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setNome(txtNome.getText());
		
		return obj;
	}

	@FXML
	public void onBtCancelar(ActionEvent event) {
		Utils.stageAtual(event).close();
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	public void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtNome, 30);
	}
	
	public void updateFormData() {
		if(entity == null) {
			throw new IllegalStateException("Departamento est� nulo!");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtNome.setText(String.valueOf(entity.getNome()));
	}

}