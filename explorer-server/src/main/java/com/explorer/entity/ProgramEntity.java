package com.explorer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PROGRAM")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgramEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "university_id")
    private Long universityId;

    @Column(name = "faculty_id")
    private Long facultyId;
}
