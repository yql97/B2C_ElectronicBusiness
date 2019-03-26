package shiro.dao;

import shiro.entity.bankCard;
import java.util.List;
public interface bankCardDao {
    public List<bankCard> selectByAccountId(int id);
    public bankCard selectById(String id);
    public int addBankCard(bankCard bank_card);
    public int addBankCardBalance(bankCard bank_card,double add_num);
    public int subBankCardBalance(bankCard bank_card,double sub_num);
    public int deleteBankCard(bankCard bank_card);

}
