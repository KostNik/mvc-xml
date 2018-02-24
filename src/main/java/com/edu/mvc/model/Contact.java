package com.edu.mvc.model;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * @author Kostiuk Nikita
 */

@Data
@Entity
@Table(name = "CONTACTS")
@NamedQueries({
        @NamedQuery(name = "Contact.getByFirstAndLastName", query = "select c from Contact c where c.firstName=:firstName and c.lastName =:lastName"),
        @NamedQuery(name = "Contact.getPhoto", query = "select p from Photo p join Contact c on p=c.photo where c=:id")
})
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long   id;
    @Version
    @Column(name = "VERSION")
    private int    version;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "BIRTH_DATE")
    private DateTime birthDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Photo photo;


}
