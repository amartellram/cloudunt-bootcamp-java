package com.jhonlivias.myfirstapp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    private String name;
    private String education;
    private String tec;

    public Information(String name, String education, String tec) {
    }
}
