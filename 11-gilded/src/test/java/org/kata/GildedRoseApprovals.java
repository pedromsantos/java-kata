package org.kata;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;
import org.lambda.functions.Function3;

public class GildedRoseApprovals {

	Function3<String, Integer, Integer, String> doUpdateQuality = (name, sellIn, quality) -> {
		GildedRose app = new GildedRose(new Item[]{new Item(name, sellIn, quality)});
		app.updateQuality();
		return app.items[0].toString();
	};

	@Test
	void coverAll() {
		// String[] itemNames = {"Aged Brie", "foo", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"};
		// Integer[] sellInValues = {-1, 0, 1, 6, 11};
		// Integer[] qualityValues = {-1, 0, 1, 49, 50};

		// CombinationApprovals.verifyAllCombinations(doUpdateQuality, itemNames, sellInValues, qualityValues);
	}
}
