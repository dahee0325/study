package com.boot.project.dao;

import java.io.Serializable;
import java.util.List;

//T 에는 Entity객체가 들어감
public interface MemberDao<T> extends Serializable {

	public List<T> getAll();
	public T findByIdx(long idx);
	public List<T> findByUname(String name);
	public List<T> find(String fstr);
	
}
