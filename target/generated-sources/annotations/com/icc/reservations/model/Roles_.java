package com.icc.reservations.model;

import com.icc.reservations.model.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-10T20:53:38")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile SingularAttribute<Roles, String> role;
    public static volatile SingularAttribute<Roles, Integer> id;
    public static volatile CollectionAttribute<Roles, Users> usersCollection;

}