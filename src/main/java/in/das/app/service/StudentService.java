package in.das.app.service;

import in.das.app.model.Student;
import in.das.app.model.response.StudentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class StudentService {

    private static final List<String> BANNED_STUDENT_NAMES = Arrays.asList("aaa","xxx");

    public StudentResponse addStudentService(final Student student){
        if(BANNED_STUDENT_NAMES.contains(student.getName())){
            return new StudentResponse(){{
                log.error("student banned! student-name=\"{}\"",student.getName());
                setStatus("error");
                setMessage("banned student! contact admin");
            }};
        }
        log.info("student add success!");
        return new StudentResponse(){{
            setStatus("success");
            setMessage("student added");
        }};
    }
}
