package model.dao;

import java.util.List;

import model.entities.Departamento;

public interface DepartamentoDao {

	void inserir (Departamento obj);	
	void atualizar(Departamento obj);
	void excluirPorId(Integer id);
	Departamento buscaPorId(Integer id);
	List<Departamento> buscarTodos();
}
