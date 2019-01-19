package com.nana.restapi.demo.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.nana.restapi.demo.domain.Contact;

@Mapper
public interface ContactMapper {
	List<Contact> getContactList();
}
