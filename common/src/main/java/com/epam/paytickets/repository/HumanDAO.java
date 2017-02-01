package com.epam.paytickets.repository;


import com.epam.paytickets.entity.Human;

public interface HumanDAO {
    Long addHuman(Human human);

    void updateHuman(Human human);

    Human getHumanById(Long humanId);

    void deleteHuman(Human human);
}
