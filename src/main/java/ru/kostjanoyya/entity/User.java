package ru.kostjanoyya.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "t_users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotNull
    @Column(nullable = false, columnDefinition = "BOOLEAN default true")
    private Boolean isEnabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ShoppingItem> shoppingItems;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return roles;}

    @Override
    public boolean isAccountNonExpired() { return true;} //code stub

    @Override
    public boolean isAccountNonLocked() { return true;} //code stub

    @Override
    public boolean isCredentialsNonExpired() { return true;} //code stub

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
