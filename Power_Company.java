public static void main(String[] args) {

	int[] models = { 3, 4, 6, 11, 9 };

	//Count Frequency of model
	Map<Integer, Long> freq = Arrays.stream(models).boxed()
			.collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

	//Sort based on frequency
	Map<Integer, Long> freqSortMap = freq.entrySet().stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(
					Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

	int totalCnt = models.length / 2;

	if (models.length % 2 != 0)
		totalCnt++;

	int modelCnt = 0;

	for (Integer key : freqSortMap.keySet()) {

		if (totalCnt > 0) {
			totalCnt -= freqSortMap.get(key);
			modelCnt++;
		} else {
			break;
		}
	}

	System.out.println(modelCnt);
}