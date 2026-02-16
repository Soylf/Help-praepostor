package com.example.helppraepostor.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemStudent {
    private String name;
    private String age;
    private boolean selected; //Нужен только в UI
    private List<ItemStudent> studentsPrecedency;
    private boolean presentStudent;
}
