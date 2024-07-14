package mypage.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myMypageReviewDao")
public class MypageReviewDao {

	private String namespace = "mypage.model.ReviewMy";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public RoomReservationBean getReservationById(String reservation_id) {
		RoomReservationBean reservation = sqlSessionTemplate.selectOne(namespace+".getReservationById",reservation_id);
		return  reservation;
	}
	
	
}
