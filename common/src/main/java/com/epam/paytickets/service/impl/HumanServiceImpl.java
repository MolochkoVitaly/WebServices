package com.epam.paytickets.service.impl;

import com.epam.paytickets.entity.Human;
import com.epam.paytickets.repository.HumanDAO;
import com.epam.paytickets.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HumanServiceImpl implements HumanService {

    @Autowired
    private HumanDAO humanDAO;

    @Override
    public Long addHuman(Human human) {
        return humanDAO.addHuman(human);
    }

    @Override
    public void updateHuman(Human human) {
        humanDAO.updateHuman(human);
    }

    @Override
    public Human getHumanById(Long humanId) {
        return humanDAO.getHumanById(humanId);
    }

    @Override
    public void deleteHuman(Human human) {
        humanDAO.deleteHuman(human);
    }
}
