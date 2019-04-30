package mybatis.mapper;

import java.util.List;
import mybatis.model.TableAbc;
import mybatis.model.TableAbcExample;
import org.apache.ibatis.annotations.Param;

public interface TableAbcMapper {
    long countByExample(TableAbcExample example);

    int deleteByExample(TableAbcExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TableAbc record);

    int insertSelective(TableAbc record);

    List<TableAbc> selectByExample(TableAbcExample example);

    TableAbc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TableAbc record, @Param("example") TableAbcExample example);

    int updateByExample(@Param("record") TableAbc record, @Param("example") TableAbcExample example);

    int updateByPrimaryKeySelective(TableAbc record);

    int updateByPrimaryKey(TableAbc record);
}