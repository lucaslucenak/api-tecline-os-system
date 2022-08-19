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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RoleEnum roleName;

    @Override
    public String getAuthority() {
        return roleName.toString();
    }
}
