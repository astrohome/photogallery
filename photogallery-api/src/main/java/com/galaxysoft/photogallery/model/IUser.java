package com.galaxysoft.photogallery.model;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 20/08/15.
 */
public interface IUser extends Serializable {
    String getLogin();

    void setLogin(String login);

    void setPassword(String password);

    String getRole();

    void setRole(String role);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getActivationCode();

    void setActivationCode(String activationCode);

    void setActivated(boolean activated);

    Set<IOrder> getOrders();

    void setOrders(Set<IOrder> orders);
}
