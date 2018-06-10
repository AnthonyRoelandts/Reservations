package com.icc.reservations.model;

import com.icc.reservations.model.Locations;
import com.icc.reservations.model.Shows;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-10T15:53:40")
@StaticMetamodel(Representations.class)
public class Representations_ { 

    public static volatile SingularAttribute<Representations, Shows> showId;
    public static volatile SingularAttribute<Representations, Locations> locationId;
    public static volatile SingularAttribute<Representations, Integer> id;
    public static volatile SingularAttribute<Representations, Date> when;

}