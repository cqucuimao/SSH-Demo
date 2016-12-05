package com.msober.service.privilege;

import java.util.List;

import com.msober.domain.common.PageBean;
import com.msober.domain.privilege.Department;
import com.msober.service.base.BaseService;
import com.msober.utils.QueryHelper;

public interface DepartmentService extends BaseService {

	List<Department> getAll();

	void delete(Long id);

	void save(Department department);

	Department getById(Long id);

	void update(Department department);

	PageBean getPageBean(int pageNum, QueryHelper helper);


}
