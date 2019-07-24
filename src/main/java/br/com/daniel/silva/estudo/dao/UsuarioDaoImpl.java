package br.com.daniel.silva.estudo.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.daniel.silva.estudo.domain.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private static List<Usuario> us;
	
	public UsuarioDaoImpl() {
		createUserList();
	}
	
	private List<Usuario> createUserList(){
		if (us == null) {
			us = new LinkedList<Usuario>();
			us.add(new Usuario(System.currentTimeMillis() + 1L, "Ana", "da Silva"));
			us.add(new Usuario(System.currentTimeMillis() + 1L, "Luiz", "dos Santos"));
			us.add(new Usuario(System.currentTimeMillis() + 1L, "Mariana", "Mello"));
			us.add(new Usuario(System.currentTimeMillis() + 1L, "Caren", "Pereira"));
			us.add(new Usuario(System.currentTimeMillis() + 1L, "Sonia", "Fagundes"));
			us.add(new Usuario(System.currentTimeMillis() + 1L, "Noberto", "de Souza"));
		}
		
		return us;
	}
	
	@Override
	public void salvar(Usuario usuario) {
		usuario.setId(System.currentTimeMillis());
		us.add(usuario);		
	}

	@Override
	public void editar(Usuario usuario) {
		us.stream()
			.filter((u) -> u.getId().equals(usuario.getId()))
			.forEach((u) -> {
				u.setNome(usuario.getNome());
				u.setSobrenome(usuario.getSobrenome());
			});
	}

	@Override
	public void excluir(Long id) {
		us.removeIf((u) -> u.getId().equals(id));
		
	}

	@Override
	public Usuario getId(Long id) {
		return us.stream()
				.filter((u) -> u.getId().equals(id))
				.collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Usuario> getTodos() {
		return us;
	}

}
