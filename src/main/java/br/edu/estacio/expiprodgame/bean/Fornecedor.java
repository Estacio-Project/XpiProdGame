package br.edu.estacio.expiprodgame.bean;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Fornecedor {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cnpj;
	private String razao_social;
	private String endereco;
	private String telefone;
	
			//razao_social
			//endereco
			//telefone
			//email
			//data_cadastro
			//data_alteracao
	
	
		public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}





	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	



	
	public Fornecedor() {
		super();
	}



	public Fornecedor(String nome, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
	}
	




	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCnpj() {
		return cnpj;
	}



	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

	public String getRazao_social() {
		return razao_social;
	}



	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	public String info(){
		return "Fornecedor [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj
				+ ", Usuario [" + (usuario != null ? usuario.getId():-1) + "] ]";
	
	}


	@Override
	public String toString() {
		return getId().toString();
		}

	
	

}
