package com.group.ctms.service;

import com.group.ctms.entity.Authority;
import com.group.ctms.util.Result;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/11.
 * 权限服务接口
 */
@SuppressWarnings("unused")
public interface IAuthorityService {
    Result addApprover(Authority authority);

    boolean deleteApprover(Integer id);

    List<Authority> listAllAuthority();

    /**
     * 通过审批权限记录的id查找一位审批者
     * @param id 记录id
     * @return 返回一个审批者记录
     */
    Authority findApproverById(Integer id);

    /**
     * 根据权限表中的用户的id查找一条审批者记录
     * @param id
     * @return
     */
    Authority findApproverByUserId(Integer id);

}
