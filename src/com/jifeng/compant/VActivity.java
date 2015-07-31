package com.jifeng.compant;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
/**
 * 
 * @author GuanJing
 * 此activity是为了对验证表单对edittext提供存储如果需要继承其他activity 只需要将下面方法写入到被继承的activity或者当前activity即可
 */
public class VActivity extends Activity {

	private List<VEditText> list=new ArrayList<VEditText>();

	public List<VEditText> getList() {
		return list;
	}
	/**
	 * 
	 * @param veditText 添加当前页面的vedittext
	 */
	public void addList(VEditText veditText) {
		list.add(veditText);
	}
	/**
	 * 验证表单是否通过
	 * @return 
	 */
	public boolean fromvalidate() {
		boolean istrue=true;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getError()!=null&&!list.get(i).getError().equals("")){
				istrue= false;
			}
			
		}
		return istrue;
	}
}
