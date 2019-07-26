package com.es.dao;

import com.es.bean.ItemParamItem;
import com.es.bean.ItemParamItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemParamItemMapper {
    long countByExample(ItemParamItemExample example);

    int deleteByExample(ItemParamItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemParamItem record);

    int insertSelective(ItemParamItem record);

    List<ItemParamItem> selectByExampleWithBLOBs(ItemParamItemExample example);

    List<ItemParamItem> selectByExample(ItemParamItemExample example);

    ItemParamItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemParamItem record, @Param("example") ItemParamItemExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemParamItem record, @Param("example") ItemParamItemExample example);

    int updateByExample(@Param("record") ItemParamItem record, @Param("example") ItemParamItemExample example);

    int updateByPrimaryKeySelective(ItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(ItemParamItem record);

    int updateByPrimaryKey(ItemParamItem record);
}