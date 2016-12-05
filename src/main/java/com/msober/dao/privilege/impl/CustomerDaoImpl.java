package com.msober.dao.privilege.impl;

import org.springframework.stereotype.Repository;

import com.msober.dao.common.impl.BaseDaoImpl;
import com.msober.dao.privilege.CustomerDao;
import com.msober.domain.privilege.Customer;

@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{

}
