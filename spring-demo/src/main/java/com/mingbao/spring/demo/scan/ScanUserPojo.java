package com.mingbao.spring.demo.scan;

import com.mingbao.spring.demo.pojo.UserPojo;
import org.springframework.stereotype.Component;

/**
 * description: 自动扫描的用户实体类
 * date: 2023-02-17
 *
 * @author Wind の Wound
 */
@Component
public class ScanUserPojo extends UserPojo {

	private boolean isScan;

	public ScanUserPojo() {
		setName("ming");
		setAge(20);
		setSex("男");
		isScan = true;
	}

	public boolean isScan() {
		return isScan;
	}

	public void setScan(boolean scan) {
		isScan = scan;
	}

	@Override
	public String toString() {
		return "ScanUserPojo{" +
				"name='" + getName() + '\'' +
				", age=" + getAge() +
				", sex='" + getSex() + '\'' +
				", isScan=" + isScan +
				'}';
	}
}
