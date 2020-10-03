package io.jesussaavedra.myfirstapp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Information implements Serializable {
    private String name;
    private Education education;
    private Job job;
    private Technologies[] technologies;

}
