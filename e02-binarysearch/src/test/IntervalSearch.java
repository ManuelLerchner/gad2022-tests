package gad.binarysearch.tests.binarysearch;

import gad.binarysearch.BinSea;
import gad.binarysearch.Interval;
import gad.binarysearch.StudentResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class IntervalSearch {

	static Stream<Arguments> binarySearchInterval_Random() {
		return Stream.of(
				Arguments.of(
						new int[]{1, 4, 4, 4, 5, 5, 5, 5, 8},
						Interval.NonEmptyInterval.fromArrayIndices(1, 4),
						Interval.fromArrayIndices(0, 3)),
				Arguments.of(
						new int[]{1, 4, 4, 4, 5, 5, 5, 5, 8},
						Interval.NonEmptyInterval.fromArrayIndices(2, 5),
						Interval.fromArrayIndices(1, 7)),
				Arguments.of(
						new int[]{1, 4, 4, 4, 5, 5, 5, 5, 8, 10, 23},
						Interval.NonEmptyInterval.fromArrayIndices(3, 9),
						Interval.fromArrayIndices(1, 8))
		);
	}

	static Stream<Arguments> binarySearchInterval_Empty() {
		return Stream.of(
				Arguments.of(
						new int[]{1, 4, 4, 4, 5, 5, 5, 5, 8},
						Interval.NonEmptyInterval.fromArrayIndices(6, 7),
						Interval.EmptyInterval.getEmptyInterval()),
				Arguments.of(
						new int[]{1, 4, 4, 4, 5, 5, 5, 5, 8},
						Interval.NonEmptyInterval.fromArrayIndices(10, 16),
						Interval.EmptyInterval.getEmptyInterval()),
				Arguments.of(
						new int[]{1, 4, 4, 4, 5, 5, 5, 5, 8, 2325},
						Interval.NonEmptyInterval.fromArrayIndices(235, 2311),
						Interval.EmptyInterval.getEmptyInterval())
		);
	}

	@ParameterizedTest
	@MethodSource({"binarySearchInterval_Random", "binarySearchInterval_Empty"})
	void testSearch(int[] arr, Interval interval, Interval expectedInterval) {

		var resIntervall = BinSea.search(arr, interval, new StudentResult(), new StudentResult());

		assertEquals(expectedInterval, resIntervall);
	}

}