package chap03;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ConnPool2 {
	@PostConstruct
	public void initPool(){
		System.out.println("ConnPool2.initPool()");
	}
	@PreDestroy
	public void destoryPool(){
		System.out.println("ConnPool2.destoryPool()");
	}
}