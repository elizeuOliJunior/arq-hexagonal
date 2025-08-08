package com.elizgoj.hexagonal.hexagonalarchitecture.domain.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

    @JsonProperty("nome")
    public String nome;

    @JsonProperty("email")
    public String email;

    @JsonProperty("senha")
    public String senha;

    @JsonProperty("cpf")
    public String cpf;

    @JsonProperty("telefone")
    public String telefone;
}
