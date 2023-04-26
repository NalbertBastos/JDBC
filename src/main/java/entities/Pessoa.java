package entities;


public class Pessoa {
	private String nome;
	private String sobrenome;
	private String nascimento;
	private String sexo;
	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String sobrenome, String nascimento, String sexo) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nascimento = nascimento;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	

}
