package in.das.app.model.enums;

import lombok.Getter;

@Getter
public enum CourseType {
    BTECH("BTECH"), MTECH("MTECH");

    private final String courseName;

    CourseType(String courseName){
        this.courseName = courseName;
    }
}
