package hu.adamkiss.fun;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
class RobiProblem1Test {
	
	@Test
	@Disabled("poor performance because of strings")
	void test() {
		log.info("START");
		List<long[]> solutions = new ArrayList<>();
		for (int actTargetSum = 0; actTargetSum < 10000; actTargetSum++) {
			if(actTargetSum % 1000 == 0) {
				log.info("Here I am: {}", actTargetSum);
			}
			long a, b, c;
			for (int i = 0; i < actTargetSum + 1; i++) {
				a = i;
				for (int j = 0; j < actTargetSum - i + 1; j++) {
					b = j;
					c = actTargetSum - (a + b);
					String formattedString;
					if(a != 0) {
						formattedString = String.format("%s%s%s", a, b, c);
					} else if(b != 0) {
						formattedString = String.format("%s%s", b, c);
					} else {
						formattedString = String.format("%s", c);
					}
					if(String.valueOf((long)((a+b+c)*(a+b+c)*(a+b+c))).equals(formattedString)) {
						log.info(String.format("Solution found - A: %s, B: %s, C: %s, Big num:  %s", a, b, c, formattedString));
						solutions.add(new long[] {a, b, c});
					}
					//System.out.println(String.format("A: %s, B: %s, C: %s, SUM: %s, targetSum: %s", a, b, c, (a+b+c), actTargetSum));
				}
			}
		}
		log.info("END");
		assertEquals(1, 1);
	}
	
	@Test
	@Disabled("poor performance still")
	void test2() {
		log.info("START");
		List<long[]> solutions = new ArrayList<>();
		for (int actTargetSum = 0; actTargetSum < 10000; actTargetSum++) {
			if(actTargetSum % 1000 == 0) {
				log.info("Here I am: {}", actTargetSum);
			}
			long a, b, c;
			for (int i = 0; i < actTargetSum + 1; i++) {
				a = i;
				for (int j = 0; j < actTargetSum - i + 1; j++) {
					b = j;
					c = actTargetSum - (a + b);
					long lb, lc;
					if(c < 100) {
						if(c < 10) {
							lc = 1;
						} else {
							lc = 2;
						}
					} else {
						if(c < 1000) {
							lc = 3;
						} else {
							lc = 4;
						}
					}
					
					if(b < 100) {
						if(b < 10) {
							lb = 1;
						} else {
							lb = 2;
						}
					} else {
						if(b < 1000) {
							lb = 3;
						} else {
							lb = 4;
						}
					}
					
					long calculated1 = (long)((Math.pow(10, (lb + lc))* a) + (Math.pow(10, lc) * b) + c);
					long calculated2 = (long)((a+b+c)*(a+b+c)*(a+b+c));
					
					if(calculated1 == calculated2) {
						log.info(String.format("Solution found - A: %s, B: %s, C: %s, Big num:  %s", a, b, c, calculated1));
						solutions.add(new long[] {a, b, c});
					}
				}
			}
		}
		log.info("END");
		assertEquals(1, 1);
	}
	
	@Test
	@Disabled("poor performance still")
	void test3() {
		log.info("START");
		List<long[]> solutions = new ArrayList<>();
		IntStream.range(0, 11).parallel().forEach(segment -> {
			int startTargetSum = (10000 / 10) * segment;
			int endTargetSumExcl = startTargetSum + (10000 / 10);
		
			for (int actTargetSum = startTargetSum; actTargetSum < endTargetSumExcl; actTargetSum++) {
				long a, b, c;
				for (int i = 0; i < actTargetSum + 1; i++) {
					a = i;
					for (int j = 0; j < actTargetSum - i + 1; j++) {
						b = j;
						c = actTargetSum - (a + b);
						long lb, lc;
						if(c < 100) {
							if(c < 10) {
								lc = 1;
							} else {
								lc = 2;
							}
						} else {
							if(c < 1000) {
								lc = 3;
							} else {
								lc = 4;
							}
						}
						
						if(b < 100) {
							if(b < 10) {
								lb = 1;
							} else {
								lb = 2;
							}
						} else {
							if(b < 1000) {
								lb = 3;
							} else {
								lb = 4;
							}
						}
						
						long calculated1 = (long)((Math.pow(10, (lb + lc))* a) + (Math.pow(10, lc) * b) + c);
						long calculated2 = (long)((a+b+c)*(a+b+c)*(a+b+c));
						
						if(calculated1 == calculated2) {
							log.info(String.format("Solution found - A: %s, B: %s, C: %s, Big num:  %s", a, b, c, calculated1));
							solutions.add(new long[] {a, b, c});
						}
					}
				}
			}
		});
		
		log.info("END");
		assertEquals(1, 1);
	}
	
	@Test
	void test4() {
		log.info("START");
		int segmentCnt = 1000;
		List<long[]> solutions = new ArrayList<>();
		IntStream.range(0, 0 + segmentCnt + 1).parallel().forEach(segment -> {
			int startTargetSum = (10000 / segmentCnt) * segment;
			int endTargetSumExcl = startTargetSum + (10000 / segmentCnt);
		
			for (int actTargetSum = startTargetSum; actTargetSum < endTargetSumExcl; actTargetSum++) {
				long a, b, c;
				for (int i = 0; i < actTargetSum + 1; i++) {
					a = i;
					for (int j = 0; j < actTargetSum - i + 1; j++) {
						b = j;
						c = actTargetSum - (a + b);
						long lb, lc;
						if(c < 100) {
							if(c < 10) {
								lc = 1;
							} else {
								lc = 2;
							}
						} else {
							if(c < 1000) {
								lc = 3;
							} else {
								lc = 4;
							}
						}
						
						if(b < 100) {
							if(b < 10) {
								lb = 1;
							} else {
								lb = 2;
							}
						} else {
							if(b < 1000) {
								lb = 3;
							} else {
								lb = 4;
							}
						}
						
						long calculated1 = (long)((Math.pow(10, (lb + lc))* a) + (Math.pow(10, lc) * b) + c);
						long calculated2 = (long)((a+b+c)*(a+b+c)*(a+b+c));
						
						if(calculated1 == calculated2) {
							log.info(String.format("Solution found - A: %s, B: %s, C: %s, Big num:  %s", a, b, c, calculated1));
							solutions.add(new long[] {a, b, c});
						}
					}
				}
			}
		});
		
		log.info("END");
	}
}
