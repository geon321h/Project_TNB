package mypage.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mypage.model.MypageReviewDao;
import mypage.model.RoomReservationBean;
import shop.model.ReviewBean; 
import shop.model.ReviewDao;

@Controller
public class ReviewUpdateController {

	private final String command = "/review_update.mp";
	private final String getPage = "review_update_form";
	private final String goToPage = "redirect:review_list.mp";
	
	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	MypageReviewDao mypageReviewDao;
	
	@Autowired
	ServletContext servletContext;
	
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public ModelAndView updateform(
			@RequestParam(value = "review_id") String review_id) {
		ModelAndView mav = new ModelAndView();
		
		ReviewBean review = mypageReviewDao.getReviewById(review_id);
		List<ReviewBean> review_img_list = mypageReviewDao.getReviewImageById(review_id);
		RoomReservationBean reservation = mypageReviewDao.getReservationById(String.valueOf(review.getReservation_id()));
		
		review.setReview_content(review.getReview_content().replaceAll("<br>","\r\n"));
		mav.addObject("reservation", reservation);
		mav.addObject("review_img_list", review_img_list);
		mav.addObject("review", review);
		mav.setViewName(getPage);
		return mav;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView update(			
			@ModelAttribute("reservation") @Valid RoomReservationBean reservation,			 
			@ModelAttribute("review") @Valid ReviewBean review,
			BindingResult result) {
		ModelAndView mav = new ModelAndView();
		System.out.println("getSave_image:"+review.getSave_image()); 

		if (result.hasErrors()) {
			System.out.println("에러");
			List<ReviewBean> review_img_list = mypageReviewDao.getReviewImageById(String.valueOf(review.getReview_id()));
			mav.addObject("review_img_list", review_img_list);
			mav.setViewName(getPage);
			return mav;
		}
		review.setReview_content(review.getReview_content().replaceAll("\r\n","<br>"));
		
		mav.setViewName(getPage);
		return mav;
	}
	
	
}
