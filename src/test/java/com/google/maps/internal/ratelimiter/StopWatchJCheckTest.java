package com.google.maps.internal.ratelimiter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(org.jcheck.runners.JCheckRunner.class)
public class StopWatchJCheckTest {
	@Test
	public void TestChooseUnit(double i) throws InterruptedException {
		if (i > 0) {
			RateLimiter limiter = RateLimiter.create(i);
			Assert.assertTrue(limiter.tryAcquire());
		}
	}

	@Test
	public void TestTryAcquired(int i) {
		double x = new Double(30);
		RateLimiter limiter = RateLimiter.create(x);
		if (i > 0) {
			Assert.assertTrue(limiter.tryAcquire(i));
		}
	}
}
