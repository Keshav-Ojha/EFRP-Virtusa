package com.keshav.employeemanagement.service;

import java.util.List;

import com.keshav.employeemanagement.entity.EmployeeAddress;

public interface EmployeeAddressService {

	public List<EmployeeAddress> addEmployeeAddress(Long empId,EmployeeAddress address);
	public EmployeeAddress updateEmployeeAddress(Long empId,Long addressId, EmployeeAddress address);
	public void deleteEmployeAddress(Long empId, Long addressId);
	public EmployeeAddress getEmployeeAddressByAddressId(Long addressId);
	public List<EmployeeAddress> getEmployeeAddressListByEmployeeId(Long empId);
}
