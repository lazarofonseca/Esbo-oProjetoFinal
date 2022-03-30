package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.exception.EntityNotFoundException;

@Service
public class usuarioSevice {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public UsuarioDTO insert(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario = criaUsuario(usuarioDTO);
		usuario = usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario);
		
	}
        //Busca por id do usuário	
	public Usuario findById(Long id){
	
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id " + id + " não encontrado."));
	}

	private Usuario criaUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setNome(usuarioDTO.getNome());
		usuario.setCpf(usuarioDTO.getCpf());
		usuario.setDataNascimento(usuarioDTO.getDataNascimento());
		usuario.setTelefone(usuario.getTelefone());
		usuario.setEmail(usuario.getEmail());
		usuario.setSenha(usuarioDTO.getSenha());
		return usuario;
	}
}
