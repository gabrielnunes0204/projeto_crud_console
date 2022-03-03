package model;

public class Usuario {

	private String id;
	private static Long iterador = 0L;
	private String nome;
	private Integer idade;
	private String email;
	private String senha;
	
	public Usuario() {}
	
	public Usuario(String nome, Integer idade, String email, String senha) {
		this.id = iterarId();
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.senha = senha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//ITERAR ID
	public String iterarId() {
		return String.valueOf(iterador++);
	}
}
