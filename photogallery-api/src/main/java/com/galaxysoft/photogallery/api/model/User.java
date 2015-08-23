package com.galaxysoft.photogallery.api.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
@Entity
@Table(name = "USER_")
public interface User extends Serializable {
    @Id
    @Column(unique = true)
    @NotNull
    @Email
    String getLogin();

    void setLogin(String login);

    @Column(nullable = false)
    @NotNull
    @Size(min = 4)
    String getPassword();

    void setPassword(String password);

    @Column(nullable = false)
    @NotNull
    String getRole();

    void setRole(String role);

    @Column(nullable = false)
    @NotNull
    @Size(min = 2)
    String getFirstName();

    void setFirstName(String firstName);

    @Column(nullable = false)
    @NotNull
    @Size(min = 2)
    String getLastName();

    void setLastName(String lastName);

    @Column(nullable = false)
    @NotNull
    String getActivationCode();

    void setActivationCode(String activationCode);

    @Column(nullable = false)
    @NotNull
    boolean isActivated();

    void setActivated(boolean activated);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    Set<Order> getOrders();

    void setOrders(Set<Order> orders);
}
