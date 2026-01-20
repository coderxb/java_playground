package indi.coderxb.easyblog.mapper;

import indi.coderxb.easyblog.entity.po.AccountPo;
import indi.coderxb.easyblog.entity.po.AccountPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountPoMapper {
    int countByExample(AccountPoExample example);

    int deleteByExample(AccountPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountPo record);

    int insertSelective(AccountPo record);

    List<AccountPo> selectByExample(AccountPoExample example);

    AccountPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountPo record, @Param("example") AccountPoExample example);

    int updateByExample(@Param("record") AccountPo record, @Param("example") AccountPoExample example);

    int updateByPrimaryKeySelective(AccountPo record);

    int updateByPrimaryKey(AccountPo record);
}