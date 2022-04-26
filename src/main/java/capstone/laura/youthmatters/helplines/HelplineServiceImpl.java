package capstone.laura.youthmatters.helplines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HelplineServiceImpl implements HelplineService {

    private final HelplineRepository helplineRepository;

    @Autowired
    public HelplineServiceImpl(HelplineRepository helplineRepository) {
        this.helplineRepository = helplineRepository;
    }

    @Override
    public List<Helpline> getAllHelplines() {
        return helplineRepository.findAll();
    }



    @Override
    public Helpline getHelplineById(long id) {
        Optional<Helpline> optional = helplineRepository.findById(id);
        Helpline helpline = null;
        if (optional.isPresent()) {
            helpline = optional.get();
        } else {
            throw new RuntimeException("helpline not found for id :: " + id);
        }
        return helpline;
    }

}
