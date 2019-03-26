package shiro.dao;

import shiro.entity.peopleCard;

public interface peopleCardDao {
    public int addPeopleCard(peopleCard people_card);
    public int updatePeopleCard(peopleCard people_card);
    public peopleCard selectByUserId(int id);
}
