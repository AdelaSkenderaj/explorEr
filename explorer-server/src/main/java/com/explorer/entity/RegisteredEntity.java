package com.explorer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "REGISTERED")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredEntity {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "university_id")
    private Long universityId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "faculty_id")
    private Long facultyId;

    @Column(name = "program_id")
    private Long programId;
}
