package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class DepartamentoService {
	
	private DepartamentoDao dao = DaoFactory.createDepartmentDao();

	public List<Departamento> buscarTodos() {
		return dao.buscarTodos();
	}
	
	public void salvarOuAtualizar(Departamento obj) {
		if(obj.getId() == null) {
			dao.inserir(obj);
		}
		else {
			dao.atualizar(obj);
		}
	}
	
	public void remove(Departamento obj) {
		dao.excluirPorId(obj.getId());
	}
}

