package com.lucaslucena.APIosSystemTecLine.models;

import com.lucaslucena.APIosSystemTecLine.enumns.RoleEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_role")
@Getter
@Setter
public class RoleModel implements Serializable, GrantedAuthority {

    @Serial
    private static final long serialVersionUID = 1L;

    public RoleModel(RoleEnum role_name) {
        this.role_name = role_name;
    }

    public RoleModel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RoleEnum role_name;



    @Override
    public String getAuthority() {
        return role_name.toString();
    }
}
