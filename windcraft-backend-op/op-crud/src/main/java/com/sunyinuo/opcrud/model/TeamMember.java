package com.sunyinuo.opcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunyinuo
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeamMember {
    private int id;
    private String type;
    private String name;
    private String introduction;
}
