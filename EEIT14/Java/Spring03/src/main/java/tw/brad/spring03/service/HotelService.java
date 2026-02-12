package tw.brad.spring03.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tw.brad.spring03.entity.Hotel;
import tw.brad.spring03.repository.HotelRepository;

@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;
	
	public Page<Hotel> getHotels(int page, int rpp) {
		
		Pageable pageable = PageRequest.of(page, rpp);	// page => 0-base
		Page<Hotel> hotelPage = hotelRepository.findAll(pageable);
		
		return hotelPage;
	}
	
	public Map<String,Object> getHotelsV2(int page, int rpp) {
		Pageable pageable = PageRequest.of(page, rpp);	// page => 0-base
		Page<Hotel> hotelPage = hotelRepository.findAll(pageable);
		
		Map<String,Object> result = Map.of(
				"data", hotelPage.getContent(),
				"total", hotelPage.getTotalElements(),
				"totalPage", hotelPage.getTotalPages(),
				"page", hotelPage.getNumber(),
				"isLast", hotelPage.isLast(),
				"isEmpty", hotelPage.isEmpty()
				);
		
		return result;
	}
	
}