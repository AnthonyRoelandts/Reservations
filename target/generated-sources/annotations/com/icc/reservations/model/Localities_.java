package com.icc.reservations.model;

import com.icc.reservations.model.Locations;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-12T19:43:45")
@StaticMetamodel(Localities.class)
public class Localities_ { 

    public static volatile SingularAttribute<Localities, String> postalCode;
    public static volatile SingularAttribute<Localities, String> locality;
    public static volatile CollectionAttribute<Localities, Locations> locationsCollection;
    public static volatile SingularAttribute<Localities, Integer> id;

}