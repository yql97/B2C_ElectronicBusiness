/**
 * 
 */
package ECS_Common.entity;

/**
 * @author yueqiulin
 *
 */
public class goodsCategory {
   private int id;
   private int family_id;
   private String category_name;
   
   

public goodsCategory(int id, int family_id, String category_name) {
	super();
	this.id = id;
	this.family_id = family_id;
	this.category_name = category_name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getFamily_id() {
	return family_id;
}
public void setFamily_id(int family_id) {
	this.family_id = family_id;
}
public String getCategory_name() {
	return category_name;
}
public void setCategory_name(String category_name) {
	this.category_name = category_name;
}
   
}
