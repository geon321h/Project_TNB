package mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mypage.model.MypageReviewDao;
import mypage.model.RoomReservationBean;
import shop.model.ReviewDao;

@Controller
public class ReviewInsertController {

	private final String command = "/review_insert.mp";
	private final String getPage = "review_insert_form";
	
	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	MypageReviewDao mypageReviewDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public ModelAndView insertform(
			@RequestParam(value = "reservation_id") String reservation_id,
			@RequestParam(value = "shop_name") String shop_name) {
		ModelAndView mav = new ModelAndView();
		
		RoomReservationBean reservation = mypageReviewDao.getReservationById(reservation_id);
		
		mav.addObject("shop_name", shop_name);
		mav.addObject("reservation", reservation);
		mav.setViewName(getPage);
		return mav;
	}
	
	
}
