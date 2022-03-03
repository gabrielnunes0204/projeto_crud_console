package dao;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class BD {
	static public List<Usuario> listaUsuarios = new ArrayList<>();
	
	static public List<Usuario> listaUsuarios() {
		return listaUsuarios;
	}
}
