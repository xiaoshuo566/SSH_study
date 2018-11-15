package cn.itcast.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.itcast.vo.Book;

@Repository("bookDao") //表明该类是用来执行与数据库相关的操作(即dao对象).将该类装配到spring。
public class BookDao {
	//由于使用注解，我们必须手动注入模板。不能再用注入sessionFactory的方式到hibernate模板了。
	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public void add(Book book) {
		
		System.out.println("dao层：this is add from dao...");		
		hibernateTemplate.save(book);
	}

}
