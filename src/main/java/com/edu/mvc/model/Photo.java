package com.edu.mvc.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Kostiuk Nikita
 */

@Data
@Entity
@Table(name = "PHOTO")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Lob
    private byte[] image;
}
