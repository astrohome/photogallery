package com.galaxysoft.photogallery.impl.model;

import com.galaxysoft.photogallery.api.model.Order;
import com.galaxysoft.photogallery.api.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public class UserImpl implements UserDetails, User {

    private String email;

    private String password;

    private String role;

    private String firstName;

    private String lastName;

    private String activationCode;

    private boolean activated;

    private Set<Order> orders = new HashSet<>();

    /**
     * Login of user is email.
     *
     * @return
     */
    public String getLogin() {
        return email;
    }

    public void setLogin(String login) {
        this.email = login;
    }

    /**
     * Returns collection of all roles.
     *
     * @return
     */
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
    }

    /**
     * Hashed password (md5). No salt yet.
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Internal usage (equvalent to {@link #getLogin()}).
     *
     * @return
     */
    public String getUsername() {
        return email;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return activated;
    }

    /**
     * List of roles, separated by comma. Usually just one role.
     *
     * @return
     */
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /**
     * First name of client.
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Last (family) name of client.
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Stored in DB for first-time email activation.
     *
     * @return
     */
    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    @Override
    public boolean isActivated() {
        return this.activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
