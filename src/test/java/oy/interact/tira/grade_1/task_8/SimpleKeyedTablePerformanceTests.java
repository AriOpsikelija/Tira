package oy.interact.tira.grade_1.task_8;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONTokener;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

import oy.interact.tira.model.Coder;
import oy.interact.tira.student.Algorithms;
import oy.interact.tira.util.JSONConverter;
import oy.interact.tira.util.Pair;
import oy.interact.tira.util.SimpleKeyedContainer;
import oy.interact.tira.util.TIRAKeyedContainer;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Performance tests for simple and slow keyed table SimpleKeyedContainer")
class SimpleKeyedTablePerformanceTests {

	private static final String OUTPUT_FILE_NAME = "compare-simple-keyed-container.csv";
	private static final String SEPARATOR = ",";
	private static int currentIndex = 0;
	private static BufferedWriter writer = null;
	private static final String[] testFiles = {
			"100-city-coders.json",
			"1000-area-coders.json",
			"5000-town-coders.json",
			"10000-large-city-coders.json",
			"50000-country-coders.json",
			"100000-europe-coders.json",
			"1000000-global-coders.json",
			"2000000-milky-way-orion-spur-coders.json"
	};

	private static Coder found = null;
	private static boolean testIsDisabled = false;

	@BeforeAll
	static void openOutputFile() {
		try {
			File f = new File("enable-slow-tests");
			if (f.exists() && !f.isDirectory()) {
				testIsDisabled = false;
			} else {
				testIsDisabled = true;
			}

			writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
			writer.append("** Analysing add(key, value) and to array + sorting speed, times in ms **");
			writer.newLine();
			writer.append("Elements,Add time,Add time/item,To array and sorting,Search time,Search time/item,Testfile");
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			fail("Could not open test output file for writing");
		}
	}

	@Test
	@Order(1)
	// @Timeout(value = 600, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
	void handleReadTestFilesWithSimpleKeyedContainer() {
		if (testIsDisabled) {
			System.out.println("Slow tests disabled, not excuting this one");
			return;
		}
		System.out.println("Slow tests enabled, excuting this one");
		if (null != writer) {
			try {
				currentIndex = 0;
				DecimalFormat df = new DecimalFormat("0.0000", DecimalFormatSymbols.getInstance(Locale.US));
				while (currentIndex < testFiles.length) {
					System.out.format(
							"%d/%d ==> Starting to analyse SimpleKeyedContainer with %s %s%n",
							currentIndex + 1,
							testFiles.length,
							testFiles[currentIndex],
							new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
					final TIRAKeyedContainer<String, Coder> simpleKeyedTable = new SimpleKeyedContainer<>();
					Coder[] coders = readCodersFromFile(testFiles[currentIndex]);
					long start = System.currentTimeMillis();
					for (Coder coder : coders) {
						simpleKeyedTable.add(coder.getId(), coder);
					}
					long end = System.currentTimeMillis();
					long duration = end - start;
					// Also test if all coders are in the hashtable
					assertEquals(coders.length, simpleKeyedTable.size(),
							"Test array size and SimpleKeyedContainer size must be the same");
					System.out.format(" Step 3/6: Adding to SimpleKeyedContainer from Coders array it took %d ms%n",
							duration);

					//// TODOOOOOOO correct order of output, minimizing mem usage (no two arrays)

					writer.append(Long.toString(simpleKeyedTable.size()));
					writer.append(SEPARATOR);
					writer.append(Long.toString(duration));
					writer.append(SEPARATOR);
					String perItem = df.format((double) duration / (double) coders.length);
					writer.append(perItem);
					writer.append(SEPARATOR);

					// Searching
					start = System.currentTimeMillis();
					for (Coder coder : coders) {
						assertDoesNotThrow(() -> found = simpleKeyedTable.get(coder.getId()),
								"SimpleKeyedContainer.get(K) must not throw");
						assertEquals(coder, found, "Found coder must be equal to the searched coder");
					}
					end = System.currentTimeMillis();
					long findDuration = end - start;
					System.out.format(" Step 6/6: Searching SimpleKeyedContainer took %d ms%n", findDuration);

					int codersLength = coders.length;
					coders = null;

					// toArray and sorting
					start = System.currentTimeMillis();
					Pair<String, Coder>[] coders2 = simpleKeyedTable.toArray();
					end = System.currentTimeMillis();
					duration = end - start;
					long totalDuration = duration;
					System.out.format(" Step 4/6: Exporting coders to array it took %d ms%n", duration);
					Comparator<Pair<String, Coder>> comparator = new Comparator<>() {
						@Override
						public int compare(Pair<String, Coder> first, Pair<String, Coder> second) {
							return first.getKey().compareTo(second.getKey());
						}
					};
					start = System.currentTimeMillis();
					Algorithms.fastSort(coders2, comparator);
					end = System.currentTimeMillis();
					duration = end - start;
					System.out.format(" Step 5/6: Sorting exported array took %d ms%n", duration);
					totalDuration += duration;
					writer.append(Long.toString(totalDuration));
					writer.append(SEPARATOR);

					writer.append(Long.toString(findDuration));
					writer.append(SEPARATOR);
					perItem = df.format((double) findDuration / (double) codersLength);
					writer.append(perItem);
					writer.append(SEPARATOR);
					writer.append(testFiles[currentIndex]);
					writer.newLine();
					writer.flush();
					currentIndex++;
				}
				System.out.format("<== Test finished, see file %s for statistics!", OUTPUT_FILE_NAME);
			} catch (OutOfMemoryError oom) {
				System.out.println("\n*** ERROR: Run out of memory while handling test json files\n");
				System.out.println("*** If testing from IDE; try to run the test from command line:");
				System.out.println(
						"*** mvn -Dtest=oy.interact.tira.task_08_hashtable.SimpleKeyedTablePerformanceTests test");
				System.out.format("<== Test finished, see file %s for statistics!%n", OUTPUT_FILE_NAME);
			} catch (Exception e) {
				e.printStackTrace();
				fail("Could not write test output file: " + e.getMessage());
			}
		} else {
			fail("Cannot run tests since opening output file writer failed.");
		}
	}

	@AfterAll
	static void closeOutputFile() {
		try {
			writer.close();
		} catch (IOException e) {
			fail("Could not close test output file");
		}
	}

	private Coder[] readCodersFromFile(String fileName)
			throws IOException {
		long start = System.currentTimeMillis();
		JSONTokener tokener = new JSONTokener(
				new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8)));
		JSONArray array = new JSONArray(tokener);
		System.out.format(" Step 1/6: JSON Parsing - from file %s to JSONArray it took %d ms%n", fileName,
				System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		Coder[] coders = JSONConverter.codersFromJSONArray(array);
		System.out.format(" Step 2/6: From JSONArray to Coders array it took %d ms%n",
				System.currentTimeMillis() - start);
		return coders;
	}
}
