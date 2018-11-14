package com.services.impl;

import java.util.List;

import com.dao.impl.EntryDataImpl;
import com.enetity.Entry;
import com.services.EntryDataService;

public class EntryDataServiceImpl implements EntryDataService {
	private EntryDataImpl ed;
	
	public EntryDataServiceImpl() {
		 ed = new EntryDataImpl();
	}

	/** 查询 全部电子文档 */
	public List<Entry> query(Entry e) {
		return ed.query(e);
	}
	public List<Entry> query( Object... param) {
		return ed.query(param);
	}
	/**查询总数据*/
	public int count(Object...param) {
		return ed.count(param);
	}
	/** 添加电子文档 */
	public int add(Entry e) {
		return ed.add(e);
	}

	/** 修改电子文档 */
	public int modify(Entry e) {
		return ed.modify(e);
	}

	/** 删除电子文档 */
	public int delete(Entry e) {
		return ed.delete(e);
	}
	
	

}
