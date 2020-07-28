package br.com.softdigital.ecm.domains;

public class FileStructureNormalDocument extends FileStructureDecorator {

	public FileStructureNormalDocument() {
		this.documentType = 1;
	}
	
	@Override
	public Integer getDocumentType() {
		return this.documentType;
	}
	
}
