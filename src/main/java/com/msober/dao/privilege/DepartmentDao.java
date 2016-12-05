package com.msober.dao.privilege;

import java.util.List;

import com.msober.dao.common.BaseDao;
import com.msober.domain.privilege.Department;

public interface DepartmentDao extends BaseDao<Department> {

	List<Department> findChildren(Long parentId);

	List<Department> findTopList();

}
