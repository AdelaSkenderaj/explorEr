package com.explorer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class RegisteredId implements Serializable {

    private Long userId;
    private Long universityId;
}
