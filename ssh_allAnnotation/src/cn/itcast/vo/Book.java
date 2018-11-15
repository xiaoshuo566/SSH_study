package cn.itcast.vo;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//这个就代替了hibernate的实体映射文件

@Entity//声明式个实体类（来自javax的注解）
@Table(name="book")//（来自javax的注解）
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //声明，策略是mysql的自动增长
	private Integer id;
	@Column  //表明是一个普通属性（这个不写也行，默认就是）
	private String name ;
	private double price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
