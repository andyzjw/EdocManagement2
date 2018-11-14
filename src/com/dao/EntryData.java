package com.dao;

import java.util.List;

import com.enetity.Entry;

public interface EntryData {
	/** 增加数据 */
	public abstract int add(Entry e);
	/** 删除数据 */
	public abstract int delete(Entry e);
	/** 修改数据 */
	public abstract int modify(Entry e);
	/**  查询数据 */
	public abstract List<Entry> query(Entry e);
	public abstract List<Entry> query(String sql,Object...param);
}
