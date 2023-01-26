package in.das.app.service.testservices;

import in.das.app.exceptions.type.ValidationException;
import in.das.app.model.request.Voter;
import in.das.app.utils.UtilInf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VoterService {

    public boolean isVoterValid(final Voter voter) throws ValidationException {
        if(voter != null && voter.getAge() < 18){
            log.error("[ERROR] Voter age less than 18");
            throw new ValidationException("Invalid Voter! Age less than 18", UtilInf.getUUIDString());
        }
        return true;
    }
}
