package cn.itcast.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.service.BookService;
import cn.itcast.vo.Book;

//就是把以前struts.xml文件里<package namespace="/" extends="struts-default"> 改用注解进行设置了
@Namespace("/")
@ParentPackage("struts-default") 
@Controller("bookAction") //使用controller注解，将该类的装配到spring。（其实action层就是ssm中的controller层）
@Scope("prototype") //action层的类交给spring管理后一定要设置多例
public class BookAction extends ActionSupport implements ModelDriven<Book>{
	private Book book = new Book();
	@Override
	public Book getModel() { 
		return book;
	}
	
	//注入service
	@Autowired
	@Qualifier("bookService")
	private BookService bookService;
	
	@Action(value="book_add")
	public String add(){
		System.out.println("web层：this is add from action...");
		bookService.add(book);
		return NONE;
	}


}
