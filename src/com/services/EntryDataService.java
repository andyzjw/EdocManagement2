package com.services;

import java.util.List;

import com.enetity.Entry;

public interface  EntryDataService {
	/** 查询全部数据 */
	public List<Entry> query(Entry e);
	public List<Entry> query(Object...param);
	/** 添加数据  */
	public int add(Entry e);
	/** 修改数据 */
	public int modify(Entry e);
	/** 删除数据 */
	public int delete(Entry e);
	/** 查询总数据 */
	public int count(Object...param);
}
