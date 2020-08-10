package com.ccc.vendas.api.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;


//@Table(name = "tb_cliente") Exemplo, caso o nome da classe seja diferente do nome da table, podemos utilizar essa anotacação
@Entity
public class Cliente {
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome", length = 100)
	private String nome;


	@Column(name = "cpf",length = 11)
	private String cpf;

	@JsonIgnore //Ele é ignorado e não é retornado no Json
	@OneToMany (mappedBy = "cliente", fetch = FetchType.LAZY)
	private Set<Pedido> pedidos;

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Cliente() {

	}

	public Cliente(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Cliente(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
