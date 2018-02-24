package com.edu.mvc.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Kostiuk Nikita
 */

@Data
@Entity
@Table(name = "PHOTOS")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Version
    @Column(name = "VERSION")
    private int version;

    @Lob
    @Column(name = "IMAGE")
    private byte[] image;
}
