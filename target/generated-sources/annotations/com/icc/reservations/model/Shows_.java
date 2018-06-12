package com.icc.reservations.model;

import com.icc.reservations.model.Locations;
import com.icc.reservations.model.Representations;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-12T22:15:29")
@StaticMetamodel(Shows.class)
public class Shows_ { 

    public static volatile SingularAttribute<Shows, Boolean> bookable;
    public static volatile SingularAttribute<Shows, String> posterUrl;
    public static volatile SingularAttribute<Shows, BigDecimal> price;
    public static volatile SingularAttribute<Shows, Locations> locationId;
    public static volatile CollectionAttribute<Shows, Representations> representationsCollection;
    public static volatile SingularAttribute<Shows, Integer> id;
    public static volatile SingularAttribute<Shows, String> title;
    public static volatile SingularAttribute<Shows, String> slug;

}