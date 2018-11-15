package cn.itcast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.BookDao;
import cn.itcast.vo.Book;

@Service("bookService")//将该类的装配到spring。
@Transactional //开启事务管理
public class BookService {

	//注入dao
	@Autowired
	@Qualifier("bookDao")
	private BookDao bookDao;
	
	public void add(Book book) {
		System.out.println("Service层：this is add from service...");
		bookDao.add(book);
		
	}

}
