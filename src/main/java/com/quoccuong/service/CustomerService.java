package com.quoccuong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quoccuong.dao.CustomerDao;
import com.quoccuong.entities.Customer;
import com.quoccuong.service.ServiceResult.Status;

@Service
public class CustomerService {
	@Autowired CustomerDao customerdao;
	public ServiceResult findAll()
	{
		ServiceResult result=new ServiceResult();
		result.setData(customerdao.findAll());
		return result;
	}
	public ServiceResult findById(int id)
	{
		ServiceResult result=new ServiceResult();
		result.setData(customerdao.findById(id));
		return result;
	}
	public void create(Customer ctm)
	{
		customerdao.save(ctm);
	}
	public ServiceResult update (Customer ctm)
	{
		  ServiceResult result = new ServiceResult();
		if(!customerdao.findById(ctm.getId()).isPresent())
		{
			result.setStatus(Status.FAILED);
			result.setMessage("Customer not found");
		}
		else
		result.setData(customerdao.save(ctm));
		return result;
	}
	public ServiceResult delete (Customer ctm)
	{
		  ServiceResult result = new ServiceResult();
		if(!customerdao.findById(ctm.getId()).isPresent())
		{
			result.setStatus(Status.FAILED);
			result.setMessage("Customer not found");
		}
		else
		{
			customerdao.delete(ctm);
			result.setMessage("Success");
		}
		return result;
	}
	public ServiceResult findBynameLike(String name)
	{
		ServiceResult result=new ServiceResult();
		 result.setData(customerdao.a(name));
		 return result;
	}
}
