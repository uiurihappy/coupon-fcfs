package com.fcfs.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fcfs.api.domain.Coupon;
import com.fcfs.api.repository.CouponRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplyService {

	private final CouponRepository couponRepository;

	public void apply(Long userId) {
		long count = couponRepository.count();

		if (count > 100) {
			return;
		}
		couponRepository.save(new Coupon(userId));
	}
}
