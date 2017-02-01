package com.epam.paytickets.service;


import com.epam.paytickets.entity.Human;

public interface HumanService {
    Long addHuman(Human human);

    void updateHuman(Human human);

    Human getHumanById(Long humanId);

    void deleteHuman(Human human);
}
