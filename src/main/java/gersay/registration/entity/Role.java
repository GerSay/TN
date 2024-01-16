package gersay.registration.entity;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "t_role")
public class Role implements GrantedAuthority {

    @Id
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    @Transient
    @ManyToMany(mappedBy = "Roles")
    private Set<User> users;



    @Override
    public String getAuthority() {
        return getName();
    }



    public Role() {}
    public Role(Long id) { this.id = id; }
    public Role(Long id, String name) { this.id = id; this.name = name; }


}
