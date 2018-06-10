package com.icc.reservations.model;

import com.icc.reservations.model.Localities;
import com.icc.reservations.model.Representations;
import com.icc.reservations.model.Shows;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-10T15:53:40")
@StaticMetamodel(Locations.class)
public class Locations_ { 

    public static volatile SingularAttribute<Locations, String> website;
    public static volatile SingularAttribute<Locations, String> address;
    public static volatile SingularAttribute<Locations, String> phone;
    public static volatile CollectionAttribute<Locations, Shows> showsCollection;
    public static volatile CollectionAttribute<Locations, Representations> representationsCollection;
    public static volatile SingularAttribute<Locations, Integer> id;
    public static volatile SingularAttribute<Locations, String> designation;
    public static volatile SingularAttribute<Locations, Localities> localityId;
    public static volatile SingularAttribute<Locations, String> slug;

}