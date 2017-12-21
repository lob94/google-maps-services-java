package com.google.maps.internal.ratelimiter;

import org.junit.Assert;
import org.junit.Test;

public class StopWatchTest {
	@Test
	public void TestCreateUnstarted() {
		Stopwatch stopWatch = Stopwatch.createUnstarted();
		Assert.assertFalse(stopWatch.isRunning());
		stopWatch.start();
		Assert.assertTrue(stopWatch.isRunning());
		stopWatch.reset();
		Assert.assertFalse(stopWatch.isRunning());
		stopWatch.start();
		Assert.assertTrue(stopWatch.isRunning());
		stopWatch.stop();
		Assert.assertFalse(stopWatch.isRunning());
	}

	@Test
	public void TestCreateUnstarted2() {
		Ticker ticker = new Ticker() {

			@Override
			public long read() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		Stopwatch stopWatch = Stopwatch.createUnstarted(ticker);
		Assert.assertFalse(stopWatch.isRunning());
		stopWatch.start();
		Assert.assertTrue(stopWatch.isRunning());
		stopWatch.reset();
		Assert.assertFalse(stopWatch.isRunning());
		stopWatch.start();
		Assert.assertTrue(stopWatch.isRunning());
		stopWatch.stop();
		Assert.assertFalse(stopWatch.isRunning());
	}

	@Test
	public void TestCreateStarted2() {
		Ticker ticker = new Ticker() {

			@Override
			public long read() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		Stopwatch stopWatch = Stopwatch.createStarted(ticker);
		Assert.assertTrue(stopWatch.isRunning());
		stopWatch.reset();
		Assert.assertFalse(stopWatch.isRunning());
		stopWatch.start();
		Assert.assertTrue(stopWatch.isRunning());
		stopWatch.stop();
		Assert.assertFalse(stopWatch.isRunning());
	}
}
