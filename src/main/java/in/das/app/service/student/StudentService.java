package in.das.app.service.student;

import in.das.app.exceptions.student.StudentException;
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
            log.error("banned student name={}", student.getName());
            throw new StudentException("Banned Student","error");
        }
        log.info("student add success!");
        return new StudentResponse(){{
            setStatus("success");
            setMessage("student added");
        }};
    }
}
