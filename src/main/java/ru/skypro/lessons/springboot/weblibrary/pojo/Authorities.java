package ru.skypro.lessons.springboot.weblibrary.pojo;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authorities")
public class Authorities implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String authority;


    public Authorities(Integer id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public Authorities() {
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
