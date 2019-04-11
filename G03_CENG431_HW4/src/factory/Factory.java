package factory;

import helperClasses.FileType;
import products.*;


public class Factory {
	private static Factory instance = new Factory();
	
	private Factory() {};
	
	public static Factory getInstance() {
		return instance;
	}
	
	public IProduct createProduct(FileType type) {
		IProduct product = null;
		switch (type) {
		case XML:
			product = new XmlType();
			break;
		case YAML:
			product = new YamlType();
			break;
		case JSON:
			product = new JsonType();
			break;
		case CSV:
			product = new CsvType();
			break;
		default:
			break;
		}
		return product;
	}
}
