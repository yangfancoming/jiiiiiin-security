package cn.jiiiiiin.module.common.mapper.mngauth;

import cn.jiiiiiin.module.common.dto.mngauth.RoleDto;
import cn.jiiiiiin.module.common.entity.mngauth.Role;
import cn.jiiiiiin.module.common.enums.common.ChannelEnum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author jiiiiiin
 * @since 2018-09-27
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 批量插入role管理的resource
     *
     * @param role
     * @return
     */
    int insertRelationResourceRecords(Role role);

    /**
     * 删除角色id集合对应的用户关联记录
     *
     * @param idList
     * @return
     */
    int deleteRelationAdminRecords(@Param("idList") Collection<? extends Serializable> idList);

    /**
     * 删除角色id集合对应的资源关联记录
     *
     * @param idList
     * @return
     */
    int deleteRelationResourceRecords(@Param("idList") Collection<? extends Serializable> idList);

    /**
     * 检索对应角色id的角色和关联资源详细记录
     * @param id
     * @return
     */
    RoleDto selectRoleAndRelationRecords(Long id);

    /**
     * 检索对应角色（名称、标识、渠道）的分页数据
     * @param page
     * @param channel
     * @param role
     * @return
     */
    IPage<RoleDto> selectPageDto(Page<RoleDto> page, @Param("channel") ChannelEnum channel, @Param("role") Role role);

}
