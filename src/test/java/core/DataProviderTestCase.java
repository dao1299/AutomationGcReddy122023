package core;

import org.testng.annotations.DataProvider;

public class DataProviderTestCase {
    @DataProvider(name = "test-data-for-tc05")
    public static Object[][] getTestData() throws Exception {
        return ExcelUtils.getTableArray("src/testdata.xlsx", "TC_05", 0, 2);
    }

    @DataProvider(name = "test-data-for-tc06")
    public static Object[][] getTestData1() throws Exception {
        return ExcelUtils.getTableArray("src/testdata.xlsx", "TC_06", 0, 2);
    }


}
