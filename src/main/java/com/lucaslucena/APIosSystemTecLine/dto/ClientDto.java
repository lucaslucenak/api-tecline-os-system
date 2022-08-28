package com.lucaslucena.APIosSystemTecLine.dto;

import com.lucaslucena.APIosSystemTecLine.models.ClientModel;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClientDto {

    public ClientDto() {
    }

    public ClientDto(Long id, String name, String cpf, String phone_number, String email, Long address_id) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone_number = phone_number;
        this.email = email;
        this.address_id = address_id;
    }

    public ClientDto(ClientModel clientModel) {
        this.id = clientModel.getId();
        this.name = clientModel.getName();
        this.cpf = clientModel.getCpf();
        this.phone_number = clientModel.getPhone_number();
        this.email = clientModel.getEmail();
        this.address_id = clientModel.getAddress().getId();
    }

    private Long id;

    private String name;

    private String cpf;

    private String phone_number;

    private String email;

    private Long address_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }
}
