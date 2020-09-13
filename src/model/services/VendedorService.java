package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Vendedor;

public class VendedorService {
	
	private VendedorDao dao = DaoFactory.createVendedorDao();

	public List<Vendedor> buscarTodos() {
		return dao.buscarTodos();
	}
	
	public void salvarOuAtualizar(Vendedor obj) {
		if(obj.getId() == null) {
			dao.inserir(obj);
		}
		else {
			dao.atualizar(obj);
		}
	}
	
	public void remove(Vendedor obj) {
		dao.excluirPorId(obj.getId());
	}
}

