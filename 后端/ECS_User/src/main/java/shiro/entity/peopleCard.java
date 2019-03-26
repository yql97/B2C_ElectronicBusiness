package shiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="people_card")
public class peopleCard {
  @Id
   private int people_card_id;
  @Column(name="card_num")
   private String card_num;
    @Column(name="card_front_image")
  private String front_image;
    @Column(name="card_back_image")
  private String back_image;
    @Column(name="card_status")
  private int status;
    @Column(name="user_id")
  private int user_id;

    public String getCard_num() {
        return card_num;
    }

    public void setCard_num(String card_num) {
        this.card_num = card_num;
    }

    public String getFront_image() {
        return front_image;
    }

    public void setFront_image(String front_image) {
        this.front_image = front_image;
    }

    public String getBack_image() {
        return back_image;
    }

    public void setBack_image(String back_image) {
        this.back_image = back_image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPeople_card_id() {
        return people_card_id;
    }

    public void setPeople_card_id(int people_card_id) {
        this.people_card_id = people_card_id;
    }
}
