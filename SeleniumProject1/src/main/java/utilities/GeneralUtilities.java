package utilities;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	int i, j;

	public String getTextForAnElement(WebElement element) {
		String stringText = element.getText();
		return stringText;

	}

	public String getTextForAnElementFromDropDown(WebElement element, int value) {
		Select objWorkersTitle = new Select(element);
		objWorkersTitle.selectByIndex(value);
		String currentTitle = objWorkersTitle.getFirstSelectedOption().getText();
		return currentTitle;
	}

	public String getstylePropertyValues(WebElement element, String propertyType) {
		String cssValue = element.getCssValue(propertyType);
		return cssValue;

	}

	public String getAttributeValue(WebElement element, String attribute) {
		String attributeValue = element.getAttribute(attribute);
		return attributeValue;
	}

	public int getDynamicTableValue(List<WebElement> element, String name) {
		for (i = 0; i < element.size(); i++) {
			if (element.get(i).getText().equals(name)) {
				break;
			}
		}
				return i;
	}
 	public boolean getAllHeaders(List<WebElement> element, List<String> titles) {
		for (i = 0; i < element.size(); i++) {
			for (j = 0; j <titles.size(); j++) {
				if (element.get(i).getText().equals(titles.get(j))) {
					System.out.println(titles.get(j));
					break;
				}
			}
		}
		return true;
	}
	
}
