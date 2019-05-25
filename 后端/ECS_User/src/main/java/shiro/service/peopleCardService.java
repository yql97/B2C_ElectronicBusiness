package main.java.shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiro.dao.impl.peopleCardImpl;
import shiro.entity.peopleCard;

@Service
public class peopleCardService {
    @Autowired
    private peopleCardImpl pcI;

    public int addpeopleCard(peopleCard people_card){
          int row =pcI.addPeopleCard(people_card);
        return row;
    }
    public int updatepeopleCard(peopleCard people_card){
             int row =pcI.updatePeopleCard(people_card);
        return row;
    }
    public peopleCard selectPeopleCard(int id){
             peopleCard p=pcI.selectByUserId(id);
             if(p!=null) return p;
        return null;
    }
}
