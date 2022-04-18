package capstone.laura.youthmatters.healthresources.services;

import capstone.laura.youthmatters.healthresources.models.Hotline;
import capstone.laura.youthmatters.healthresources.repositories.HotlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotlineServiceImpl implements HotlineService {

    private final HotlineRepository hotlineRepository;

    @Autowired
    public HotlineServiceImpl(HotlineRepository hotlineRepository) {
        this.hotlineRepository = hotlineRepository;
    }

    @Override
    public List<Hotline> getAllHotlineLists() {
        return hotlineRepository.findAll();
    }

    @Override
    public void saveHotline(Hotline hotline) {
        hotlineRepository.save(hotline);
    }

    @Override
    public Hotline getHotlineById(long id) {
        Optional<Hotline> optional = hotlineRepository.findById(id);
        Hotline hotline = null;
        if (optional.isPresent()) {
            hotline = optional.get();
        } else {
            throw new RuntimeException("hotline not found for id :: " + id);
        }
        return hotline;
    }

    @Override
    public void deleteHotlineById(long id) {
        hotlineRepository.deleteById(id);
    }
}
